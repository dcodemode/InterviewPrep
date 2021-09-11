package learn.ds.unionfind;

import learn.util.ArrayUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 399. Evaluate Division
 *
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 *
 * https://leetcode.com/problems/evaluate-division/
 *
 */
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

        public void union(int x, int y, double val) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            root[rootX] = rootY;
            weight[rootX] = weight[y] * val / weight[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationLen = equations.size();
        int queryLen = queries.size();

        UnionFind uf = new UnionFind(2 * equationLen);
        Map<String, Integer> hash = new HashMap<>(2 * equationLen);
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
