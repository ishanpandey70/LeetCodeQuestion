//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.

    class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
    }
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        
        double maxValue =0;
        PriorityQueue <Item> pq = new PriorityQueue<>(n, new itemComparator());
        for (int i = 0 ; i < n ; i++)
        {
            pq.add(arr[i]);
            
        }
        
        //  for (int i = 0 ; i < n ; i++)
        // {
        //     Item a = pq.poll();
        //   System.out.println(a.value/a.weight);
          
        //   System.out.println();
        // }
        
        // System.out.println("Actual Calculation Starts");
        while(W>0 && pq.isEmpty()==false)
        {
            Item a = pq.poll();
            if(a.weight < W)
            {
                // System.out.println((double)a.value/ a.weight);
                W = W - a.weight;
                maxValue += a.value;
            //     System.out.println("current item value is" + a.value);
            //     System.out.println("current item weight is" + a.weight);
            //     System.out.println("current weight is"+W);
            //     System.out.println("current value is "+maxValue);
            }
            else if (a.weight == W)
            {
                // System.out.println(a);
                 W = W - a.weight;
                maxValue += a.value;
                // System.out.println("current item value is" + a.value);
                // System.out.println("current item weight is" + a.weight);
                // System.out.println("current weight is (should be 0)"+W);
                // System.out.println("current value is "+maxValue);
                return   maxValue;
             
            }
            else 
            {
                // System.out.println(a);
                maxValue += (double)(W*a.value)/a.weight;
                // System.out.println("current item value is" + a.value);
                // System.out.println("current item weight is" + a.weight);
                // System.out.println("current weight is"+W);
                // System.out.println("current value is "+maxValue);
                return  maxValue ;
                
            }
            
        }
        
            
        // }
    
       return maxValue; 
       
    }
}