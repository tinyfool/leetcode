package p0299;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void test1() {
        assertEquals("1A3B",solution.getHint( "1807","7810"));
    }

    @Test
    void test2() {

        assertEquals("1A1B",solution.getHint( "1123","0111"));
    }

    @Test
    void test3() {

        assertEquals("0A4B",solution.getHint( "1122","2211"));
    }


}