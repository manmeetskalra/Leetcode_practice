class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O'){
                    boolean[] res = new boolean[1];
                    res[0] = true;
                    isIsland(board,i,j,res);
                    if(res[0]){
                        fill(board,'X','A');
                    } else{
                        fill(board,'B','A');
                    }
                }
            }
        }
        fill(board,'O','B');
    }
    public void isIsland(char[][] board, int i, int j, boolean[] res){
        if(i<0 || i>board.length-1 || j<0 || j>board[i].length-1 || board[i][j]=='X' || board[i][j]=='A'){
            return;
        }
        if(i==0 || i==board.length-1 || j==0 || j==board[i].length-1){
            System.out.println("Inside");
            System.out.println(i + ", " + j);
            res[0] = false;
        }
        board[i][j]='A';
        isIsland(board, i-1, j, res);
        isIsland(board, i+1, j, res);
        isIsland(board, i, j-1, res);
        isIsland(board, i, j+1, res);
        
    }
    public void fill(char[][] board, char c, char compare){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==compare){
                    board[i][j] = c;
                }
            }
        }
    }
}

// "O","X","O"
// "X","O","X"
// "O","X","O"
// "O","O","O","O","O","O"
// "O","X","X","X","X","O"
// "O","X","O","O","X","O"
// "O","X","O","O","X","O"
// "O","X","X","X","X","O"
// "O","O","O","O","O","O"