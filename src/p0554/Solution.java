package p0554;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//Runtime: 11 ms, faster than 85.25% of Java online submissions for Brick Wall.
//Memory Usage: 48.9 MB, less than 75.00% of Java online submissions for Brick Wall.
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        List<Integer> gaps = new ArrayList<>();
        for (List<Integer> line:wall) {
            countGap(gaps,line);
        }
        return wall.size()-mostCommonGap(gaps);
    }

    private void countGap(List<Integer> gaps,List<Integer> line) {
        int s = 0;
        for(int i=0;i<line.size()-1;i++) {
            int brickWidth = line.get(i);
            s+=brickWidth;
            gaps.add(s);
        }
    }

    private int mostCommonGap(List<Integer> gaps) {

        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int gap:gaps){
            countMap.put(gap, countMap.getOrDefault(gap,0)+1);
        }
        int max = 0;
        for (int count:countMap.values()
             ) {
            if(count>max)
                max = count;
        }
        return max;
    }
}
