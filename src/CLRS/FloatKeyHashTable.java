package CLRS;

public class FloatKeyHashTable {
    LinkedList2[] buckets;
    int n;

    FloatKeyHashTable(int m) {
        n = m;
        buckets = new LinkedList2[m];
    }

    int hash(float key) {
        int hash = (int)(key*n);
        if (hash>=n)
            hash = n-1;
        return hash;
    }

    void insert(FloatKeyPair x) {
        int hash = hash(x.key);
        LinkedListNode node = new LinkedListNode();
        node.value = x;
        if (buckets[hash]==null)
            buckets[hash]= new LinkedList2();
        buckets[hash].insert(node);
    }

    FloatKeyPair search(float key) {
        LinkedListNode node = buckets[hash(key)].nil;
        while (node!=null) {
            if (node.value!=null) {
                FloatKeyPair x = (FloatKeyPair) node.value;
                if (x.key==key)
                    return x;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {

        FloatKeyHashTable fkh = new FloatKeyHashTable(100);
        float key = (float) 0.33333;
        FloatKeyPair x = new FloatKeyPair(key,"test");
        fkh.insert(x);
        x = fkh.search(key);
        System.out.println(x);

        key = (float) 0.33334;
        x = new FloatKeyPair(key,"test1");
        fkh.insert(x);
        x = fkh.search(key);
        System.out.println(x);

        key = (float) 0.8;
        x = new FloatKeyPair(key,"test8");
        fkh.insert(x);
        System.out.println(x);
    }
}
