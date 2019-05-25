package p0023;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    private int[] _A;
    int heapsize;

    void initheap(int[] A) {

        _A = A.clone();
        heapsize = A.length;
    }

    int parent(int i){

        return i/2;
    }

    int left(int i) {
        return i<<1;
    }

    int right(int i) {

        return (i<<1)+1;
    }

    void minHeapify(int i){

        int l = left(i);
        int r = right(i);
        int smallest;
        if (l <= heapsize && _A[l-1] < _A[i-1])
            smallest = l;
        else
            smallest = i;

        if (r <= heapsize && _A[r-1] < _A[smallest-1])
            smallest = r;

        if (smallest != i) {
            exchange(i,smallest);
            minHeapify(smallest);
        }

    }

    void exchange(int i,int j) {
        int temp = _A[i-1];
        _A[i-1] = _A[j-1];
        _A[j-1] = temp;
    }

    void buildMinHeap() {
        for (int i = _A.length/2;i>=1;i--) {
            minHeapify(i);
        }
    }

    int extractMin() throws Exception {

        if (heapsize<1)
            throw new Exception("heap underflow");
        int max = _A[0];
        _A[0] = _A[heapsize-1];
        heapsize--;
        minHeapify(1);
        return max;
    }



    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> numbs = new ArrayList();
        for(int i=0;i<lists.length;i++) {
            ListNode node=lists[i];
            while(node !=null) {
                numbs.add(node.val);
                node = node.next;
            }
        }
        int[] numArray = new int[numbs.size()];
        int i = 0;
        for(Integer num:numbs) {
            numArray[i] = num;
            i++;
        }
        initheap(numArray);
        buildMinHeap();
        ListNode root = new ListNode(0);
        ListNode node = root;
        for(int j = 0;j<numArray.length;j++) {
            try {
                int val = extractMin();
                ListNode newNode = new ListNode(val);
                node.next = newNode;
                node = newNode;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return root.next;
    }

    public static void main(String[] args) {

//        Input:
//        [
//          1->4->5,
//          1->3->4,
//          2->6
//        ]
//        Output: 1->1->2->3->4->4->5->6

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] input = new ListNode[]{null,node1,node2,node3};
        Solution3 solution3 = new Solution3();
        ListNode result = solution3.mergeKLists(input);

        if (result!=null)
            result.show();
    }
}


//Runtime: 3 ms, faster than 93.61% of Java online submissions for Merge k Sorted Lists.
//Memory Usage: 40.4 MB, less than 24.33% of Java online submissions for Merge k Sorted Lists.
