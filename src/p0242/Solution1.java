package p0242;

import java.util.Arrays;

//8 ms
public class Solution1 {

    public boolean isAnagram(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        if(ls!=lt)
            return false;

        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for(int i=0;i<ls;i++) {
            if (sArray[i]!=tArray[i])
                return false;
        }
        return true;
    }

}
