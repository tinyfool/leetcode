package p0862;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testcase() {
        int A[];
        int K;

        Solution s1 = new Solution();

        A = new int[]{1};
        K = 1;
        assertEquals(1,s1.shortestSubarray(A,K));

        A = new int[]{1,2};
        K = 4;
        assertEquals(-1,s1.shortestSubarray(A,K));

        A = new int[]{2,-1,2};
        K = 3;
        assertEquals(3,s1.shortestSubarray(A,K));


        A = new int[]{84,-37,32,40,95};
        K = 167;
        assertEquals(3,s1.shortestSubarray(A,K));
    }
}