package p0992;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution4 {

    private int subarraysWithMostKDistinct(int[] A, int K) {

        int left=0;
        int ans = 0;
        int[] map = new int[A.length+1];
        int count = 0;

        for(int right = 0; right < A.length; right++) {


            if(++map[A[right]]==1)
                count++;

            while(count > K) {

                if(--map[A[left]]==0)
                    count--;
                left++;
            }
            ans += right-left+1;
        }
        return ans;
    }

    public int subarraysWithKDistinct(int[] A,int K) {

        return subarraysWithMostKDistinct(A,K) - subarraysWithMostKDistinct(A,K-1);
    }

    public static void main(String[] args) throws FileNotFoundException {

        Solution3 solution3 = new Solution3();
        int[] a = new int[] {1,2,1,2,3};
        int[] b= new int[] {1,2,1,3,4};
        int[] c= new int[] {1,2};
        int[] d= new int[] {2,2,1,1,1,2,1,1,1};

        int[] e= new int[10000];
        //490
        int r1 =0;
        r1 = solution3.subarraysWithKDistinct(a,2);
        System.out.println(r1);

        r1 = solution3.subarraysWithKDistinct(b,3);
        System.out.println(r1);

        r1 = solution3.subarraysWithKDistinct(c,1);
        System.out.println(r1);


        Scanner reader = new Scanner(new File("test992.dat"));
        int n = 0;
        while (reader.hasNext()){
            int i = reader.nextInt();
            e[n] = i;
            n++;
            //System.out.println(i);
        }

        r1 = solution3.subarraysWithKDistinct(e,490);
        System.out.println(r1);
    }
}