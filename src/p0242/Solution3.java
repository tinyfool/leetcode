package p0242;

//Runtime: 3 ms, faster than 94.23% of Java online submissions for Valid Anagram.
//        Memory Usage: 37 MB, less than 99.24% of Java online submissions for Valid Anagram.

public class Solution3 {

    public boolean isAnagram(String s, String t) {

        int[] chars = new int[256];
        int ls = s.length();
        int lt = t.length();
        if(ls!=lt)
            return false;

        for(char cs:s.toCharArray()){
            chars[cs]++;
        }

        for(char ct:t.toCharArray()){
            chars[ct]--;
        }

        for (int count:chars
             ) {
            if (count!=0)return false;
        }
        return true;
    }

}
