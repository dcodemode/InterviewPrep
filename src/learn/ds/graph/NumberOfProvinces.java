package learn.ds.graph;


/**
 *
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 * Constraints:
 *  1 <= n <= 200
 *  n == isConnected.length
 *  n == isConnected[i].length
 *  isConnected[i][j] is 1 or 0.
 *  isConnected[i][i] == 1
 *  isConnected[i][j] == isConnected[j][i]
 *
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {

    class UnionFind{

        private int[] root, rank;
        private int count = 0;

        public UnionFind(int m){
            root = new int[m];
            rank = new int[m];
            count = m;

            for(int i = 0 ; i < m ; i++ ){
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(x == root[x]){
                return x;
            }
            return root[x] = find(root[x]);
        }


        public void union(int x, int y){
            int rootX =  find(x);
            int rootY = find(y);

            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    root[rootY] = rootX;
                }else if(rank[rootX] < rank[rootY]){
                    root[rootX] = rootY;
                }else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;

                }
                count--;
            }
        }


        public int count(){
            return count;
        }

    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected[0].length;
        UnionFind uf = new UnionFind(m);

        for(int i =0 ; i < m ; i++){
            for(int j = 0 ;  j < m ; j++){
                if(isConnected[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        return uf.count;
    }

}
