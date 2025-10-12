package splitwise_lld.simplifydebt_algorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SimplifyDebtAlgorithm {
	
	public static int simplify(int[][] transactions) {
		Map<Integer, Integer> userBalance = new HashMap<>();
		for(int[] v: transactions) {
			int from = v[0];
			int to = v[1];
			int amount = v[2];
			userBalance.put(from, userBalance.getOrDefault(from, 0) - amount);
			userBalance.put(to, userBalance.getOrDefault(to, 0) + amount);
		}
		List<Integer> balanceList = new ArrayList<>();
		for(Map.Entry<Integer, Integer> mpEntry : userBalance.entrySet()) {
			int amount = mpEntry.getValue();
			if(amount != 0) {
				balanceList.add(amount);
			}
		}
		for(int v : balanceList) {
			System.out.println(v);
		}
		return calculateMinTransactions(balanceList, 0);
	}

public static int calculateMinTransactions(List<Integer> balanceList, int i) {
	while (i < balanceList.size() && balanceList.get(i) == 0) i++;
	if(i >= balanceList.size()) {
		return 0;
	}
	int currVal = balanceList.get(i);
	int mn = Integer.MAX_VALUE;
	for(int k = i + 1; k < balanceList.size(); k++) {
		int nextVal = balanceList.get(k);
		if(currVal * nextVal < 0) {
			balanceList.set(k,currVal + nextVal);
			mn = Math.min(mn, 1 + calculateMinTransactions(balanceList, i + 1));
			balanceList.set(k, nextVal);
		}
	}
	return mn == Integer.MAX_VALUE ? 0 : mn;
}
}

public class SimplifyDebt {
     public static void main(String[] args) {
		int[][] transactions = {{1,2,1000},{1,3,2000},{3,2,500}};
		System.out.println("No of transactions : " + SimplifyDebtAlgorithm.simplify(transactions));
	}
}
