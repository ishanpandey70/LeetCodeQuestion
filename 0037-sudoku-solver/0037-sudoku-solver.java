class Solution {
    int LastFreeX;
    int LastFreeY;
    char[][] boardFinal ;
    
    public void solveSudoku(char[][] board) {
       int[] arr = nextFreePoint(0, 0,board);
       LastFreePoints(board);
       solveSudokuInstance(board,arr[0],arr[1]);  
       board = boardFinal; 
        
    }

    public void LastFreePoints(char[][]board)
    {
        boolean flag = false;
        for(int i =8 ; i>=0;i--)
        {
            for(int j =8 ; j>=0;j--)
            {
                if(board[i][j]=='.')
                {
                    LastFreeX = i;
                    LastFreeY = j;
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                break;
            }
        }
    }
    public boolean solveSudokuInstance(char[][] board,int x, int y)
    {
        //base case is we found a solution and we return it 
        boardFinal = new char[9][9];
        if(x > LastFreeX && y> LastFreeY)
        {
            for(int i = 0 ; i< 9 ;i++)
            {
                for(int j = 0 ; j<9;j++)
                {
                    boardFinal[i][j]= board[i][j];
                }
            }
            return true ;
        }
        
        //Else
        boolean ansReceived = false;
        for(int i = 1 ; i<= 9 ; i++)
        {
            board[x][y]= Character.forDigit(i, 10);
            if(check(x,y,board) )
            {
               int [] arr1 = nextFreePoint(x,y,board);
                if(solveSudokuInstance(board,arr1[0],arr1[1]))
                {
                    ansReceived = true;
                }
            }
            if(!ansReceived)
            board[x][y]= '.';
            else break;
        }
        if(ansReceived)
        return true;
        return false;
    }
    
    
    
      
        
        
        public boolean checkBox(int x , int y ,char[][] board)
        {
           int boxStartX  = 3*(x/3);
           int boxStartY = 3*(y/3);
           int boxEndX= boxStartX+2;
           int boxEndY= boxStartY+2;
            for(int i = boxStartX; i<=boxEndX; i++)
            {
                for(int j = boxStartY ; j<=boxEndY; j++)
                {
                    if(i != x && j != y)
                    {
                        if (board[i][j]==board[x][y])
                        {
                            return false;
                        }
                    }
                }
            }
            return true;
            
            
        }
        
        public boolean checkRow(int x,int y,char[][] board)
        {
            for (int column = 0 ; column < 9;column++ )
            {
                if(column != y )
                {
                    if (board[x][column] == board[x][y])
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        
        public boolean checkColumn(int x,int y,char[][] board)
        {
            for (int row = 0 ; row < 9;row++ )
            {
                if(row != x )
                {
                    if (board[row][y] == board[x][y])
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        
        public boolean check(int x, int y,char[][] board){
            return checkBox(x,y,board) && checkRow(x,y,board)&& checkColumn(x,y,board);
        }

        public int[] nextFreePoint(int x, int y , char[][]board)
        {
            boolean flag = false;
            int startx = x ;
            int starty = y;
            for (int i  = x; i< 9 ; i++)
            {
                if(i==x)
                {
                    for (int j = y ; j<9; j++)
                    {
                        if(board[i][j]=='.')
                        {
                            startx = i;
                            starty = j;
                            flag =true;
                            break;
                            
                        }
                    }

                }
                else 
                {
                    for (int j = 0 ; j<9; j++)
                    {
                        if(board[i][j]=='.')
                        {
                            startx = i;
                            starty = j;
                            flag =true;
                            break;
                            
                        }
                    }
                }


                if(flag)
                {
                    break;
                }
            }
            int [] arr = new int[2];
            if(flag){
            arr[0]= startx;
            arr[1] = starty;
            }
            else {
                arr[0]=9;
                arr[1]=9;
            }
            return arr;
        }
        
}