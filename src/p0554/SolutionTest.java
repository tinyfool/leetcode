package p0554;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    Solution solution = new Solution();

    @Test
    void test1(){

        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> list;
        list = Arrays.asList(new Integer[]{1,2,2,1});
        wall.add(list);
        list = Arrays.asList(new Integer[]{3,1,2});
        wall.add(list);
        list = Arrays.asList(new Integer[]{1,3,2});
        wall.add(list);
        list = Arrays.asList(new Integer[]{2,4});
        wall.add(list);
        list = Arrays.asList(new Integer[]{3,1,2});
        wall.add(list);
        list = Arrays.asList(new Integer[]{1,3,1,1});
        assertEquals(2,solution.leastBricks(wall));
    }
}