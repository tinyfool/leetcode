package p030;

import java.util.*;

public class Solution2 {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<Integer>();

        if(words.length==0)
            return ans;
        if(s.length()==0)
            return ans;

        int length = words[0].length();
        int count = words.length;
        int wordlength = length*count;

        if(s.length()<count*length)
            return ans;

        HashMap<String,Integer> wordMap = new HashMap<String,Integer>();

        for(String word:words){

           wordMap.put(word,wordMap.getOrDefault(word,0)+1);
        }

        for(int i=0; i<s.length()-wordlength+1; i++) {
            if(checkWords(s,i,wordMap,length,count))
                ans.add(i);
        }
        return ans;
    }

    private boolean checkWords(String s,int left,HashMap<String,Integer> wordMap,int length,int count) {

        HashMap<String,Integer> map = new HashMap<String, Integer>();
        for(int j=0; j<count; j++) {

            int start = left + j * length;
            String part = s.substring(start, start + length);
            if (!wordMap.containsKey(part))
                return false;
            map.put(part,map.getOrDefault(part,0)+1);
        }

        for(String word:wordMap.keySet()) {

            if(!map.containsKey(word))
                return false;
            int old = wordMap.get(word);
            int newWord = map.get(word);
            if (newWord!=old)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        Solution2 solution = new Solution2();
        List ans;
        
        ans = solution.findSubstring(s,words);
        System.out.println(ans);

        s ="abababab";
        words = new String[]{"ab","ba"};
        ans = solution.findSubstring(s,words);
        System.out.println(ans);

        s = "wordgoodgoodgoodbestword";
        words = new String[]{"word","good","best","good"};
        ans = solution.findSubstring(s,words);
        System.out.println(ans);
    }
}
