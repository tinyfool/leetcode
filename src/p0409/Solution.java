package p0409;

import java.util.HashMap;
import java.util.Map;
//Runtime: 6 ms, faster than 28.46% of Java online submissions for Longest Palindrome.
//Memory Usage: 36 MB, less than 98.95% of Java online submissions for Longest Palindrome.
public class Solution {

    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {

            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int bigOdd = 0;
        char bigChar = 0;
        int sum = 0;
        for (char c :
                map.keySet()) {
            int count = map.get(c);
            if (count % 2 == 1) {
                if (count > bigOdd) {
                    bigOdd = count;
                    bigChar = c;
                }
            }
        }
        if (bigOdd != 0) {
            sum += bigOdd;
            map.remove(bigChar);
        }
        for (char c :
                map.keySet()) {
            int count = map.get(c);
            if (count % 2 == 1) {
                sum += count - 1;
            } else {

                sum += count;
            }
        }
        return sum;
    }
}
