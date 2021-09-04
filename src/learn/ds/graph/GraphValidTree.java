package learn.ds.graph;

/**
 *
 * 261. Graph Valid Tree
 *
 * You have a graph of n nodes labeled from 0 to n - 1.
 * You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected
 * edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * Example 1:
 *
 *       0
 *     / | \
 *    1  2  3
 *    |
 *    4
 *
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 *
 * Example 2:
 *
 *   0 - 1 - 2
 *       | \ |
 *      4   3
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= 2000 <= n
 * 0 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no self-loops or repeated edges.
 *
 * https://leetcode.com/problems/graph-valid-tree
 *
 */
public class GraphValidTree {
    class UnionFind{
        int[] root;
        int[] rank;

        public UnionFind(int n){
            root = new int[n];
            rank = new int[n];

            for(int i = 0 ; i < n ; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(x  == root[x]){
                return x;
            }
            return root[x] = find(root[x]);
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if(rootX != rootY){
                if(rank[rootX] > rank[rootY] ){
                    root[rootY] = rootX;
                }else if(rank[rootX] < rank[rootY] ){
                    root[rootX] = rootY;
                }else{
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                return true;
            }else{
                return false;
            }
        }

        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }

    }

    public boolean validTree(int n, int[][] edges) {
        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) return false;

        UnionFind uf = new UnionFind(n);

        for(int[] edge : edges){
            if(uf.union(edge[0], edge[1]) == false){
                return false;
            }
        }

        return true;
    }

}
