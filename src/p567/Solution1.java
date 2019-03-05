package p567;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    private List<Integer> findAnagrams(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();
        int count = 0;
        int pCount = 0;
        List<Integer> ans = new ArrayList<Integer>();
        int[] dict = new int[256];

        for (int i = 0; i < pLength; i++) {

            char c = p.charAt(i);
            dict[c]++;
        }

        for (char c = 0; c < 256; c++) {

            if (dict[c] > 0)
                pCount++;
        }

        for (int i = 0; i < pLength - 1; i++) {

            char cr = s.charAt(i);
            dict[cr]--;
            if (dict[cr] == 0) {
                count++;
            }
        }

        int i = 0;
        for (i = 0; i < sLength - pLength + 1; i++) {

            int right = i + pLength - 1;
            char cr = s.charAt(right);
            dict[cr]--;
            if (dict[cr] == 0) {
                count++;
            }

            if (count == pCount)
                ans.add(i);

            char cl = s.charAt(i);
            dict[cl]++;
            if (dict[cl] == 1) {
                count--;
            }
        }

        return ans;
    }

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length())
            return false;
        List ans = findAnagrams(s2,s1);
        if (ans.isEmpty())
            return false;
        else
            return true;
    }
}