class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[][] temp = new int[n][n];
        backtrack(0,n,temp,list);
        return list;
    }
    public void backtrack(int count, int n, int[][] temp, List<List<String>> list){
        if(count==n){
            addArray(temp,list);
            return;
        }
        for(int i=0;i<n;i++){
            if(check(count,i,temp)){
                temp[count][i] = 1;
                backtrack(count+1,n,temp,list);
                temp[count][i] = 0;
            }
        }
    }
    public boolean check(int row, int col, int[][] temp){
        int i=0;
        while(i<row){
            if(temp[i][col]==1){
                return false;
            }
            i++;
        }
        i=0;
        while(i<col){
            if(temp[row][i]==1){
                return false;
            }
            i++;
        }
        i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(temp[i--][j--]==1){
                return false;
            }
        }
        i=row;
        j=col;
        while(i>=0 && j<temp.length){
            if(temp[i--][j++]==1){
                return false;
            }
        }
        return true;
    }
    public void addArray(int[][] temp,List<List<String>> list){
        List<String> l = new ArrayList<>();
        for(int i=0;i<temp.length;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<temp[0].length;j++){
                if(temp[i][j]==1){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            l.add(sb.toString());
        }
        list.add(l);
    }
}