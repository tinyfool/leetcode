package p0884;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {

        assertArrayEquals(new String[]{"sweet","sour"},solution.uncommonFromSentences("this apple is sweet","this apple is sour"));
    }

    @Test
    void test2() {

        assertArrayEquals(new String[]{"banana"},solution.uncommonFromSentences("apple apple", "banana"));
    }

}