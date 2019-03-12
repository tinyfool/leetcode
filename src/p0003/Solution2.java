package p0003;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by haopeiqiang on 2016/10/16.
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int left = 0;
        int[] charset = new int[256];
        Set<Character> overSet= new HashSet<Character>();
        for(int right=0;right<s.length();right++) {

            char cRight = s.charAt(right);
            charset[cRight]++;
            if(charset[cRight]>1) {
                overSet.add(cRight);
            }

            while (!overSet.isEmpty()) {
                char cLeft = s.charAt(left);
                charset[cLeft]--;
                for (char c:overSet) {
                    if(charset[c]<=1)
                        overSet.remove(c);
                }
                left++;
            }
            if(right-left+1>max)
                max = right-left+1;
        }
        return max;
    }


    public static void main(String [] args) {


        Solution2 s = new Solution2();
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}
