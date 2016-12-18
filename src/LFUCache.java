import java.util.HashMap;

/**
 * Created by haopeiqiang on 2016/12/11.
 */
// 460. LFU Cache
// https://leetcode.com/problems/lfu-cache/


class NumFrequent implements Comparable<NumFrequent> {

    int number;
    int Frequent;

    NumFrequent(int number,int Frequent ) {

        this.number = number;
        this.Frequent = Frequent;
    }
    @Override
    public int compareTo(NumFrequent o) {

        return new Integer(Frequent).compareTo(new Integer(o.Frequent));
    }
}

public class LFUCache {

    private MinPQ frequentMinPQ;
    private HashMap<Integer,Integer> map;
    int capacity;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.frequentMinPQ = new MinPQ(capacity);
        this.map = new HashMap<Integer,Integer>();
    }

    public int get(int key) {

        if (capacity ==0)
            return -1;
        Integer value =  map.get(key);

        if (value == null)
            return -1;

        int index = frequentMinPQ.getIndex(key);
        if(index == 0) {

            frequentMinPQ.insert(new NumFrequent(key,1));
        } else {

            NumFrequent numFrequent = frequentMinPQ.numFrequentForIndex(index);
            numFrequent.Frequent += 1;
            frequentMinPQ.sink(index);
        }
        return value;
    }

    private void setOrUpdate(int key) {

        int index = frequentMinPQ.getIndex(key);
        if(index == 0) {

            frequentMinPQ.insert(new NumFrequent(key,1));
        } else {

            NumFrequent numFrequent = frequentMinPQ.numFrequentForIndex(index);
            numFrequent.Frequent += 1;
            frequentMinPQ.sink(index);
        }
    }

    public void set(int key, int value) {

        if (capacity == 0)
            return;

        if(map.get(key)!=null) {

            map.put(key,value);
            setOrUpdate(key);
            return;
        }

        if (frequentMinPQ.size()>=capacity) {

            NumFrequent numFrequent = frequentMinPQ.delMin();
            if (numFrequent!=null)
                map.remove(numFrequent.number);
        }

        map.put(key,value);
        setOrUpdate(key);
    }

    public static void main(String [] args) {

        // testBST();
        // testMinPQ();
        // finalTest();
        // testcase1();
        // testcase2();
        testcase3();
    }

    public static void testcase1() {

        LFUCache cache = new LFUCache(0);
        cache.set(0,0);
        System.out.println(cache.get(0));
    }

    public static void testcase2() {


        //["LFUCache","set","set","set","set","get"]
        //  [[2],[3,1],[2,1],[2,2],[4,4],[2]]

        LFUCache cache = new LFUCache(2);
        cache.set(3,1);
        cache.set(2,1);
        cache.set(2,2);
        cache.set(4,4);
        System.out.println(cache.get(2));
    }

    public static void testcase3 () {

        //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
        LFUCache cache = new LFUCache(3);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.set(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }

    public static void finalTest () {


        LFUCache cache = new LFUCache(2);

        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.set(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.set(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }
    public static void testMinPQ() {

        MinPQ minPQ = new MinPQ(20);

        minPQ.insert(new NumFrequent(2,10));
        minPQ.insert(new NumFrequent(3,8));
        minPQ.insert(new NumFrequent(4,6));
        minPQ.insert(new NumFrequent(5,5));
        minPQ.insert(new NumFrequent(6,3));
        minPQ.insert(new NumFrequent(7,1));

        minPQ.size();

        NumFrequent min = minPQ.delMin();
        System.out.print(min);
    }
    public static void testLFU() {

        LFUCache cache = new LFUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.get(1);       // returns 1
        cache.set(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.set(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

}


class MinPQ {

    private int n;
    private NumFrequent[] data;
    private int capacity;

    MinPQ(int capacity){

        n = 0;
        data = new NumFrequent[capacity+1];
        this.capacity = capacity;
    }

    void insert(NumFrequent k) {

        if (capacity==0)
            return;

        data[++n] = k;
        swim(n);
    }

    void swim(int k) {

        while (k>1 && less2Swim(k/2,k)) {

            exchange(k,k/2);
            k = k/2;
        }
    }

    void sink(int k) {


        while (2 * k <= n) {

            int j = 2 * k;

            if (j < n && less(j,j+1))
                j++;

            if (!less(k,j))
                break;

            exchange(k,j);
            k = j;
        }
    }

    boolean less(int i, int j) {

        if(data[i].compareTo(data[j])==1 || data[i].compareTo(data[j])==0)
            return true;
        else
            return false;
    }

    boolean less2Swim(int i, int j) {

        if(data[i].compareTo(data[j])==1)
            return true;
        else
            return false;
    }

    NumFrequent numFrequentForIndex(int index) {

        return data[index];
    }

    int getIndex(int number) {

        for (int i = 1; i <= n; i++) {

            if (data[i].number == number)
                return i;
        }
        return 0;
    }

    NumFrequent delMin() {

        if (capacity==0)
            return null;

        NumFrequent min = data[1];
        exchange(1,n--);
        sink(1);
        data[n+1] = null;
        return min;
    }

    NumFrequent Min() {

        if (capacity==0)
            return null;
        return data[1];
    }

    void exchange(int i,int j) {

        NumFrequent temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    boolean isEmpty() {
        if( n == 0)
            return true;
        else
            return false;
    }


    int size() {

        return n;
    }

}