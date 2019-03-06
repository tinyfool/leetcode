package p992;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution3 {
    private int subarraysWithMostKDistinct(int[] A, int K) {

        int left=0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count1 = 0;

        for(int right = 0; right < A.length; right++) {

            map.put(A[right],map.getOrDefault(A[right],0)+1);

            if(map.get(A[right])==1)
                count1++;

            while(count1 > K) {
                map.put(A[left],map.get(A[left])-1);
                if(map.get(A[left])==0)
                    count1--;
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

        Solution4 solution4 = new Solution4();
        int[] a = new int[] {1,2,1,2,3};
        int[] b= new int[] {1,2,1,3,4};
        int[] c= new int[] {1,2};
        int[] d= new int[] {2,2,1,1,1,2,1,1,1};

        int[] e= new int[10000];
        //490
        int r1 =0;
        r1 = solution4.subarraysWithKDistinct(a,2);
        System.out.println(r1);

        r1 = solution4.subarraysWithKDistinct(b,3);
        System.out.println(r1);

        r1 = solution4.subarraysWithKDistinct(c,1);
        System.out.println(r1);


        Scanner reader = new Scanner(new File("test992.dat"));
        int n = 0;
        while (reader.hasNext()){
            int i = reader.nextInt();
            e[n] = i;
            n++;
            //System.out.println(i);
        }

        r1 = solution4.subarraysWithKDistinct(e,490);
        System.out.println(r1);
    }
}