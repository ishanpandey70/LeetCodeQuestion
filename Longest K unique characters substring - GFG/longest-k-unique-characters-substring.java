//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int i = 0 , j= 0; 
        int maxSize = -1;
        int size =0;
        HashMap<Character, Integer> h = new HashMap<>();
        while(j< s.length())
        {
            h.put(  s.charAt(j),   (h.getOrDefault(s.charAt(j),0)+1)   );
            size = h.size();
            if(size< k)
            {
                j++;
            }
            else if (size == k )
            {
                maxSize = Math.max(maxSize, j-i+1);
                j++;
            }
            else
            {
                while(size > k && i<=j)
                {
                    if(h.get(s.charAt(i)) == 1)
                    {
                        h.remove(s.charAt(i));
                        
                    }
                    else if(h.get(s.charAt(i)) >1 )
                    {
                        h.put(s.charAt(i),h.get(s.charAt(i)) -1);
                    }
                    size = h.size();
                    
                i++;
                }
                
                j++;
                
                
                
            }
            
            
            
            
            
            
        }
    return maxSize;
    }
}