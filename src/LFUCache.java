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

    //private MinPQ<numFrequent> frequentMinPQ;
    public LFUCache(int capacity) {

        //frequentMinPQ = new MinPQ<>(capacity);
    }

    public int get(int key) {

        return 0;
    }

    public void set(int key, int value) {


    }
    public static void main(String [] args) {

        //testBST();

        testMinPQ();
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


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.set(key,value);
 */


class LFU_BST_TreeNode {

    int key;
    int value;
    LFU_BST_TreeNode left;
    LFU_BST_TreeNode right;
    int size;

    public LFU_BST_TreeNode(int key, int val, int size) {

        this.key = key;
        this.value = val;
        this.size = size;
    }
}

class BST {

    private LFU_BST_TreeNode root;

    BST() {
        root = null;
    }

    void insert(int key, int value) {

        root = insert(root,key,value);
    }

    LFU_BST_TreeNode insert(LFU_BST_TreeNode x, int key, int value) {

        if (x == null) {

            x = new LFU_BST_TreeNode(key, value,1);
            return x;
        }

        if (key > x.key) {

            x.right = insert(x.right, key, value);
        } else if (key < x.key) {

            x.left = insert(x.left, key, value);

        }else {

            x.key = key;
            x.value = value;
        }
        x.size = size(x.left)                                                                                                                            + size(x.right) + 1;
        return x;
    }

    void del(int key) {

        del(root, null, key);
    }

    void del(LFU_BST_TreeNode x, LFU_BST_TreeNode parent, int key) {

        if(x == null)
            return;

        if (key > x.key) {

            del(x.right, x, key);

        } else if (key < x.key) {

            del(x.left, x, key);
        }else {

            if (x.right != null) {

                LFU_BST_TreeNode min = delMin(x.right);

                if (parent == null) {

                    root = min;
                }
                else if (parent.left == x) {

                    parent.left = min;
                    parent.size--;
                } else  {

                    parent.right = min;
                    parent.size--;
                }
                min.left = x.left;
                if (min!=x.right) {
                    min.right = x.right;
                }
            } else {

                if (parent == null) {

                    if (x.left == null)
                        root = null;
                    else  {

                        root = x.left;
                        root.size = size(x.left);
                    }
                }else if (parent.left == x) {

                    parent.left = x.left;
                    parent.size--;
                } else  {

                    if (x.left!=null)
                        parent.right = x.left;
                    else
                        parent.right = null;
                    parent.size--;
                }

            }
            if (root !=null)
                root.size = size(root.left) + size(root.right);
        }
    }

    LFU_BST_TreeNode delMin(LFU_BST_TreeNode node) {

        if(node.left == null) {
            return node;
        }

        if (node.left.left == null) {

            LFU_BST_TreeNode min = node.left;
            node.left = null;
            if (min.right!=null) {
                node.left = min.right;
                min.right = null;
            }
            return min;
        } else {

            return delMin(node.left);
        }
    }

    int size() {

        return size(root);
    }

    int size(LFU_BST_TreeNode node) {

        if (node == null)
            return 0;

        return node.size;
    }
    LFU_BST_TreeNode get(int key) {

        return get(root,key);
    }

    LFU_BST_TreeNode get(LFU_BST_TreeNode x, int key) {

        if (x == null)
            return null;

        if (key == x.key) {

            return x;
        } else if (key > x.key) {

            return get(x.right,key);
        } else {

            return get(x.left,key);
        }

    }
}
class MinPQ {

    private int n;
    private NumFrequent[] data;
    MinPQ(int capacity){

        n = 0;
        data = new NumFrequent[capacity];
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

    boolean less(int i, int j) {

        if(data[i].compareTo(data[j])==1)

            return true;
        else
            return false;
    }

    void exchange(int i,int j) {

        NumFrequent temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    NumFrequent delMin() {

        return null;
    }

    boolean isEmpty() {

        return true;
    }

    NumFrequent Min() {

        return null;
    }

    int size() {

        return 0;
    }

}