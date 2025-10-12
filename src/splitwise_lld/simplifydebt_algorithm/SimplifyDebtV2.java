package splitwise_lld.simplifydebt_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair {
	Integer first;
	Integer second;
	public Pair(Integer p1, Integer p2) {
		super();
		this.first = p1;
		this.second = p2;
	}	
}
class SimplifyDebtAlgorithmV2 {
	
	public static List<List<Integer>> simplify(int[][] transactions) {
		Map<Integer, Integer> userBalance = new HashMap<>();
		for(int[] v: transactions) {
			int from = v[0];
			int to = v[1];
			int amount = v[2];
			userBalance.put(from, userBalance.getOrDefault(from, 0) - amount); //Incoming - Outgoing
			userBalance.put(to, userBalance.getOrDefault(to, 0) + amount); //Incoming - Outgoing
		}
		List<Pair> balanceList = new ArrayList<>();
		for(Map.Entry<Integer, Integer> mpEntry : userBalance.entrySet()) {
			int amount = mpEntry.getValue();
			if(amount != 0) {
				balanceList.add(new Pair(mpEntry.getValue(),mpEntry.getKey()));
			}
		}
//		for(Pair v : balanceList) {
//			System.out.println(v.second + "owes " + v.first);
//		}
		List<List<Integer>> tempList = new ArrayList<>();
		List<List<Integer>> resultList = new ArrayList<>();
		calculateMinTransactionsV2(balanceList, tempList, resultList, 0);
		return resultList;
	}

	private static void calculateMinTransactionsV2(List<Pair> balanceList, List<List<Integer>> tempList,
			List<List<Integer>> resultList, int i) {
		while(i < balanceList.size() && balanceList.get(i).first == 0) {
			i++;
		} // Skip if value 0
		
		if(i == balanceList.size()) {
			if(resultList.isEmpty() ||tempList.size() < resultList.size()) {  //Min Case
				resultList.clear();
				for(List<Integer> list: tempList) {
					resultList.add(new ArrayList<>(list));
				}
			}
			return;
		}
		Pair currVal = balanceList.get(i);
		for(int k = i + 1; k < balanceList.size(); k++) {
			Pair nextVal = balanceList.get(k);
			if(currVal.first * nextVal.first < 0) {
				int transactionAmount = Math.min(Math.abs(currVal.first), Math.abs(nextVal.first)); //Takes the min to avoid overpaying
				if(currVal.first < 0) {
					tempList.add(new ArrayList<>(Arrays.asList(currVal.second,nextVal.second,transactionAmount)));
				}
				else {
					tempList.add(new ArrayList<>(Arrays.asList(nextVal.second,currVal.second,transactionAmount)));
				}
				int currBalance = currVal.first + (currVal.first < 0 ? transactionAmount : -transactionAmount);
				int nextBalance = nextVal.first + (nextVal.first < 0 ? transactionAmount : -transactionAmount);
				balanceList.set(i, new Pair(currBalance, nextVal.second));
				balanceList.set(k, new Pair(nextBalance, nextVal.second));
				calculateMinTransactionsV2(balanceList, tempList, resultList, i);
				tempList.remove(tempList.size() - 1);
				balanceList.set(i, currVal); //BackTracking
				balanceList.set(k, nextVal);
			}
		}
		
	}	
	
}
public class SimplifyDebtV2 {
	  public static void main(String[] args) {
//			int[][] transactions = {{1,2,1000},{1,3,2000},{3,2,500}};
//		  int[][] transactions = {{1,2,100},{2,1,100}}; 
//		  int[][] transactions = {{1,2,1000},{2,3,1000},{3,1,1000}}; 
		  int[][] transactions = {{2,1,500},{3,1,300},{4,1,200}};
			List<List<Integer>> simplifiedTransactionsList = SimplifyDebtAlgorithmV2.simplify(transactions);
			if(simplifiedTransactionsList.size() == 0) {
				System.out.println("Everyone is settled ! ");
			}
			for(List<Integer> list: simplifiedTransactionsList) {
				System.out.println("User " + list.get(0) + " owes " + list.get(1) + " Rs." + list.get(2));
			}
		}
}
