package p0389;
//Runtime: 1 ms, faster than 98.87% of Java online submissions for Find the Difference.
//Memory Usage: 35.7 MB, less than 99.00% of Java online submissions for Find the Difference.

public class Solution {

    public char findTheDifference(String s, String t) {

        char[] scharCounts = new char[256];
        char[] schars = s.toCharArray();
        for(char c:schars) {
            scharCounts[c]++;
        }

        char[] tcharCounts = new char[256];
        char[] tchars = t.toCharArray();
        for(char c:tchars) {
            tcharCounts[c]++;
        }

        for(char i=0;i<256;i++) {
            if(scharCounts[i]!=tcharCounts[i]) {
                return i;
            }
        }
        return 0;
    }

}
