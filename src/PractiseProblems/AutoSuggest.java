package PractiseProblems;

class Solve {
	static int findDistance(String a, String b) {
		int n = a.length();
		int m = b.length();
		
		int[][] dp = new int[n + 1][m + 1];
		
		for(int i = 0; i <= n; i++) {
			dp[i][0] = i;
		}
		for(int j = 0; j <= m; j++) {
			dp[0][j] = j;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}
				else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}
			}
		}
		return dp[n][m];
		
	}
	static String solve(int N, String[] words, String S) {
		String result = "";
		int ans = Integer.MAX_VALUE;
		
		for(String word : words) {
			int temp = findDistance(word, S);
			if(temp < ans) {
				result = word;
				ans = temp;
			}
			else if(temp == ans && word.compareTo(result) < 0) {
				result = word;
			}
		}
		return result;
		
	}
}
public class AutoSuggest {
   public static void main(String[] args) {
	  String[] wordStrings = {"tocor", "torect", "tocfrrec", "tocorre"};
	  String s = "tocorrect";
 	  System.out.println(Solve.solve(5, wordStrings, s)); 
}
}
