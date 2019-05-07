package CLRS;

public class CoutingSort {

    int[] B;
    int[] C;
    int[] sort(int[] A,int k) {

        C = new int[k+1];
        B = new int[A.length];

        for(int i=0;i<A.length;i++) {
            C[A[i]]++;
        }

        for(int i=1;i<k+1;i++) {
            C[i] = C[i]+C[i-1];
        }

        for (int i = A.length-1;i>=0;i--) {
            System.out.println(A[i]);
            System.out.println(C[A[i]]);
            B[C[A[i]]-1] = A[i];
            C[A[i]]--;
        }
        return B;
    }

    public static void main(String[] args) {

        int[] A = new int[]{2,5,3,0,2,3,0,3};
        CoutingSort cs = new CoutingSort();
        int[] B = cs.sort(A,5);
        System.out.println(B.toString());
    }
}
