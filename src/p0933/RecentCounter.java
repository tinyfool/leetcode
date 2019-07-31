package p0933;

import java.util.LinkedList;
//暂时跳过

public class RecentCounter {

    int sum = 0;
    LinkedList<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList();
    }

    public int ping(int t) {
        queue.add(t);
        sum+=t;
        int count = queue.size();

        if (sum>3000) {
            int x = queue.removeFirst();
            sum-=x;
        }
        return count;
    }
}
