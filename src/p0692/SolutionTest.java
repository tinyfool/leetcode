package p0692;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {


        List<String> except= new ArrayList<>();
        except.add("i");
        except.add("love");

        assertEquals(except,
                solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
    }

    @Test
    void test2() {

        List<String> except= new ArrayList<>();
        except.add("the");
        except.add("is");
        except.add("sunny");
        except.add("day");

        assertEquals(except,
                solution.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4));
    }

}