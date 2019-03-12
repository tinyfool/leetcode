package p0030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

    private List<Integer> findAnagrams(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();
        int count = 0;
        int pCount = 0;
        List<Integer> ans = new ArrayList<Integer>();
        int[] dict = new int[256];

        for(int i=0; i<pLength; i++) {

            char c = p.charAt(i);
            dict[c]++;
        }

        for (char c=0;c<256;c++) {

            if(dict[c]>0)
                pCount++;
        }

        for(int i=0; i<pLength-1; i++) {

            char cr = s.charAt(i);
            dict[cr]--;
            if(dict[cr]==0) {
                count++;
            }
        }

        int i=0;
        for(i=0; i<sLength-pLength+1; i++) {

            int right = i + pLength-1;
            char cr = s.charAt(right);
            dict[cr]--;
            if(dict[cr]==0) {
                count++;
            }

            if(count==pCount)
                ans.add(i);

            char cl = s.charAt(i);
            dict[cl]++;
            if(dict[cl]==1) {
                count--;
            }
        }

        return ans;
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<Integer>();
        if(s.length()==0)
            return ans;
        if(words.length==0)
            return ans;
        Arrays.sort(words);

        StringBuilder sb = new StringBuilder();
        for(String str:words) {
            sb.append(str);
        }
        String p = sb.toString();
        List<Integer> anagrams = this.findAnagrams(s,p);

        int length = words[0].length();
        int count = words.length;
        for(int start:anagrams) {
            String anaStr = s.substring(start,start+length*count);
            if(checkWords(anaStr,length,words))
                ans.add(start);
        }
        return ans;
    }

    private boolean checkWords(String s,int length,String[] words) {

        String[] parts = new String[words.length];
        int n = 0;
        for(int i=0;i<s.length();i+=length) {
            String part = s.substring(i,i+length);
            parts[n] = part;
            n++;
        }
        Arrays.sort(parts);
        for(int i=0;i<parts.length;i++) {
            if(!parts[i].equals(words[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        Solution1 solution = new Solution1();
        List ans = solution.findSubstring(s,words);
        System.out.println(ans);

        s ="abababab";
        words = new String[]{"ab","ba"};
        solution = new Solution1();
        ans = solution.findSubstring(s,words);
        System.out.println(ans);
    }
}
