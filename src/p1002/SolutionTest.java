package p1002;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        List<String> except = new ArrayList<>();
        except.add("e");
        except.add("l");
        except.add("l");
        assertEquals(except,solution.commonChars(new String[]{"bella","label","roller"}));
    }

    @Test
    void test2() {
        List<String> except = new ArrayList<>();
        except.add("c");
        except.add("o");
        assertEquals(except,solution.commonChars(new String[]{"cool","lock","cook"}));
    }

}