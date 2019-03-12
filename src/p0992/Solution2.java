package p0992;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution2 {

    public int subarraysWithKDistinct(int[] A, int K) {


        int left1=0,left2=0;
        int ans = 0;
        HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        int count1 = 0;
        int count2 = 0;

        for(int right = 0; right < A.length; right++) {

            map1.put(A[right],map1.getOrDefault(A[right],0)+1);
            map2.put(A[right],map2.getOrDefault(A[right],0)+1);

            if(map1.get(A[right])==1)
                count1++;
            if(map2.get(A[right])==1)
                count2++;

            while(count1 > K) {
                map1.put(A[left1],map1.get(A[left1])-1);
                if(map1.get(A[left1])==0)
                    count1--;
                left1++;
            }
            while(count2 >= K) {
                map2.put(A[left2],map2.get(A[left2])-1);
                if(map2.get(A[left2])==0)
                    count2--;
                left2++;
            }
            ans += left2-left1;
        }
        return ans;
    }



    public static void main(String[] args) throws FileNotFoundException {

        Solution2 solution2 = new Solution2();
        int[] a = new int[] {1,2,1,2,3};
        int[] b= new int[] {1,2,1,3,4};
        int[] c= new int[] {1,2};
        int[] d= new int[] {2,2,1,1,1,2,1,1,1};

        int[] e= new int[10000];
        //490
        int r1 =0;
        r1 = solution2.subarraysWithKDistinct(a,2);
        System.out.println(r1);

        r1 = solution2.subarraysWithKDistinct(b,3);
        System.out.println(r1);

        r1 = solution2.subarraysWithKDistinct(c,1);
        System.out.println(r1);


        Scanner reader = new Scanner(new File("test992.dat"));
        int n = 0;
        while (reader.hasNext()){
            int i = reader.nextInt();
            e[n] = i;
            n++;
            //System.out.println(i);
        }

        r1 = solution2.subarraysWithKDistinct(e,490);
        System.out.println(r1);
    }
}