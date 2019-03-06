package p424;

import java.util.HashSet;

public class Solution2 {

    public int characterReplacement(String s, int k) {

        int[] map = new int[256];
        int count = 0;
        int ans = 0;
        HashSet<Character> nums = new HashSet<>();
        int limit = 2;
        if(k==0)
            limit=1;
        int left = 0;
        int rc = 0;

        for(int right=0;right<s.length();right++) {

            char cR = s.charAt(right);
            nums.add(cR);
            map[cR]++;
            if (map[cR]==1)
                count++;

            rc = replaceCount(nums,map);

            while(count>limit || rc>k) {

                char cF = s.charAt(left);
                map[cF]--;
                if(map[cF]==0) {
                    nums.remove(cF);
                    count--;
                }
                rc = replaceCount(nums,map);
                left++;
            }

            if(rc <= k) {
                int len = right-left+1;
                if(len>ans)
                    ans = len;
            }
        }
        return ans;
    }

    private int replaceCount(HashSet<Character> nums,int[] map) {
        int rc = Integer.MAX_VALUE;
        if(nums.size()==0||nums.size()==1)
            return 0;
        for (char c:nums) {
            if(map[c]<rc)
                rc = map[c];
        }
        return rc;
    }

    public static void main(String[] args) {

        String s = "ABAB";
        int k = 2;

        Solution1 solution1;

        solution1= new Solution1();
        int ans =0;

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
