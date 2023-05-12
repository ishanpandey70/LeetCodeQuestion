class Solution {

    class Location{
        int x;
        int y;
        public Location(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }


    public List<List<String>> solveNQueens(int n) {
        //Ans will store the final output configurations of the board
        List<List <String>> ans  = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        Location[] QueenPosition = new Location[n];
        for(int i = 0 ; i< n ; i++)
        {
            for(int j = 0 ; j<n ;j++)
            {
                board[i][j]= '.';
            }
        }
        //Adding first queen to column 1, can have cases  = number of rows so placing one queen and using recursion
        
        
           
            
            solve(0,board, ans, QueenPosition); 
           
        
        
        
      

        return ans;
            
    }
    public List<String> constructBoard(char[][] board)
    {
        List<String> res= new ArrayList<String>();
        for(char[] arr : board)
        {
            res.add(new String(arr));
        }
        return res;
    }
    public void solve( int column ,char[][] board, List<List<String>> res, Location[] QueenPos)
    {

        
        if(column== board.length)
        {
            res.add(constructBoard(board));
            return;
        }


     
        for(int row =0 ; row< board.length ; row++)
        { 
            
            if(checkPosition(row, column, QueenPos))
            {
                board[row][column]= 'Q';
                QueenPos[column] = new Location(row,column);

                solve( column+1,board, res,QueenPos);
                board[row][column]= '.';
                QueenPos[column] = null;  
            
            }

            
           


        }
        






       


        return ;
    }
    public boolean checkPosition(int row, int column , Location[] QueenPos)
    {
        for(Location a : QueenPos)
        {
            if(a != null && a.x == row)
            {
                return false;
            }
            else if (a != null && a.y == column)
            {
                return false;
            }
            else if(a != null  && Math.abs(a.x-row)== Math.abs(a.y-column) )
            {
                return false;
            }
        }
        return true;
    }
}