package p0336;

import java.util.ArrayList;
import java.util.List;

//Runtime: 738 ms, faster than 5.02% of Java online submissions for Palindrome Pairs.
//Memory Usage: 44.8 MB, less than 79.54% of Java online submissions for Palindrome Pairs.

public class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> ret = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
            for(int j=0;j<words.length;j++) {
                if(i!=j) {
                    if(words[i].length()==0 || words[j].length()==0 || words[i].charAt(0)==words[j].charAt(words[j].length()-1) ) {
                        String conn = words[i]+words[j];
                        if(isPalindrome(conn)) {
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
    public boolean isPalindrome(String s) {

        if(s==null)
            return true;
        if(s.length()==0)
            return true;

        //s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int half = s.length()/2;
        for(int i=0;i<half;i++) {
            if (s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }
}
