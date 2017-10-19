package com.leetcode.problem;

import java.util.*;

/**
 * Number of Connected Components in an Undirected Graph
 *
 * DFS a forest. Set.
 */
public class Problem323 {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                dfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }

    /**
     * dfs to traverse a graph
     * @param i node to start
     * @param map all edges
     * @param visited visited nodes
     */
    private void dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        for (int j : map.get(i)) { // dfs visit each adjacent node if not visited before
            if (visited.add(j)) {
                dfs(j, map, visited);
            }
        }
    }
}
