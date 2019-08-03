package p0781;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();


    @Test
    void test1(){

        assertEquals(5,solution.numRabbits(new int[]{1, 1, 2}));
    }

    @Test
    void test2(){

        assertEquals(11,solution.numRabbits(new int[]{10, 10, 10}));
    }


    @Test
    void test3(){

        assertEquals(0,solution.numRabbits(new int[]{}));
    }

    @Test
    void test4(){

        assertEquals(5,solution.numRabbits(new int[]{1,0,1,0,0}));
    }

    @Test
    void test5(){

        assertEquals(6,solution.numRabbits(new int[]{0,0,1,1,1}));
    }
}