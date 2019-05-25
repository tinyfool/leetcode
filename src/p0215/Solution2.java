package p0215;

import java.util.Arrays;

public class Solution2 {


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

    void maxHeapify(int i){

        int l = left(i);
        int r = right(i);
        int largest;
        if (l <= heapsize && _A[l-1] > _A[i-1])
            largest = l;
        else
            largest = i;

        if (r <= heapsize && _A[r-1]>_A[largest-1])
            largest = r;

        if (largest != i) {
            exchange(i,largest);
            maxHeapify(largest);
        }

    }

    void exchange(int i,int j) {
        int temp = _A[i-1];
        _A[i-1] = _A[j-1];
        _A[j-1] = temp;
    }

    void buildMaxHeap() {
        for (int i = _A.length/2;i>=1;i--) {
            maxHeapify(i);
        }
    }

    int extractMax() throws Exception {

        if (heapsize<1)
            throw new Exception("heap underflow");
        int max = _A[0];
        _A[0] = _A[heapsize-1];
        heapsize--;
        maxHeapify(1);
        return max;
    }


    public int findKthLargest(int[] nums, int k)  {

        initheap(nums);
        buildMaxHeap();
        int ret = 0;
        for(int i = 0;i<k;i++) {
            try {
                ret = extractMax();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static void main(String[] args)  {

        int[] a = {3,2,3,1,2,4,5,5,6};
        int[] b = {3,2,1,5,6,4};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.findKthLargest(a,4));
        System.out.println(solution2.findKthLargest(b,2));
    }
}
