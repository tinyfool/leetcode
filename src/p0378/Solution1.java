package p0378;

//heap solution, running time 10ms
public class Solution1 {

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

    public int kthSmallest(int[][] matrix, int k) {

        int size = matrix.length*matrix[0].length;
        int[] data = new int[size];
        int i = 0;
        for (int[] nums:matrix) {
            for (int num:nums) {
                data[i] = num;
                i++;
            }
        }
        initheap(data);
        buildMinHeap();
        int ret = 0;
        for(int j=0;j<k;j++) {
            try {
                ret = extractMin();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }


    public static void main(String[] args) {


        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
            };
        int k = 8;

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.kthSmallest(matrix,k));
    }

}