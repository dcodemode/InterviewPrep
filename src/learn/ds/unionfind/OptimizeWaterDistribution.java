package learn.ds.unionfind;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 1168. Optimize Water Distribution in a Village
 *
 * There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
 *
 * For each house i, we can either build a well inside it directly with cost wells[i - 1] (note the -1 due to 0-indexing), or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes, where each pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j and house2j together using a pipe. Connections are bidirectional.
 *
 * Return the minimum total cost to supply water to all houses.
 *
 *
 *
 * Example 1:
 *              1
 *             /
 *          1 /
 *           /
 *         2 ----------- 3
 *                1
 *
 * Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * Output: 3
 * Explanation:
 * The image shows the costs of connecting houses using pipes.
 * The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.
 * Example 2:
 *
 * Input: n = 2, wells = [1,1], pipes = [[1,2,1]]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 2 <= n <= 104
 * wells.length == n
 * 0 <= wells[i] <= 105
 * 1 <= pipes.length <= 104
 * pipes[j].length == 3
 * 1 <= house1j, house2j <= n
 * 0 <= costj <= 105
 * house1j != house2j
 *
 * https://leetcode.com/problems/optimize-water-distribution-in-a-village/
 */
public class OptimizeWaterDistribution {

    class UnionFind {
        /**
         * Implementation of UnionFind without load-balancing.
         */
        private int[] root;
        private int[] rank;

        public UnionFind(int size) {
            // container to hold the group id for each member
            // Note: the index of member starts from 1,
            // thus we add one more element to the container.
            root = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 0; i < size + 1; ++i) {
                root[i] = i;
                rank[i] = 0;
            }
        }

        /**
         * return the group id that the person belongs to.
         */
        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        /**
         * Join the groups together.
         * return:
         * false when the two persons belong to the same group already,
         * otherwise true
         */
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }

            // attach the group of lower rank to the one with higher rank
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootX] = rootY;
                rank[rootY] += 1;
            }
            return true;
        }
    }

    /**
     * Time Complexity: O((N+M)⋅log(N+M))
     *
     * First, we build a list of edges, which takes O(N + M) time.
     *
     * We then sort the list of edges, which takes O((N+M)⋅* log(N+M))  time.
     *
     * At the end, we iterate through the sorted edges. For each iteration, we invoke a Union-Find operation.
     * Hence, the time complexity for iteration is O((N+M)∗log(N)).
     *
     * To sum up, the overall time complexity of the algorithm is O((N+M)⋅log(N+M)) which is dominated by the sorting step.
     *
     * Space Complexity: O(N+M)O(N+M)
     *
     * @param n
     * @param wells
     * @param pipes
     * @return
     */
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> orderedEdges = new ArrayList<>();

        // add the virtual vertex (index with 0) along with the new edges.
        for (int i = 0; i < wells.length; ++i) {
            orderedEdges.add(new int[]{0, i + 1, wells[i]});
        }

        // add the existing edges
        for (int[] pipe : pipes) {
            orderedEdges.add(pipe);
        }

        // sort the edges based on their cost (Kruskals A)
        Collections.sort(orderedEdges, (a, b) -> a[2] - b[2]);

        // iterate through the ordered edges
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        for (int[] edge : orderedEdges) {
            int house1 = edge[0];
            int house2 = edge[1];
            int cost = edge[2];
            // determine if we should add the new edge to the final MST
            if (uf.union(house1, house2)) {
                totalCost += cost;
            }
        }

        return totalCost;
    }
}
