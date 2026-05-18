package PractiseProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Infosys {
   public static int solve(int N, int M, int B, int[][] grid) {
	   
	   int max = Integer.MIN_VALUE;	   
	   for (int j = 0; j < M; j++) {
	        max = Math.max(max, dfs(grid, B, 0, j, grid[0][j]));
	    }
	    return max;
   }
   public static int dfs(int[][] grid, int B, int row, int prevCol, int sum) {
	    int n = grid.length;
	    int m = grid[0].length;

	    if (row == n - 1) {
	        return sum;
	    }

	    int max = Integer.MIN_VALUE;

	    for (int j = 0; j < m; j++) {
	        int bonus = (j > prevCol) ? B : 0;
	        int val = dfs(grid, B, row + 1, j, sum + grid[row + 1][j] + bonus);
	        max = Math.max(max, val);
	    }

	    return max;
	}
      
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int n = sc.nextInt();
	   int m = sc.nextInt();
	   int b = sc.nextInt();
	   int[][] grid = new int[n][m];
	   for(int i = 0; i < n; i++) {
		   for(int j = 0; j < m; j++) {
			   grid[i][j] = sc.nextInt();
		   }
	   }
	   int result = solve(n,m,b,grid);
	   System.out.println(result);
   }
}
