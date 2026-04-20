package PractiseProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Result {
	static class Pair implements Comparable<Pair>{
		int val;
        int idx;
        Pair(int val, int idx) {
        	this.val = val;
        	this.idx = idx;
        }
		@Override
		public int compareTo(Pair o) {
			return Integer.compare(val,o.val);
		}
	}
	public static long totalResponseTime(List<Integer> responseTimes) {
		int n = responseTimes.size();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int[] visited = new int[n];
		for(int i = 0; i < n; i++) {
			pq.offer(new Pair(responseTimes.get(i), i));
		}
		
		long ans = 0;
		
		while(!pq.isEmpty()) {
			Pair id = pq.poll();
			if(visited[id.idx] == 1) {
				continue;
			}
			visited[id.idx] = 1;
			if(id.idx - 1 >= 0)
			visited[id.idx - 1] = 1;
			if(id.idx + 1 < n)
			visited[id.idx + 1] = 1;
			ans += id.val;
		}
		return ans;
		
		
	}
}


class Solve3 {
	public static List<String> classifytexts(List<String>texts, List<String>spamWords) {
		Map<String, Integer> mp = new HashMap<>();
		for(String s : spamWords) {
			mp.put(s.toLowerCase(), mp.getOrDefault(s, 0) + 1);
		}
		List<String> ans = new ArrayList<>();
		for(String word : texts) {
			String[] w = word.split(" ");
			int cnt = 0;
			for(String s: w) {
				if(mp.containsKey(s.toLowerCase())) {
					cnt++;
				}
			}
			if(cnt >= 2) {
				ans.add("spam");
			}
			else {
				ans.add("not_spam");
			}
		}
		return ans;
	}
}
class Solve4 {
	public static int solve(String s) {
	    int[] freq = new int[26];
	    int max = 0;
	    
	    for (char c : s.toCharArray()) {
	        max = Math.max(max, ++freq[c - 'a']);
	    }

	    int ans = s.length();

	    for (int target = 1; target <= max; target++) {
	        int del = 0;

	        for (int f : freq) {
	            if (f > 0) {
	                del += (f < target) ? f : (f - target);
	            }
	        }

	        ans = Math.min(ans, del);
	    }

	    return ans;
	}
}
public class exmple1 {
     public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		List<Integer> response = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int temp = scanner.nextInt();
			response.add(temp);
			
		}
		//System.out.println(Solve5.totalResponseTime(response));
	}
}
