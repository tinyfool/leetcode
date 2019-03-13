package p0005;
/**
 * Created by haopeiqiang on 2016/10/16.
 */
public class Solution1 {



    public boolean isPalindrome(String s) {

        for (int i = 0; i < s.length()/2+1; i++) {

            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }



    public String longestPalindrome(String s) {

        String ret="";

        for(int right = 0;right<s.length();right++) {


        }

        return ret;
    }

    public static void main(String[] argv) {

        test1();
    }

    public static void test1() {

        Solution1 solution1 = new Solution1();
        String ret;

        ret = solution1.longestPalindrome("abb");
        System.out.println(ret);

        ret =solution1.longestPalindrome("babad");
        System.out.println(ret);
    }
}
