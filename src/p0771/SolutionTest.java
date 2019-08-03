package p0771;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        assertEquals(3,solution.numJewelsInStones("aA","aAAbbbb"));
    }

    @Test
    void test2() {
        assertEquals(0,solution.numJewelsInStones("z","ZZ"));
    }


}