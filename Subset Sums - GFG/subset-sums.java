//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList ar;
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ar= new ArrayList<>();
        // if(N==1)
        // {
        //     ar.add(arr.get(0));
        //     return ar;
        // }
        helper(arr,ar,0, N-1);
        return ar;
        
    }
    void helper(ArrayList<Integer> arr ,ArrayList<Integer> ar,int sum , int ptr)
    {
        
        if(ptr<0)
        {
            // System.out.println(sum);
            ar.add(sum);
            return;
        }
        helper(arr,ar,sum, ptr-1);
        helper(arr,ar,sum+ arr.get(ptr),ptr-1);
            
        
        
    }
    
    
}