package p0389;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();


    @Test
    void test() {
        assertEquals('e',solution.findTheDifference("abcd","abcde"));
    }
}