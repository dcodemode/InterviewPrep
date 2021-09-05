package learn.ds.unionfind;

/**
 * Union by Rank and Path Compression Disjoint Set
 *
 *
 * The main idea of a “disjoint set” is to have all connected vertices have the same parent node or root node,
 * whether directly or indirectly connected. To check if two vertices are connected, we only need to check if they have the same root node.
 *
 * The two most important functions for the “disjoint set” data structure are the find function and the union function.
 * The find function locates the root node of a given vertex.
 * The union function connects two previously unconnected vertices by equating their root node.
 * There is another important function named connected, which checks the “connectivity” of two vertices.
 * The find and union functions are essential for any question requiring the “disjoint set” data structure,
 * while only some of the questions need the connected function.
 *
 * Time Complexity: O(N)
 *
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3844/
 */
public class UnionFind {

    private int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank;

    public UnionFind(int size){
        root = new int[size];
        rank = new int[size];

        for(int i = 0; i < size ; i++){
            root[i] = i;
            // The initial "rank" of each vertex is 1, because each of them is a standalone vertex with no connection to other vertices.
            rank[i] = 1;
        }
    }

    /**
     * Time Complexity:  O(⍺(N))  | ⍺ refers to the Inverse Ackermann function.
     *
     * In practice, we assume it's a constant. In other words, O(⍺(N)) is regarded as O(1) on average.
     * @param x
     * @return
     */
    public int find(int x){
        if (x == root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }

    /**
     * Time Complexity:  O(⍺(N))
     * @param x
     * @param y
     */
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if (rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else {
                root[rootY] = rootX;
                rank[rootX] +=1;
            }
        }
    }

    /**
     * Time Complexity: O(⍺(N))
     * @param x
     * @param y
     * @return
     */
    public boolean connected(int x, int y){
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);

        // 1-2-5-6-7   3-8-9   4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);

        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false


        // 1-2-5-6-7   3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
