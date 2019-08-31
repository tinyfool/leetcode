package p0044;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-30 21:05
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {

        assertFalse(solution.isMatch("aa","a"));
        assertFalse(solution.isMatch("cb","?a"));
        assertFalse(solution.isMatch("acdcb","a*c?b"));
    }

    @Test
    void test2() {

        assertTrue(solution.isMatch("abefcdgiescdfimde","ab*cd?i*de"));
    }

    @Test
    void test3() {
        assertTrue(solution.isMatch("aa", "*"));
    }

    @Test
    void test4() {
        assertTrue(solution.isMatch("adceb","*a*b"));
    }

    @Test
    void test5() {
        assertFalse(solution.isMatch("mississippi","m??*ss*?i*pi"));
    }

    @Test
    void test6() {
        assertFalse(solution.isMatch("ssippi","ss*?i*pi"));
    }

    @Test
    void test7() {
        assertFalse(solution.isMatch("ippi","*?i*pi"));
    }

    @Test
    void test8() {

        assertTrue(solution.isMatch("ho","ho**"));
    }

    @Test
    void test9() {

        assertFalse(solution.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba","a*******b"));
    }

    @Test
    void test10() {

        assertFalse(solution.isMatch(
                "aaabbbbaaaabbabbbbaabbabaaababaababaaaaaaabaaababbaababbaababbbaaaaabaabbabbaabaababbaabababbbbbbbbabbaabbaaabaababaabaababababababbbbbbabbabbaabbaabaaaaaababaabbbaaabaaabbbbbbbbbaabaabaaabaaabbabbabb",
                "****a*b*b**b*bbb*b**bba***b**b*b*b**ba***b*b*a*b*b*****a**aaa*baaa*ba*****a****ba*a****a**b*******a*a"));
    }

    @Test
    void test11() {
        assertTrue(solution.isMatch("abcd","*b*c*d*"));
    }
    @Test
    void test12() {
        assertTrue(solution.isMatch("hi","*?"));
    }

}