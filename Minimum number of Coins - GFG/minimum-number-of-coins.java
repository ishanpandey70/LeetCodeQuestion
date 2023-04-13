//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> minPartition(int N)
    {
        // code here
        int notes = 0;
        List<Integer> arr = new ArrayList<Integer>();
        while(N>0)
        {
            if(N>2000)
            {
                
                notes = N/2000;
                while(notes>0)
                {
                    notes--;
                arr.add(2000);
                    
                }
                N = N%2000;
            }     
            else if (N<2000 && N>=500)
            {
                notes = N/500;
                 while(notes>0)
                {
                    notes--;
                arr.add(500);
                    
                }
                N = N%500;
            } 
            else if (N<500 && N>=200)
            {
                notes = N/200;
                 while(notes>0)
                {
                    notes--;
                arr.add(200);
                    
                }
                N = N%200;
            } 
            else if (N<200 && N>=100)
            {
                notes = N/100;
                 while(notes>0)
                {
                    notes--;
                arr.add(100);
                    
                }
                N = N%100;
            } 
            else if (N<100 && N>=50)
            {
                notes = N/50;
                 while(notes>0)
                {
                    notes--;
                arr.add(50);
                    
                }
                N = N%50;
            } 
            else if (N<50 && N>=20)
            {
                notes = N/20;
                 while(notes>0)
                {
                    notes--;
                arr.add(20);
                    
                }
                N = N%20;
            } 
            else if (N<20 && N>=10)
            {
                notes = N/10;
                 while(notes>0)
                {
                    notes--;
                arr.add(10);
                    
                }
                N = N%10;
            } 
            else if (N<10 && N>=5)
            {
                notes = N/5;
                 while(notes>0)
                {
                    notes--;
                arr.add(5);
                    
                }
                N = N%5;
            } 
            else if (N<5 && N>=2)
            {
                notes = N/2;
                 while(notes>0)
                {
                    notes--;
                arr.add(2);
                    
                }
                N = N%2;
            } 
            else if (N<2 && N>=1)
            { 
                notes = N/1;
                while(notes>0)
                {
                    notes--;
                arr.add(1);
                    
                }
                
                N = N%1;
            } 
            
                
        }
        return arr;
        
    }
}