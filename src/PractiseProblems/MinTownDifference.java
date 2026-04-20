package PractiseProblems;

import java.util.ArrayList;
import java.util.List;

public class MinTownDifference {
	public static void main(String[] args) {
		   int N = 3;
		    int[] towns = {5, 10, 15};
		    int[][] roads = {{1,2},{2,3}};
		    System.out.println(Solve2.minTownDifference(N, towns,roads));
	}
 
}
class Solve2 {

    static int minDiff;
    static int totalSum;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] towns;

    static int dfs(int node) {
        visited[node] = true;
        int subtreeSum = towns[node];

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                subtreeSum += dfs(neighbor);
            }
        }

        int diff = Math.abs(totalSum - 2 * subtreeSum);
        minDiff = Math.min(minDiff, diff);

        return subtreeSum;
    }

    static int minTownDifference(int N, int[] townsArr, int[][] roads) {
        towns = townsArr;
        graph = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0] - 1;
            int v = road[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        totalSum = 0;
        for (int t : towns) totalSum += t;

        minDiff = Integer.MAX_VALUE;
        dfs(0); 

        return minDiff;
    }
}