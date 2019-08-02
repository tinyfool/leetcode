package p0125;

//Runtime: 23 ms, faster than 12.79% of Java online submissions for Valid Palindrome.
//Memory Usage: 38.4 MB, less than 81.88% of Java online submissions for Valid Palindrome.

public class Solution {

    public boolean isPalindrome(String s) {

        if(s==null)
            return true;
        if(s.length()==0)
            return true;

        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int half = s.length()/2;
        for(int i=0;i<half;i++) {
            if (s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }

}
