package p424;

import java.util.HashSet;

public class Solution1 {

    public int characterReplacement(String s, int k) {

        int[] map = new int[256];
        int ans = 0;
        int left = 0;
        HashSet<Character> nums = new HashSet<>();
        int rc = 0;

        for(int right=0;right<s.length();right++) {

            char cR = s.charAt(right);
            map[cR]++;
            nums.add(cR);
            rc = replaceCount(nums,map);

            while(rc>k) {

                char cF = s.charAt(left);
                map[cF]--;
                if(map[cF]==0) {
                    nums.remove(cF);
                }
                rc = replaceCount(nums,map);
                left++;
            }
            int len = right-left+1;
            if(len>ans)
                ans = len;
        }
        return ans;
    }

    private int replaceCount(HashSet<Character> nums,int[] map) {

        int rc = 0;
        int maxC = 0;
        int max = 0;
        if(nums.size()==0||nums.size()==1)
            return 0;
        for (char c:nums) {
            if(map[c]>max) {
                max = map[c];
                maxC = c;
            }
        }
        for (char c:nums) {
            if(c!=maxC)
               rc+=map[c];
        }
        return rc;
    }

    public static void main(String[] args) {


        Solution1 solution1;

        solution1= new Solution1();
        int ans =0;

        String s = "ABAB";
        int k = 2;
        ans = solution1.characterReplacement(s,k);
        System.out.println(ans);

        s = "ABAA";
        k = 0;
        ans = solution1.characterReplacement(s,k);
        System.out.println(ans);

        s = "AAAA";
        k = 2;
        ans = solution1.characterReplacement(s,k);
        System.out.println(ans);

        s = "AABABBA";
        k = 1;
        ans = solution1.characterReplacement(s,k);
        System.out.println(ans);

        s = "BAAA";
        k = 0;
        ans = solution1.characterReplacement(s,k);
        System.out.println(ans);

        s = "ABCDE";
        k = 1;
        ans = solution1.characterReplacement(s,k);
        System.out.println(ans);

        s = "BAAAB";
        k = 2;
        ans = solution1.characterReplacement(s,k);
        System.out.println(ans);

        s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        k= 4;
        ans = solution1.characterReplacement(s,k);
        System.out.println(ans);
    }
}
