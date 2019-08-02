package p0299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
//Runtime: 8 ms, faster than 13.70% of Java online submissions for Bulls and Cows.
//Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Bulls and Cows.
public class Solution {

    public String getHint(String secret, String guess) {

        char[] sChars = secret.toCharArray();
        char[] gChars = guess.toCharArray();

        int bulls = 0;
        for(int i=0;i<sChars.length;i++){
            if(sChars[i]==gChars[i]) {
                bulls++;
                sChars[i] = '.';
                gChars[i] = '.';
            }
        }

        ArrayList<Character> secrets = new ArrayList<>();
        for (char c: sChars) {
            if(c!='.')
                secrets.add(c);
        }
        int cows = 0;
        for(int i=0;i<guess.length();i++){

            if (charInSecret(secrets,gChars[i])) {
                cows++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }

    boolean charInSecret(ArrayList<Character> secrets,char c){

        if(c=='.')
            return false;
        for(int j=0;j<secrets.size();j++) {
            if(c==secrets.get(j)) {
                secrets.set(j,'.');
                return true;
            }
        }
        return false;
    }
}
