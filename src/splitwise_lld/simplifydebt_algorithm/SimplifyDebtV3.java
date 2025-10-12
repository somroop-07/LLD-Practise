package splitwise_lld.simplifydebt_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class SimplifyDebtAlgorithmV3 {
    
    static class Person {
        int id;
        int balance;
        
        Person(int id, int balance) {
            this.id = id;
            this.balance = balance;
        }
    }
    
    public static List<List<Integer>> simplify(int[][] transactions) {
        // Calculate net balances
        Map<Integer, Integer> balanceMap = new HashMap<>();
        for (int[] transaction : transactions) {
            int from = transaction[0];
            int to = transaction[1];
            int amount = transaction[2];
            balanceMap.put(from, balanceMap.getOrDefault(from, 0) - amount);
            balanceMap.put(to, balanceMap.getOrDefault(to, 0) + amount);
        }
        
        // MAX HEAP for creditors (largest positive balance first)
        PriorityQueue<Person> creditors = new PriorityQueue<>((a, b) -> b.balance - a.balance);
        
        // MAX HEAP for debtors (largest debt first - stored as positive)
        PriorityQueue<Person> debtors = new PriorityQueue<>((a, b) -> b.balance - a.balance);
        
        // Separate debtors and creditors
        for (Map.Entry<Integer, Integer> entry : balanceMap.entrySet()) {
            int personId = entry.getKey();
            int balance = entry.getValue();
            if (balance > 0) {
                creditors.offer(new Person(personId, balance));
            } else if (balance < 0) {
                debtors.offer(new Person(personId, -balance)); // Store debt as positive
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Greedy settlement: Largest debtor pays largest creditor
        while (!debtors.isEmpty() && !creditors.isEmpty()) {
            Person largestDebtor = debtors.poll();
            Person largestCreditor = creditors.poll();
            
            int settlementAmount = Math.min(largestDebtor.balance, largestCreditor.balance);
            
            // Add transaction: debtor owes creditor
            result.add(Arrays.asList(largestDebtor.id, largestCreditor.id, settlementAmount));
            
            // Update remaining balances
            int remainingDebt = largestDebtor.balance - settlementAmount;
            int remainingCredit = largestCreditor.balance - settlementAmount;
            
            if (remainingDebt > 0) {
                debtors.offer(new Person(largestDebtor.id, remainingDebt));
            }
            
            if (remainingCredit > 0) {
                creditors.offer(new Person(largestCreditor.id, remainingCredit));
            }
        }
        
        return result;
    }
}
public class SimplifyDebtV3 {
	  public static void main(String[] args) {
//			int[][] transactions = {{1,2,1000},{1,3,2000},{3,2,500}};
//		  int[][] transactions = {{1,2,100},{2,1,100}}; 
//		  int[][] transactions = {{1,2,1000},{2,3,1000},{3,1,1000}}; 
		  int[][] transactions = {{2,1,500},{3,1,300},{4,1,200}};
			List<List<Integer>> simplifiedTransactionsList = SimplifyDebtAlgorithmV3.simplify(transactions);
			if(simplifiedTransactionsList.size() == 0) {
				System.out.println("Everyone is settled ! ");
			}
			for(List<Integer> list: simplifiedTransactionsList) {
				System.out.println("User " + list.get(0) + " owes " + list.get(1) + " Rs." + list.get(2));
			}
		}
}