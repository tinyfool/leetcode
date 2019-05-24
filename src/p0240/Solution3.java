package p0240;

//split to 4 area approch running time 7 ms
public class Solution3 {


    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length ==0)
            return false;
        if(matrix[0].length ==0)
            return false;

        int y2 = matrix.length-1;
        int x2 = matrix[0].length-1;
        return searchMatrixfun(matrix,target,0,0,x2,y2);
    }

    boolean searchMatrixfun(int[][] matrix, int target,int x1,int y1,int x2,int y2) {

        if (x1==x2&& y1==y2)
            return matrix[y1][x1]==target;
        int xmid = (x1+x2)/2;
        int ymid = (y1+y2)/2;

        boolean b1=false,b2=false,b3=false,b4=false;

        if (target==matrix[y1][x1] || target==matrix[ymid][xmid])
            return true;

        if (target>matrix[y1][x1] && target<matrix[ymid][xmid])
            b1 = searchMatrixfun(matrix,target,x1,y1,xmid,ymid);

        if(x1!=x2) {
            if (target == matrix[y1][xmid + 1] || target == matrix[ymid][x2])
                return true;
            if (target > matrix[y1][xmid + 1] && target < matrix[ymid][x2])
                b2 = searchMatrixfun(matrix, target, xmid + 1, y1, x2, ymid);
        }
        if(y1!=y2) {

            if (target == matrix[ymid + 1][x1] || target == matrix[y2][xmid])
                return true;
            if (target > matrix[ymid + 1][x1] && target < matrix[y2][xmid])
                b3 = searchMatrixfun(matrix, target, x1, ymid + 1, xmid, y2);

        }
        if(x1!=x2 && y1!=y2) {
            if (target == matrix[ymid + 1][xmid + 1] || target == matrix[y2][x2])
                return true;
            if (target > matrix[ymid + 1][xmid + 1] && target < matrix[y2][x2])
                b4 = searchMatrixfun(matrix, target, xmid + 1, ymid + 1, x2, y2);
        }
        return (b1||b2||b3||b4);
    }


    public static void main(String[] args) {


        Solution3 solution3 = new Solution3();

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

    }
}
