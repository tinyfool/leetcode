package CLRS;

public class HeapSort {

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

    void increaseKey(int i,int key) throws Exception {

        if (key<_A[i-1])
            throw new Exception("new key is smaller then the current key");
        _A[i-1] = key;
        while (i>0 && parent(i)-1>=0 && _A[parent(i)-1]<_A[i-1]) {

            exchange(parent(i),i);
            i = parent(i);
        }
    }

    void insertKey(int key) throws Exception {

        heapsize++;
        if(heapsize>_A.length) {
            int[] A = new int[heapsize*2];
            for(int i=0;i<_A.length;i++){
                A[i]=_A[i];
            }
            _A = A;
        }
        _A[heapsize-1] = Integer.MIN_VALUE;
        increaseKey(heapsize,key);
    }

    void buildHeapwithInsert() throws Exception {
        heapsize = 1;
        for(int i=2;i<=_A.length;i++) {
            insertKey(_A[i-1]);
        }
    }
    public static void main(String[] args) throws Exception {

        HeapSort hs = new HeapSort();
        int i=1;
        System.out.println(hs.left(i));
        System.out.println(hs.right(i));

        int[] A = new int[]{16,4,10,14,7,9,3,2,8,1};
        hs.initheap(A);
        hs.maxHeapify(2);
        A = new int[]{4,1,3,2,16,9,10,14,8,7};
        hs.initheap(A);
        hs.buildMaxHeap();
        System.out.println(hs._A);
        hs.heapsort();
        System.out.println(hs._A);
        hs.initheap(A);
        hs.buildMaxHeap();
        System.out.println(hs.extractMax());
        System.out.println(hs.extractMax());
        System.out.println(hs.extractMax());
        System.out.println(hs.extractMax());

        //A = new int[]{4,1,3,2,16,9,10,14,8,7};

        hs.initheap(A);
        hs.buildMaxHeap();
        hs.increaseKey(9,15);
        hs.insertKey(18);
        System.out.println(hs._A);

        hs.initheap(A);
        hs.buildHeapwithInsert();
        System.out.println(hs._A);
    }


}
