package p0381;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedCollectionTest {


    @Test

    void test() {

        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);
        randomizedCollection.insert(1);
        randomizedCollection.insert(2);
        randomizedCollection.getRandom();
        randomizedCollection.remove(1);
        randomizedCollection.getRandom();
    }

}