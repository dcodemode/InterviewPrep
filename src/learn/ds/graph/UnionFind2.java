package learn.ds.graph;

/**
 * Union by Rank of Disjoint Set
 *
 * Time Complexity: O(N)
 *
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3840/
 */
public class UnionFind2 {

    private int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank;

    public UnionFind2(int size){
        root = new int[size];
        rank = new int[size];

        for(int i = 0; i < size ; i++){
            root[i] = i;
            // The initial "rank" of each vertex is 1, because each of them is a standalone vertex with no connection to other vertices.
            rank[i] = 1;
        }
    }

    /**
     * Time Complexity: O(log N)
     * @param x
     * @return
     */
    public int find(int x){
        while (root[x] != x){
            x  = root[x];
        }
        return root[x];
    }

    /**
     * Time Complexity: O(log N)
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
     * Time Complexity: O(log N)
     * @param x
     * @param y
     * @return
     */
    public boolean connected(int x, int y){
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        UnionFind2 uf = new UnionFind2(10);

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
