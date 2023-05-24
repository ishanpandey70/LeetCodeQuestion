//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<ArrayList<Integer>> arr;
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int[] result = new int[n];
        for(int i =0 ;i<n ;i++)
        {
            result[i]=-1;
        }
        
        arr = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ;i<n ;i++)
        {
            arr.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges)
        {
            arr.get(edge[0]).add(edge[1]);
            arr.get(edge[1]).add(edge[0]);
        }
        
        // System.out.println(arr);
        
        int length=0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src]=true;
        q.offer(-1);
        while(q.size()>1)
        {
            int u = q.poll();
            
            
            if(u==-1)
            {
                q.offer(-1);
                length++;
            }
            else{
                 result[u]= length;
                
                        for(int x: arr.get(u))
                        {
                            if(!visited[x])
                          {
                      
                            q.add(x);
                            visited[x]= true;
                            
                            
                        }
                    }
            }
            
        }
     return result;   
    }
}