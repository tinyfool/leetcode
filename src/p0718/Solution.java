package p0718;

import java.util.HashMap;

public class Solution {

    public int findLength(int[] A, int[] B) {

        HashMap<Integer,Integer> mapa = new HashMap<>();
        HashMap<Integer,Integer> mapb = new HashMap<>();

        for(int num:A) {
            mapa.put(num,mapa.getOrDefault(num,0)+1);
        }

        for(int num:B) {
            mapb.put(num,mapb.getOrDefault(num,0)+1);
        }
        int s = 0;
        for(int num:mapa.keySet()) {

            s += Math.min(mapa.get(num),mapb.getOrDefault(num,0));
        }
        return s;
    }

}
