package p0884;

import sun.tools.jconsole.Worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//Runtime: 3 ms, faster than 65.63% of Java online submissions for Uncommon Words from Two Sentences.
//Memory Usage: 36 MB, less than 97.44% of Java online submissions for Uncommon Words from Two Sentences.

public class Solution {

    public String[] uncommonFromSentences(String A, String B) {

        HashMap<String,Integer> wordA = new HashMap<>();
        HashMap<String,Integer> wordB = new HashMap<>();
        String[] arrayA = A.split(" ");
        String[] arrayB = B.split(" ");

        for (String word:arrayA
             ) {
            wordA.put(word,wordA.getOrDefault(word,0)+1);
        }
        for (String word:arrayB
        ) {
            wordB.put(word,wordB.getOrDefault(word,0)+1);
        }
        List<String> list = new ArrayList<>();
        for (String word:wordA.keySet()
             ) {
            if(wordA.get(word)==1 && wordB.getOrDefault(word,0)==0)
                list.add(word);
        }
        for (String word:wordB.keySet()
        ) {
            if(wordB.get(word)==1 && wordA.getOrDefault(word,0)==0)
                list.add(word);
        }

        String[] ret=list.toArray(new String[0]);
        return ret;
    }
}
