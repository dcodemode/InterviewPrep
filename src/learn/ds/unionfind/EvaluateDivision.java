package learn.ds.unionfind;

import learn.util.ArrayUtil;

import java.util.HashMap;
import java.util.List;

public class EvaluateDivision {

    private class UnionFind {

        private int[] root;
        private double[] weight;


        public UnionFind(int n) {
            root = new int[n];
            weight = new double[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
                weight[i] = 1.0d;
            }
        }

        public int find(int x) {
            if (root[x] != x) {
                int origin = root[x];
                root[x] = find(root[x]);
                weight[x] *= weight[origin];
            }
            return root[x];
        }

        public void union(int p, int q, double val) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            root[rootP] = rootQ;
            weight[rootP] = weight[q] * val / weight[p];
        }

        public double isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return weight[p] / weight[q];
            } else {
                return -1.0d;
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationLen = equations.size();
        int queryLen = queries.size();

        UnionFind uf = new UnionFind(2 * equationLen);
        HashMap<String, Integer> hash = new HashMap<>(2 * equationLen);
        double[] result = new double[queryLen];

        int idx = 0;
        for (int i = 0; i < equationLen; i++) {
            String str1 = equations.get(i).get(0);
            String str2 = equations.get(i).get(1);
            if (!hash.containsKey(str1)) {
                hash.put(str1, idx);
                idx++;
            }
            if (!hash.containsKey(str2)) {
                hash.put(str2, idx);
                idx++;
            }
            uf.union(hash.get(str1), hash.get(str2), values[i]);
        }
        for (int i = 0; i < queryLen; i++) {
            String str1 = queries.get(i).get(0);
            String str2 = queries.get(i).get(1);
            if (!hash.containsKey(str1) || !hash.containsKey(str2)) {
                result[i] = -1.0d;
            } else {
                result[i] = uf.isConnected(hash.get(str1), hash.get(str2));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[]values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};

        EvaluateDivision e = new EvaluateDivision();
        e.calcEquation(ArrayUtil.twoDStringArrayToList(equations), values, ArrayUtil.twoDStringArrayToList(queries));
    }
}
