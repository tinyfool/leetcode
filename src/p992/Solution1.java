package p992;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution1 {

    public int subarraysWithKDistinct(int[] A, int K) {

        Set subs = new HashSet<String>();
        Set MaxSubs = new HashSet<int[]>();
        submaxwk(A,K,MaxSubs);
        Iterator iterator = MaxSubs.iterator();
        while (iterator.hasNext()) {
            int[] index = (int[]) iterator.next();

            StringBuilder sb = new StringBuilder();
            sb.append(index[0]).append(",").append(index[1]);
            subs.add(sb.toString());

            int size = index[1]-index[0]+1;
            if (size<=K)
                continue;
            for (int i=K;i<size;i++) {
                for(int j=index[0];j<index[0]+size-K;j++) {

                    if (j+i>=A.length)
                        continue;
                    int[] newA = Arrays.copyOfRange(A,j,j+i);
                    if (countNum(newA)==K) {
                        StringBuilder sb1 = new StringBuilder();
                        sb1.append(j).append(",").append(j+i-1);
                        subs.add(sb1.toString());
                        sb1.append(":");
                        for (int w=0;w<newA.length;w++) {
                            sb1.append(newA[w]).append(",");
                        }
                        //System.out.println(sb1.toString());
                    }
                }
            }
        }
        Iterator ret = subs.iterator();
        while (ret.hasNext()) {

            String retString = (String)ret.next();
            //System.out.println(retString);
        }
        return subs.size();
    }

    private void submaxwk(int[] A,int k,Set subsSet) {

        if (A.length<= k)
            return;

        Set numbs = new HashSet<Integer>();
        for (int i=0;i<A.length;i++) {

            numbs.clear();
            numbs.add(A[i]);
            for (int j = i; j < A.length; j++) {

                numbs.add(A[j]);
                if (numbs.size() > k) {

                    if (j - i >= k) {
                        subsSet.add(new int[]{i,j-1});
                    }
                    break;
                } else if (j == A.length - 1 && numbs.size() == k) {
                    subsSet.add(new int[]{i,j});
                }
            }
        }
        return;
    }

    private int countNum(int[]A) {

        Set numbs = new HashSet<Integer>();
        for(int i=0;i<A.length;i++) {
            numbs.add(A[i]);
        }
        return numbs.size();
    }

    public static void main(String[] args) throws FileNotFoundException {

        Solution1 s1 = new Solution1();
        int[] a = new int[] {1,2,1,2,3};
        int[] b= new int[] {1,2,1,3,4};
        int[] c= new int[] {1,2};
        int[] d= new int[] {2,2,1,1,1,2,1,1,1};

        int[] e= new int[10000];
        //490
        int r1 =0;
//        r1 = s1.subarraysWithKDistinct(a,2);
//        System.out.println(r1);
//
//        r1 = s1.subarraysWithKDistinct(b,3);
//        System.out.println(r1);
//
//        r1 = s1.subarraysWithKDistinct(c,1);
//        System.out.println(r1);


        Scanner reader = new Scanner(new File("test992.dat"));
        int n = 0;
        while (reader.hasNext()){
            int i = reader.nextInt();
            e[n] = i;
            n++;
            System.out.println(i);
        }

        r1 = s1.subarraysWithKDistinct(e,490);
        System.out.println(r1);
    }
}