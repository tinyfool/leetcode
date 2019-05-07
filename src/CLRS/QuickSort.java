package CLRS;

import java.util.Random;

public class QuickSort {

    private int[] _A;

    void sort(int p, int r) {

        if (p < r) {
            int q = partition(p, r);
            sort(p, q - 1);
            sort(q + 1, r);
        }
    }

    void randSort(int p, int r) {

        if (p < r) {
            int q = randomRange(p, r);
            randSort(p, q - 1);
            randSort(q + 1, r);
        }
    }

    int randomRange(int p, int r) {

        Random rand = new Random();
		return rand.nextInt((r -p)+1)+p;
    }

    int randomPartition(int p,int r) {
        int i = randomRange(p,r);
        exchange(i,r);
        return partition(p,r);
    }

    int partition(int p,int r){

        int x = _A[r];
        int i = p - 1;
        for (int j = p;j<=r-1;j++) {

            if (_A[j]<=x) {

                i++;
                exchange(i,j);
            }
        }
        exchange(i+1,r);
        return i+1;
    }

    void exchange(int i,int j) {

        int temp = _A[i];
        _A[i] = _A[j];
        _A[j] = temp;
    }

    public static void main(String[] args) {

        int[] A = new int[]{2,8,7,1,3,5,6,4};
        QuickSort qs = new QuickSort();
        qs._A = A;
        int q = qs.partition(0,A.length-1);
        System.out.println(q);
        qs.sort(0,A.length-1);
        System.out.println(qs._A);
    }
}
