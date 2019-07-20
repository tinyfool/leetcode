package p0524;

import java.util.*;
//暂时跳过
public class Solution1 {

    public String findLongestWord(String s, List<String> d) {

        Map<Character,Integer> chars = new HashMap<>();
        for (char c:s.toCharArray()
             ) {
            int count = chars.getOrDefault(c,0);
            count++;
            chars.put(c,count);
        }

        List<String> dRet = new ArrayList<>();
        for(String word:d) {
            if(wordInHashMap(chars,word))
                dRet.add(word);
        }

        Collections.sort(dRet);
        int maxlength = 0;
        String retWord = "";
        for (String word:dRet
             ) {
            if(maxlength<word.length()) {
                retWord = word;
                maxlength = word.length();
            }
        }
        return retWord;
    }

    private boolean wordInHashMap(Map<Character,Integer> chars,String word){

        Map<Character,Integer> iChars = new HashMap<>();
        for (char c:word.toCharArray()
        ) {
            int count = iChars.getOrDefault(c,0);
            count++;
            iChars.put(c,count);
        }
        for (Character c:iChars.keySet()) {
            if(iChars.getOrDefault(c,0)>chars.getOrDefault(c,0)) {

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        Solution1 s1 = new Solution1();
        System.out.println(s1.findLongestWord(s,d));
    }
}
