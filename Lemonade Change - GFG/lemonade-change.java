//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
       HashMap<Integer, Integer> h = new HashMap<>();
       h.put(5,0);
       h.put(10,0);
       h.put(20,0);
       for(int i = 0 ; i<bills.length;i++)
       {
        //   System.out.println(h);
           if(bills[i] == 5)
           {
              h.put(5, h.getOrDefault(5,0)+1); 
           }
           else if(bills[i]==10)
           {
               if(h.get(5)<=0)
               {
                   return false;
               }
               else 
               {
                   h.put(10, h.getOrDefault(10,0)+1);
                   h.put(5,h.get(5)-1);
                   
               }
           }
           else
           {
               if(h.get(5)<=0)
               {
                  return false;
                  
                  
               }
        
               else 
               {
                   
                   if(h.get(10)<=0 && h.get(5)>=3)
                   {
                      h.put(20, h.get(20)+1);
                      h.put(5,h.get(5)-3);
                      
                      
                   }
                   else if (h.get(10) >=1 && h.get(5)>=1)
                   {
                         h.put(10, h.get(10)-1);
                         h.put(5, h.get(5)-1);
                          h.put(20,h.get(20)+1);
                         
                   }
                   
                  else return false;
                  
                   
               }
           }
           
           
       }
       
       
        
     return true;   
    }
}
