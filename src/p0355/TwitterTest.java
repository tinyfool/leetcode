package p0355;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwitterTest {

    Twitter twitter = new Twitter();
    @BeforeEach
    void setUp() {
    }

    @Test
    void test1(){

        Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
        List<Integer> list = new ArrayList<>();
        list.add(5);
        assertEquals(list,twitter.getNewsFeed(1));

// User 1 follows user 2.
        twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        list = new ArrayList<>();
        list.add(6);
        list.add(5);
        assertEquals(list,twitter.getNewsFeed(1));

// User 1 unfollows user 2.
        twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
        list = new ArrayList<>();
        list.add(5);
        assertEquals(list,twitter.getNewsFeed(1));
    }


    @Test
    void test2(){

        Twitter twitter = new Twitter();

        twitter.postTweet(2, 5);
        twitter.postTweet(1,3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(2, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);

        List<Integer> list;

        list = Arrays.asList(new Integer[]{505, 94, 10, 13, 5});
        assertEquals(list,twitter.getNewsFeed(2));

        twitter.follow(2, 1);

        list = Arrays.asList(new Integer[]{22, 333, 505, 94, 2, 10, 13, 101, 3,5});
        assertEquals(list,twitter.getNewsFeed(2));
    }

    @Test
    void test3(){

        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.postTweet(1,3);
        twitter.postTweet(1,101);
        twitter.postTweet(1,13);
        twitter.postTweet(1,10);
        twitter.postTweet(1,2);
        twitter.postTweet(1,94);
        twitter.postTweet(1,505);
        twitter.postTweet(1,333);
        twitter.postTweet(1,22);
        twitter.postTweet(1,11);

        List<Integer> list;

        list = Arrays.asList(new Integer[]{11,22,333,505,94,2,10,13,101,3});
        assertEquals(list,twitter.getNewsFeed(1));
    }
}