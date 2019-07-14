package p0703.solution1;

// Runtime: 61 ms, faster than 66.06% of Java online submissions for Kth Largest Element in a Stream.
// Memory Usage: 48.1 MB, less than 42.98% of Java online submissions for Kth Largest Element in a Stream.

public class KthLargest {

    class MinHeap {

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
            int min = _A[0];
            _A[0] = _A[heapsize-1];
            heapsize--;
            minHeapify(1);
            return min;
        }

        void replaceTop(int n)  {

            _A[0] = n;
            minHeapify(1);
        }

        int getMin() {
            return _A[0];
        }
    }


    int[] largestK;
    MinHeap minheap = new MinHeap();
    boolean empty = false;

    public KthLargest(int k, int[] nums) {

        if(nums.length==0)
            empty = true;
        initheap(nums);
        buildMaxHeap();
        largestK = new int[k];
        for(int i=0;i<k;i++) {
            try {
                largestK[i] = extractMax();
            } catch (Exception e) {
                largestK[i] = Integer.MIN_VALUE;
            }
        }
        minheap.initheap(largestK);
        minheap.buildMinHeap();
    }

    private int[] _A;
    int heapsize;

    void initheap(int[] A) {
        _A = A.clone();
        heapsize = A.length;
    }

    int parent(int i){

        return i>>1;
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

    void heapsort() {
        buildMaxHeap();
        for (int i=_A.length;i>=2;i--) {
            exchange(i,1);
            heapsize--;
            maxHeapify(1);
        }
    }

    int heapMaximun() {

        return _A[0];
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

    public int add(int val) {

        int middleVal = minheap.getMin();
        if (val<middleVal) {
           return middleVal;
        }
        else {

            minheap.replaceTop(val);
            int min = minheap.getMin();
            return min;
        }
    }

    public static void main(String[] args){

        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest;

       kthLargest = new KthLargest(k, arr);
       System.out.println(kthLargest.add(3));   // returns 4
       System.out.println(kthLargest.add(5));   // returns 5
       System.out.println(kthLargest.add(10));  // returns 5
       System.out.println(kthLargest.add(9));   // returns 8
       System.out.println(kthLargest.add(4));   // returns 8

       int k1 = 1;
       int[] arr1={};
       kthLargest = new KthLargest(k1, arr1);
       System.out.println(kthLargest.add(-3));   // returns -3
       System.out.println(kthLargest.add(-2));   // returns -2
       System.out.println(kthLargest.add(-2));  // returns -2
       System.out.println(kthLargest.add(0));   // returns 0
       System.out.println(kthLargest.add(4));   // returns 4

        int k2 = 2;
        int[] arr2 = {0};
        kthLargest = new KthLargest(k2, arr2);
        System.out.println(kthLargest.add(-1));   // returns -1
        System.out.println(kthLargest.add(1));   // returns 0
        System.out.println(kthLargest.add(-2));  // returns 0
        System.out.println(kthLargest.add(-4));   // returns 0
        System.out.println(kthLargest.add(3));   // returns 1

    }
}
