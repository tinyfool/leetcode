package p0003;

/**
 * Created by haopeiqiang on 2016/10/16.
 */
public class Solution1 {

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {

            String charOfString = s.substring(i,i+1);
            String sub = sb.toString();
            int pos = sub.indexOf(charOfString);
            if(pos!=-1) {

                if(max<sb.length())
                    max = sb.length();
                sb.delete(0,pos+1);
                sb.append(charOfString);
            }else {

                sb.append(charOfString);
                System.out.println(sb.toString());
            }
        }
        if(max<sb.length())
            max = sb.length();
        return max;
    }


    public static void main(String [] args) {


        Solution1 s3 = new Solution1();
        System.out.println(s3.lengthOfLongestSubstring("bbbbb"));
    }
}
