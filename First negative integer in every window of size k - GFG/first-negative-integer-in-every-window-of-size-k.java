//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int k)
    {
        
        //check with arraylist also , using linked list as it is easy to remove first element in o(1)
        LinkedList<Long> arr = new LinkedList<>();
        long[] result = new long[A.length -k +1];
        int ans =0 ;
        int i =0 , j = 0 ; 
        while(j<A.length)
        {
            if(A[j]<0)
            {
                arr.add(A[j]);
            }
            
            if(j-i+1<k)
            {
                j++;
            }
            else if( j -i +1 ==k)
            {
                if(arr.isEmpty())
                {
                   result[ans]= 0; 
                }
                else{
                    result[ans]= arr.getFirst();
                }
                
                ans++;
                j++;
                if(arr.isEmpty()==false && A[i] ==arr.getFirst())
                {
                   arr.removeFirst(); 
                }
                
                i++;
                
            }
            
            
        }
        
        
            return result;
    }
}