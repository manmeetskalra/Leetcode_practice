class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                boolean valid = true;
                valid = valid && checkRow(board,i,board[i][j]);
                valid = valid && checkColumn(board,j,board[i][j]);
                valid = valid && checkMatrix(board,((i/3)*3),(((i/3)+1)*3)-1,((j/3)*3),(((j/3)+1)*3)-1,board[i][j]);
                if(!valid){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkRow(char[][] board, int row, int val){
        int ctr=0;
        for(int i=0;i<9;i++){
            if(board[row][i]==val){
                ctr++;
            }
        }
        return ctr==1;
    }
    public boolean checkColumn(char[][] board, int col, int val){
        int ctr=0;
        for(int i=0;i<9;i++){
            if(board[i][col]==val){
                ctr++;
            }
        }
        return ctr==1;
    }
    public boolean checkMatrix(char[][] board, int startRow, int endRow, int startCol, int endCol, int val){
        int ctr=0;
        for(int i=startRow;i<=endRow;i++){
            for(int j=startCol;j<=endCol;j++){
                if(board[i][j]==val){
                    ctr++;
                }
            }
        }
        return ctr==1;
    }
}

// 0-2: 0 - 2 [(i/3)*3, (j/3)*3], [((i/3)+1)*3-1, ((j/3)+1)*3]