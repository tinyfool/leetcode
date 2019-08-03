package p0609;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    Solution solution = new Solution();

    @Test
    void test1() {

        List<List<String>> ret = solution.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"});
        List<List<String>> except = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("root/a/2.txt");
        list1.add("root/c/d/4.txt");
        list1.add("root/4.txt");
        except.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("root/a/1.txt");
        list2.add("root/c/3.txt");
        except.add(list2);
        assertEquals(except, ret);
    }
}