package learn.ds.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

We are working on a security system for a badged-access room in our company's building.

We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day. 
Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

Write a function that finds anyone who badged into the room three or more times in a one-hour period. 
Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period. 
If there are multiple one-hour periods where this was true for an employee, 
just return the earliest one for that employee.

badge_times = [
  ["Paul",      "1355"], ["Jennifer",  "1910"], ["Jose",    "835"],
  ["Jose",       "830"], ["Paul",      "1315"], ["Chloe",     "0"],
  ["Chloe",     "1910"], ["Jose",      "1615"], ["Jose",   "1640"],
  ["Paul",      "1405"], ["Jose",       "855"], ["Jose",    "930"],
  ["Jose",       "915"], ["Jose",       "730"], ["Jose",    "940"],
  ["Jennifer",  "1335"], ["Jennifer",   "730"], ["Jose",   "1630"],
  ["Jennifer",     "5"], ["Chloe",     "1909"], ["Zhang",     "1"],
  ["Zhang",       "10"], ["Zhang",      "109"], ["Zhang",   "110"],
  ["Amos",         "1"], ["Amos",         "2"], ["Amos",    "400"],
  ["Amos",       "500"], ["Amos",       "503"], ["Amos",    "504"],
  ["Amos",       "601"], ["Amos",       "602"], ["Paul",   "1416"]
];

Expected output (in any order)
   Paul: 1315 1355 1405
   Jose: 830 835 855 915 930
   Zhang: 10 109 110
   Amos: 500 503 504

n: length of the badge records array


*/

public class BadgeAccessMergeIntervals {

    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * @param input
     * @return
     */
    public static Map<String, List<Integer>> countIntervals(String[][] input) {
        Map<String, List<Integer>> map = new HashMap<>();

        // First Pass
        for (String[] interval : input) {
            String person = interval[0];
            int time = Integer.valueOf(interval[1]);
            if (map.containsKey(person)) {
                map.get(person).add(time);
            } else {
                List<Integer> timeSlot = new ArrayList<>();
                timeSlot.add(time);
                map.put(person, timeSlot);
            }
        }

        // Seconds pass, sorting lists
        List<String> persons = new ArrayList<>();
        List<List<Integer>> times = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            
            List<Integer> intervals = entry.getValue();
            Collections.sort(entry.getValue());

            // Merging intervals in o(n) time
            int left = 0;
            int right = 1;

            while (right < intervals.size()) {
                if (intervals.get(right) - intervals.get(left) <= 100) {
                    right++;
                } else {
                    left++;
                    right = left + 1;
                }

                if (right - left >= 3) {
                    persons.add(entry.getKey());
                    List<Integer> temp = new ArrayList<>();
                    for (int i = left; i < right; i++) {
                        temp.add(intervals.get(i));
                    }
                    times.add(temp);
                    break;
                }
            }
        }

        // Building ans Map
        Map<String, List<Integer>> ans = new HashMap<>();
        for (int i = 0; i < persons.size(); i++) {
            ans.put(persons.get(i), times.get(i));
        }
        return ans;
    }

    public static void main(String[] argv) {
        String[][] badgeTimes = new String[][] {
                { "Paul", "1355" },
                { "Jennifer", "1910" },
                { "Jose", "835" },
                { "Jose", "830" },
                { "Paul", "1315" },
                { "Chloe", "0" },
                { "Chloe", "1910" },
                { "Jose", "1615" },
                { "Jose", "1640" },
                { "Paul", "1405" },
                { "Jose", "855" },
                { "Jose", "930" },
                { "Jose", "915" },
                { "Jose", "730" },
                { "Jose", "940" },
                { "Jennifer", "1335" },
                { "Jennifer", "730" },
                { "Jose", "1630" },
                { "Jennifer", "5" },
                { "Chloe", "1909" },
                { "Zhang", "1" },
                { "Zhang", "10" },
                { "Zhang", "109" },
                { "Zhang", "110" },
                { "Amos", "1" },
                { "Amos", "2" },
                { "Amos", "400" },
                { "Amos", "500" },
                { "Amos", "503" },
                { "Amos", "504" },
                { "Amos", "601" },
                { "Amos", "602" },
                { "Paul", "1416" },
        };
        
        System.out.println(countIntervals(badgeTimes).toString());

    }
}
