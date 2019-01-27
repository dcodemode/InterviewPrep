package learn.algo.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @timestamp: 1/26/19 6:52 PM
 * @author: Varma Penmetsa
 *
 * Problem:
 * Budget Shopping
 *
 * Helen has n dollars budgeted to purchase Math notebooks. There are m stores that stock unlimited supplies of notebooks in bundles,
 * but the size and price of the bundles vary from store to store. Helen can purchase as many bundles as she wants from as many stores
 * as necessary until she depletes her budget, but her goal is to purchase a maximal number of notebooks. For example,
 * if Helen has n = 5 dollars and there are m = 2 shops where one sells 4-notebook bundles for 2 dollars a piece and the other sells
 * 2-notebook bundles for 1 dollar a piece, she will buy a total of 4 + 4 + 2 = 10 notebooks (two bundles of 4 from the first shop and
 * one bundle of 2 from the second shop).
 *
 * Constraints
 *
 *     1 ≤ n ≤ 104
 *     1 ≤ m ≤ 102
 *     1 ≤ bundleQuantitiesi ≤ 20
 *     1 ≤ bundleCostsi ≤ 200
 *
 * Input Format For Custom Testing
 *
 * The first line contains an integer, n, denoting the number of dollars in Helen's notebook budget.
 *
 * The next line contains an integer, m, denoting the number of shops.
 *
 * Each line i of the m subsequent lines (where 0 ≤ i < m) contains an integer describing bundleQuantitiesi.
 *
 * The next line contains an integer, m, denoting the number of shops.
 *
 * Each line i of the m subsequent lines (where 0 ≤ i < m) contains an integer describing bundleCostsi.
 * Sample Case 0
 *
 * Sample Input
 *
 * 50
 * 2
 * 20
 * 19
 * 2
 * 24
 * 20
 *
 * References:
 * hackerrank
 *
 *
 */
public class BudgetShopping {

    static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {

        if (n <= 0
                || bundleCosts == null || bundleQuantities == null
                || bundleCosts.size() == 0 || bundleQuantities.size() == 0
                || bundleCosts.size() != bundleQuantities.size()
                ) {
            return 0;
        }

        final int[] max = {0};

        calculateRecursive(n, bundleCosts, bundleQuantities, max, 0, 0);

        return max[0];
    }

    //To-Do Recursion time out
    static void calculateRecursive(int n, List<Integer> cost, List<Integer> quantity, int[] max, int position, int count) {
        if (n == 0 || position == cost.size()) {
            if (count > max[0]) {
                max[0] = count;
            }
            return;
        }
        for (int i = 0; i <= n / cost.get(position); i++) {
            calculateRecursive(n - i * cost.get(position), cost, quantity, max, position + 1, count + i * quantity.get(position));
        }
    }

    public static void main(String[] args) {

        List<Integer> bundleQuantities =  new ArrayList<>();
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);
        bundleQuantities.add(20);
        bundleQuantities.add(1);

        List<Integer> bundleCosts = new ArrayList<>();
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);
        bundleCosts.add(2);
        bundleCosts.add(12);

        System.out.println(budgetShopping(50,bundleQuantities,bundleCosts));
    }

}
