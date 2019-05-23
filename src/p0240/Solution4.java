package p0240;


import java.util.Arrays;

//sort approach running time 610 ms
public class Solution4 {
    
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length ==0)
            return false;
        if(matrix[0].length ==0)
            return false;

        int height = matrix.length;
        int width = matrix[0].length;
        int[] data = new int[height*width];
        for(int i=0;i<width;i++) {
            for (int j = 0; j < height; j++) {
                data[i+j*width] = matrix[j][i];
            }
        }
        Arrays.sort(data);
        return binarysearch(data,target,0,data.length-1);
    }

    boolean binarysearch(int[] data, int target,int lo,int hi) {

        if (hi==lo)
            return data[lo]== target;
        int mid = (lo+hi)/2;
        if (target==data[mid])
            return true;
        if(target<data[mid])
            return binarysearch(data,target,lo,mid);
        else
            return binarysearch(data,target,mid+1,hi);
    }


    public static void main(String[] args) {


        Solution4 solution3 = new Solution4();

        int[][] m = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(solution3.searchMatrix(m,5));
        System.out.println(solution3.searchMatrix(m,20));

        int[][] n = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};
        System.out.println(solution3.searchMatrix(n,15));

        int[][] o = {{-5}};
        System.out.println(solution3.searchMatrix(o,-2));

        int[][] q = {
                {1,4},{2,5}};
        System.out.println(solution3.searchMatrix(q,2));

    }
}
