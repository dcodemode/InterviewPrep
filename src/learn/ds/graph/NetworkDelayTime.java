package learn.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

https://leetcode.com/problems/network-delay-time/

*/

public class NetworkDelayTime {

    /**
     * Dijstraws Algo
     * 
     * Time Complexity: O( E Log E)
     * 
     * 
     * Space Complexity: O (N + E) 
     * 
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTime_Dijkstra(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] edge : times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        boolean[] visited = new boolean[N + 1];


        int[] minDis = new int[N + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[K] = 0;
        pq.offer(new int[]{0, K});

        int max = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[1];
            if (visited[currNode]) continue;
            visited[currNode] = true;
            int currDis = curr[0];
            max = currDis;
            N--;
            if (!graph.containsKey(currNode)) continue;
            for (int[] next : graph.get(currNode)) {
                if (!visited[next[0]] && currDis + next[1] < minDis[next[0]])
                    pq.offer(new int[]{currDis + next[1], next[0]});
            }
        }
        return N == 0 ? max : -1;
    }
    
}
