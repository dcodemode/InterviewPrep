package learn.ds.graph;


/**

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst

https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightWithKStops {

    /**
     * BellMan - Fords (Basic DP Solution)
     * Time Complexity: O(K * E) where K is the number of stops and E is the number of Edges;
     * Space Complexity: O(V^2 * K*V) where V is number of Vertices
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        if(src == dst){
            return 0;
        }
        
        // Bellman - Fords algo
        
        int[] previous = new int[n];
        int[] current = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            previous[i] = Integer.MAX_VALUE;
            current[i] = Integer.MAX_VALUE;
        }
        
        previous[src] = 0;
        
        // Relaxations
        for(int i = 1 ; i <= k+1 ; i++){
            current[src] = 0;
            
            for(int[] flight : flights){
                int preFlight = flight[0];
                int currFlight = flight[1];
                int cost = flight[2];
                
                if(previous[preFlight] < Integer.MAX_VALUE   ){
                    current[currFlight] = Math.min(previous[preFlight]  + cost, current[currFlight]);
                }
            }
            
            previous = current.clone();
        }
        
        return current[dst] == Integer.MAX_VALUE ? -1 : current[dst];
        
    }
    
}
