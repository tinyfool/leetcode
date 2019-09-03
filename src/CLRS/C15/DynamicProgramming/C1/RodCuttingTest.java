package CLRS.C15.DynamicProgramming.C1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-30 17:32
 */
class RodCuttingTest {

    RodCutting rodCutting =new RodCutting();
    int [] prices = new int[]{  1,5,8,9,10,17,17,20,24,30,
                                35,40,43,45,50,60,62,62,70,72,
                                80,90,100,101,102,103,104,105,106,108
                                };

    @Test
    void test1() {

        assertEquals(1,rodCutting.cutRod(prices,1));
        assertEquals(5,rodCutting.cutRod(prices,2));
        assertEquals(8,rodCutting.cutRod(prices,3));
        assertEquals(10,rodCutting.cutRod(prices,4));
        assertEquals(13,rodCutting.cutRod(prices,5));
        assertEquals(17,rodCutting.cutRod(prices,6));
        assertEquals(18,rodCutting.cutRod(prices,7));
        assertEquals(22,rodCutting.cutRod(prices,8));
        assertEquals(25,rodCutting.cutRod(prices,9));
        assertEquals(30,rodCutting.cutRod(prices,10));
        System.out.println(rodCutting.count);
    }

    @Test
    void test2() {

        rodCutting.count = 0;
        assertEquals(118,rodCutting.cutRodHash(prices,30));
        System.out.println(rodCutting.count);
    }

    @Test
    void test3() {
        rodCutting.count = 0;
        assertEquals(118,rodCutting.cutRodBottomUp(prices,30));
        System.out.println(rodCutting.count);
    }
}