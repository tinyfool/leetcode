package p0336;

import java.util.ArrayList;
import java.util.List;

//Runtime: 281 ms, faster than 6.42% of Java online submissions for Palindrome Pairs.
//Memory Usage: 42.5 MB, less than 98.86% of Java online submissions for Palindrome Pairs.

public class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> ret = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
            for(int j=0;j<words.length;j++) {
                if(i!=j) {
                    if(words[i].length()==0 || words[j].length()==0 || words[i].charAt(0)==words[j].charAt(words[j].length()-1) ) {
                        if(isPalindrome(words[i],words[j])) {
                            addOne(ret, i, j);
                        }
                    }
                }
            }
        }
        return ret;
    }

    private void addOne(List<List<Integer>> ret, int i, int j) {

        List<Integer> pair = new ArrayList<>();
        pair.add(i);
        pair.add(j);
        ret.add(pair);
    }

    //fron p0125
    public boolean isPalindrome(String s1,String s2) {

        int len = s1.length()+s2.length();
        int half = len/2;
        for(int i=0;i<half;i++) {
            int j = len-i-1;
            char b;
            char e;
            if(i<s1.length()) {
                b = s1.charAt(i);
            }else {
                b = s2.charAt(i-s1.length());
            }

            if(j<s1.length()) {
                e = s1.charAt(j);
            }else {
                e = s2.charAt(j-s1.length());
            }
            if (b!=e)
                return false;
        }
        return true;
    }
}
