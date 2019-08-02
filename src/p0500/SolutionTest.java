package p0500;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test() {
        //["Hello", "Alaska", "Dad", "Peace"]
        //Output: ["Alaska", "Dad"]
        String[] ret = solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        assertEquals("Alaska",ret[0]);
        assertEquals("Dad",ret[1]);
    }
}