package p0438;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<Integer> findAnagrams(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();
        int count = 0;
        int pCount = 0;
        List<Integer> ans = new ArrayList<Integer>();
        int[] dict = new int[256];

        for(int i=0; i<pLength; i++) {

            char c = p.charAt(i);
            dict[c]++;
        }

        for (char c=0;c<256;c++) {

            if(dict[c]>0)
                pCount++;
        }

        for(int i=0; i<pLength-1; i++) {

            char cr = s.charAt(i);
            dict[cr]--;
            if(dict[cr]==0) {
                count++;
            }
        }

        int i=0;
        for(i=0; i<sLength-pLength+1; i++) {

           int right = i + pLength-1;
           char cr = s.charAt(right);
           dict[cr]--;
           if(dict[cr]==0) {
               count++;
           }

           if(count==pCount)
               ans.add(i);

           char cl = s.charAt(i);
           dict[cl]++;
           if(dict[cl]==1) {
               count--;
           }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {

        String s = "cbaebabacd";
        String p = "abc";
        Solution1 solution = new Solution1();
        List list ;

        list = solution.findAnagrams(s,p);
        System.out.println(list);

        s = "abab";
        p = "ab";
        list = solution.findAnagrams(s,p);
        System.out.println(list);

        s = "aabaa";
        p = "aa";
        list = solution.findAnagrams(s,p);
        System.out.println(list);

        String file = "data/p0438/a1";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        s = reader.readLine();

        file = "data/p0438/a2";
        reader = new BufferedReader(new FileReader(file));
        p = reader.readLine();
        list = solution.findAnagrams(s,p);
        System.out.println(list);
    }
}
