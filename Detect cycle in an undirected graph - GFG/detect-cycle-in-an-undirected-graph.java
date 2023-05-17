//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
        class Node{
            int current ;
            int parent;
            public  Node (int current , int parent ){
                this.current = current; 
                this.parent= parent;
            }
        }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        //using BFS
        
        boolean visited[] = new boolean [V+1];
        Queue <Node> q = new LinkedList<>();
        boolean ans = false;
        for(int i =0;  i< V; i++)
        {
            if(!visited[i]){
              ans = ans || BFS(i,-1,V,adj, visited,q);
            }
        }
        return ans;
    }
    public boolean BFS(int src, int parent,int V ,ArrayList<ArrayList<Integer>> adj, boolean visited[], Queue <Node> q )
    {
        Node p =new Node(src, parent);
        q.add(p);
        visited[p.current]= true;
        while(q.isEmpty()==false)
        {
            Node u = q.poll();
            for(int x : adj.get(u.current))
            {
                if(!visited[x])
                {
                    q.add(new Node(x,u.current));
                    visited[x]=true;
                }
                else 
                {
                    if(x!= u.parent)
                    {
                        return true;
                        
                    }
                    
                }
            }
            
        }
        return false;
    }
}