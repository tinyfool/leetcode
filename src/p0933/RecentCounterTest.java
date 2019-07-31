package p0933;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecentCounterTest {

    @Test
    void testcase() {

        RecentCounter rc = new RecentCounter();

        assertEquals(1,rc.ping(1));
        assertEquals(2,rc.ping(100));
        assertEquals(3,rc.ping(3001));
        assertEquals(3,rc.ping(3002));


        rc = new RecentCounter();
        assertEquals(1,rc.ping(1178));
        assertEquals(2,rc.ping(1483));
        assertEquals(3,rc.ping(1563));
        assertEquals(4,rc.ping(4054));
        assertEquals(5,rc.ping(4152));
    }
}