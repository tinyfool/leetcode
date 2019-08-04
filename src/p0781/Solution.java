package p0781;


import java.util.HashMap;
import java.util.HashSet;
//Runtime: 3 ms, faster than 69.29% of Java online submissions for Rabbits in Forest.
//Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Rabbits in Forest.

public class Solution {

    public int numRabbits(int[] answers) {

        int s = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : answers) {

            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : map.keySet()) {

            int count = map.get(n);
            int pair = count / (n + 1);
            if (count % (n + 1) != 0)
                pair += 1;
            s += pair*(n+1);
        }
        return s;
    }

}
