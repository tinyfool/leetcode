/**
 * Created by haopeiqiang on 2016/10/16.
 */
public class Solution005 {


    public boolean isPalindrome(String s) {


        return isPalindrome1(s);
    }

    public boolean isPalindrome1(String s) {

        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }

    public boolean isPalindrome2(String s) {

        for (int i = 0; i < s.length()/2+1; i++) {

            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }

    public String slowLongestPalindrome(String s) {

        if(this.isPalindrome(s))
            return s;

        String lpStr = "";

        for(int i = 0;i<s.length();i++) {

            for(int j=i+1;j<=s.length();j++) {

                String sub = s.substring(i,j);
                if(this.isPalindrome(sub)) {

                    if(sub.length()>lpStr.length()) {

                        lpStr = sub;
                    }
                }
                System.out.println(sub);
            }
        }
        return lpStr;
    }

    public String longestPalindrome(String s) {

        String rs = new StringBuilder(s).reverse().toString();
        String ret = "";
        if(s.equals(rs))
            return s;
        String oldsub = "";
        for(int i = 0;i<s.length();i++) {

            for(int j=i+1;j<=s.length();j++) {

                String sub = s.substring(i,j);
                if (!rs.contains(sub)) {

                    System.out.println(oldsub);
                    if (isPalindrome(oldsub) && ret.length() < oldsub.length()) {
                        ret = oldsub;
                    }
                    break;
                }else {

                    oldsub = sub;
                }
            }
        }

        if (isPalindrome(oldsub) && ret.length() < oldsub.length()) {
            ret = oldsub;
        }

        return ret;
    }

    public static void main(String[] argv) {

        test1();
    }

    public static void test1() {

        long time1 = System.currentTimeMillis();
        Solution005 s5 = new Solution005();
        String ret = s5.longestPalindrome("abb");
        System.out.println(ret);
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
    }
}
