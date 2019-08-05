package p0146;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;

public class LRUCache {

    HashMap<Integer,Integer> map = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    int k;
    public LRUCache(int capacity) {
        k = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            if(queue.contains(key)) {
                queue.remove(key);
            }
            queue.add(key);
            while (queue.size()>k)
            {
                int r = queue.poll();
                if(r!=key)
                    map.remove(r);
            }
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

        if(queue.size()>=k)
        {
            int r = queue.poll();
            map.remove(r);
        }
        map.put(key,value);
        queue.add(key);
    }
}
