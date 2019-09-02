package p0044;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-09-02 12:07
 */

//learn from https://leetcode.com/problems/wildcard-matching/discuss/138878/Finite-state-machine-with-Python-and-dictionary.-13-lines-O(p%2Bs)-time

//Runtime: 96 ms, faster than 5.05% of Java online submissions for Wildcard Matching.
//Memory Usage: 42.1 MB, less than 13.95% of Java online submissions for Wildcard Matching.
public class Solution1 {

    HashMap<Pair<Integer,Character>,Integer> transfer = new HashMap<>();
    public boolean isMatch(String s, String p) {
        int state = 0;
        int M = p.length();
        for (char c:p.toCharArray()) {
            if (c=='*')
                transfer.put(new Pair(state,c),state);
            else
                transfer.put(new Pair(state,c),++state);
        }
        int accept = state;

        Set<Integer> states = new HashSet<>();
        states.add(0);
        for (char c : s.toCharArray()) {
            Set<Integer> tmp = new HashSet<>();
            for (Integer at : states) {
                //if (at >= M) continue; // in case we cross the boundary of the array
                tmp.add(transfer.getOrDefault(new Pair(at,c),-1));
                tmp.add(transfer.getOrDefault(new Pair(at,'*'),-1));
                tmp.add(transfer.getOrDefault(new Pair(at,'?'),-1));
            }
            if (tmp.contains(-1)) {
                tmp.remove(-1);
            }
            states = tmp;
        }
        return states.contains(state);
    }
}