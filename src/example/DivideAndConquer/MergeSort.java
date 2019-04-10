package example.DivideAndConquer;

public class MergeSort {

    public void sort(int[] numbs) {

        mergesort(numbs,0,numbs.length-1);
    }

    public void mergesort(int[] A, int p,int r) {

        if (p<r) {

            int q = (p+r)/2;
            mergesort(A,p,q);
            mergesort(A,q+1,r);
            merge(A,p,q,r);
        }
    }

    public void merge(int[] A,int p,int q,int r) {

        int n1 = q-p+1;
        int n2 = r-q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

        for(int i = 0; i < n1; i++) {
            L[i] =  A[p+i];
        }
        for(int j = 0; j < n2; j++) {
            R[j] =  A[q+j+1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for(int k = p;k <= r;k++) {
            if(L[i]<=R[j]) {
                A[k] = L[i];
                i++;
            }
            else {

                A[k] = R[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int[] numbs = new int[]{0,10,5,3,4,1,7,8,2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(numbs);
        for (int i:
             numbs) {
            System.out.println(i);
        }
    }
}
