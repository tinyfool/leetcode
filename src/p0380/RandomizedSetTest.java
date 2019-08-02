package p0380;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedSetTest {


    @Test
    void test1() {

        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.remove(2);
        set.insert(2);
        set.getRandom();
        set.remove(1);
        set.insert(2);
        set.getRandom();
    }
}