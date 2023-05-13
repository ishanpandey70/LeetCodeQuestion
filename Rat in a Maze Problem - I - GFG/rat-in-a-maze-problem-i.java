//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
     
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> arr;
         ArrayList<Character> path ;
        boolean[][] visited = new boolean[n][n];
        path = new ArrayList<>();
        arr = new ArrayList<>();
        if(m[0][0]==0)
        {
            arr.add("-1");
            return arr;
        }
        visited[0][0]= true;
        // System.out.println("chose Right");
        // path.add('R');
        solve(0,1,'R',m,n,visited,arr,path);
        if(path.size()>0)
        path.remove(path.size()-1);
        // path.add('D');
        
        // System.out.println("Chose Down");
        solve(1,0,'D',m,n,visited,arr,path);
        if(path.size()>0)
        path.remove(path.size()-1);
        
       return arr;
    }
    public static void  solve(int x , int y ,char move ,int [][]m , int n, boolean [][] visited, ArrayList<String> arr ,ArrayList<Character> path )
    {
        
        
        if(x<0 || x >= n)
        {
            return ;
        }
        if(y<0 || y >= n)
        {
            return ;
        }
        //Base Case
        if(m[x][y]==0)
        {
            return;
        }
        
        
        if((x == n-1 && y == n-1) && visited[x][y]==false)
        {
            // System.out.println("At "+ "("+ x+","+y+")");
           
            
            visited[x][y]= true;
            path.add(move);
            // System.out.println(path);
            // System.out.println(path.toString());
            
            StringBuilder sb = new StringBuilder();
            for (Character c : path) {
            sb.append(c);
            }
            String result = sb.toString();
            arr.add(result);
            // System.out.println("Path size is "+path.size());
           if(path.size()>0)
            path.remove(path.size()-1);
            visited[x][y]= false;
            return;
            
        }
        
        
        //Recursion
        visited[x][y]= true;
        
        path.add(move);
        
        if(x>=0 && x< n && y-1>=0 && y-1<n && visited[x][y-1]== false && m[x][y-1]==1)
        solve(x,y-1, 'L',m,n ,visited,arr,path); //up
        
        if(x>=0 && x< n && y+1>=0 && y+1<n && visited[x][y+1]== false  && m[x][y+1]==1)
       {
        //   System.out.println("Chose down");
           solve(x,y+1, 'R',m,n ,visited,arr,path); 
           
       }//down
        
        if(x-1>=0 && x-1< n && y>=0 && y<n && visited[x-1][y]== false  && m[x-1][y]==1)
        solve(x-1,y, 'U',m,n,visited,arr,path); //left
        
        if(x+1>=0 && x+1< n && y>=0 && y<n && visited[x+1][y]== false  && m[x+1][y]==1)
        {
            // System.out.println("Chose right");
            solve(x+1,y, 'D',m,n,visited,arr,path);
            
        } //right
        
        visited[x][y]= false;
        if(path.size()>0)
        path.remove(path.size()-1);
        
        
    }
    
}