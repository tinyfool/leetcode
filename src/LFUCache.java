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
    private BST bst;
    int capacity;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.frequentMinPQ = new MinPQ(capacity);
        this.bst = new BST();
    }

    public int get(int key) {

        LFU_BST_TreeNode node =  bst.get(key);
        if (node == null)
            return -1;

        int index = frequentMinPQ.getIndex(key);
        if(index == 0) {

            frequentMinPQ.insert(new NumFrequent(key,1));
        } else {

            NumFrequent numFrequent = frequentMinPQ.numFrequentForIndex(index);
            numFrequent.Frequent += 1;
            frequentMinPQ.sink(index);
        }
        return node.value;
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

        if(bst.get(key)!=null) {

            setOrUpdate(key);
            return;
        }

        if (frequentMinPQ.size()>=capacity) {

            NumFrequent numFrequent = frequentMinPQ.delMin();
            bst.del(numFrequent.number);
        }

        bst.insert(key,value);
        setOrUpdate(key);
    }

    public static void main(String [] args) {

        // testBST();
        // testMinPQ();
        finalTest();
    }

    public static void finalTest () {


        LFUCache cache = new LFUCache( 2 /* capacity */ );

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

    public static void testBST() {


        BST bst = new BST();

        bst.insert(20,1);
        bst.insert(25,1);
        bst.insert(15,1);
        bst.insert(7,1);
        bst.insert(21,1);
        bst.insert(29,1);
        bst.insert(27,1);
        bst.insert(31,1);
        bst.insert(26,1);

        System.out.println(bst.get(20).key);

        System.out.println(bst.get(18));

        System.out.println(bst.size());

        bst.del(27);
        bst.del(31);
        bst.del(20);

        bst.del(25);
        bst.del(15);

        bst.del(7);
        bst.del(21);
        bst.del(29);
        bst.del(26);


        System.out.println(bst.size());

        bst.insert(20,1);
        bst.insert(15,1);
        bst.insert(7,1);
        bst.insert(6,1);

        bst.del(6);
        bst.del(7);
        bst.del(15);
        bst.del(20);

        System.out.println(bst.size());

    }
}


class MinPQ {

    private int n;
    private NumFrequent[] data;

    MinPQ(int capacity){

        n = 0;
        data = new NumFrequent[capacity+1];
    }

    void insert(NumFrequent k) {

        data[++n] = k;
        swim(n);
    }

    void swim(int k) {

        while (k>1 && less(k/2,k)) {

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

        NumFrequent min = data[1];
        exchange(1,n--);
        sink(1);
        data[n+1] = null;
        return min;
    }

    void exchange(int i,int j) {

        NumFrequent temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    boolean isEmpty() {

        return true;
    }

    NumFrequent Min() {

        return null;
    }

    int size() {

        return n;
    }

}