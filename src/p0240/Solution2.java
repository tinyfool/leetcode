package p0240;

public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length ==0)
            return false;
        if(matrix[0].length ==0)
            return false;
        return searchMatrixfunV(matrix,target,0,matrix.length-1);
    }

    boolean searchMatrixfunV(int[][] matrix, int target,int i1,int i2) {

        StringBuilder sb = new StringBuilder();
        sb.append(i1).append(":").append(i2).append(":V");
        //System.out.println(sb.toString());
        if (i1==i2)
            return searchMatrixfunH(matrix[i1],target,0,matrix[i1].length-1);
        int mid = (i1+i2)/2;
        boolean top,bottom = false;
        if (target==matrix[mid][matrix[mid].length-1] || target==matrix[mid+1][0])
            return true;

        if (target>matrix[mid][matrix[mid].length-1])
            top =false;
        else
            top = searchMatrixfunV(matrix,target,i1,mid);
        if (target<matrix[mid+1][0])
            bottom = false;
        else
            bottom = searchMatrixfunV(matrix,target,mid+1,i2);
        if (top||bottom)
            return true;
        return false;
    }

    boolean searchMatrixfunH(int[] line,int target,int lo,int hi) {

        StringBuilder sb = new StringBuilder();
        sb.append(lo).append(":").append(hi).append(":H");
        //System.out.println(sb.toString());

        if (lo == hi )
            return  line[lo]==target;

        int mid = (lo+hi)/2;
        if (target == line[mid])
            return true;
        if (target<line[mid])
            return searchMatrixfunH(line,target,lo,mid);
        else
            return searchMatrixfunH(line,target,mid+1,hi);
    }

    public static void main(String[] args) {

        int[][] m = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.searchMatrix(m,5));
        System.out.println(solution2.searchMatrix(m,20));
        int[] line = {2, 5, 8, 12, 19};
        System.out.println(solution2.searchMatrixfunH(line,5,0,4));
    }
}
