//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] in_degree = new int[v];
        
        // code here
        for(int i =0 ;i<adj.size();i++ )
        {
            for(int x : adj.get(i))
            {
                in_degree[x]++;
           
            }
        }
        // System.out.println("Print In degree");
        // for(int x: in_degree)
        // {
        //     System.out.println(x);
        // }
        // System.out.println("****************");
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ;i<v;i++)
        {
            if(in_degree[i]==0)
            {
                q.add(i);
            }
        }
        // System.out.println(q);
        int count =0 ;
        while(!q.isEmpty())
        {
            int u = q.poll();
            // System.out.println(q);
            
                count++;
                for(int x: adj.get(u))
                {
                    
                    if(--in_degree[x]==0)
                    {
                        q.add(x);
                    }
                }
            
            
            
        }
        
        
        if( count==v)
        {
            return false;
        }
        
        return true;
    
}
}