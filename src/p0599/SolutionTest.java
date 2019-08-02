package p0599;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();


    @Test
    void test1(){

        String [] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String [] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        assertEquals("Shogun",solution.findRestaurant(list1,list2)[0]);
    }

    @Test
    void test2(){

        String [] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String [] list2 = new String[]{"KFC", "Shogun", "Burger King"};
        assertEquals("Shogun",solution.findRestaurant(list1,list2)[0]);
    }

    @Test
    void test3(){

        String [] list1 = new String[]{"k", "KFC"};
        String [] list2 = new String[]{"k", "KFC"};
        String [] ret  = solution.findRestaurant(list1,list2);
        assertEquals(1,ret.length);
        assertEquals("k",ret[0]);
    }

}