package p0036;

//Runtime: 2 ms, faster than 89.95% of Java online submissions for Valid Sudoku.
//Memory Usage: 42.4 MB, less than 95.99% of Java online submissions for Valid Sudoku.
public class Solution {

    public boolean isValidSudoku(char[][] board) {

        if(!checkRow(board))
            return false;
        if(!checkCol(board))
            return false;
        if(!check3_3(board))
            return false;
        return true;
    }

    private boolean checkRow(char[][] board) {

        int[] tester;
        for(int i = 0;i < 9;i++) {
            tester = new int[9];
            for(int j =0;j<9;j++){
                if(board[i][j]!='.')
                    tester[board[i][j]-'1']++;
            }
            if(!checkTest(tester))
                return false;
        }
        return true;
    }

    private boolean checkCol(char[][] board) {

        int[] tester;
        for(int i = 0;i < 9;i++) {
            tester = new int[9];
            for(int j =0;j<9;j++){
                if(board[j][i]!='.')
                    tester[board[j][i]-'1']++;
            }
            if(!checkTest(tester))
                return false;
        }
        return true;
    }

    private boolean check3_3(char[][] board) {

        int[] tester;
        for(int i = 0;i < 3;i++) {
            for(int j =0;j<3;j++) {

                tester = new int[9];
                for (int m = 0; m < 3; m++){
                    for (int n = 0; n < 3; n++){
                        if(board[i*3+m][j*3+n]!='.')
                            tester[board[i*3+m][j*3+n]-'1']++;
                    }
                }
                if(!checkTest(tester))
                return false;
            }
        }
        return true;
    }


    boolean checkTest(int[] tester) {
        for(int num:tester) {
            if(num>1)
                return false;
        }
        return true;
    }
}
