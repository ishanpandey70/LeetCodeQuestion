class Solution {
    int count=0;
    public int reversePairs(int[] nums) {

         mergeSort(nums , 0 , nums.length-1);
        return count; 
    }
    
    public void mergeSort(int[] nums , int low , int high)
    {
        if(high>low){
        int mid = low + (high-low)/2;
        mergeSort(nums, low, mid );
        mergeSort(nums , mid+1, high);
        merge(nums,low ,mid,high);
        } 
        
    }
    public int merge(int[] nums ,int low , int mid,int high)
    {
        int n1 = mid - low+1; int n2 = high - mid ;
        int [] a = new int [n1];
        int []b = new int[n2];
        // System.out.println("a is ");
        for(int i  = 0 ; i< n1; i++)
        {
            a[i] = nums[low+i];
            // System.out.print(a[i]+" ");
        }
        // System.out.println();
            // System.out.println("b is ");

        for(int i = 0 ; i< n2; i++)
        {
            b[i] = nums[mid+1+i];
            // System.out.print(b[i] + " ");
        }
        // System.out.println();
      
        int end = 0;
        for (int start = 0; start < n1; start++) {

            
            while (end < n2 && a[start] > (2 * (long)b[end]))
               { end++;
                
                }

            count += end;
            // System.out.println("count is" + count);
        }



        int i = 0 , j =0 , k =low; 

        while(i<n1 && j<n2) 
        {
            if(a[i] <= b[j])
            {
                nums[k] = a[i];
                i++;
                k++;
            }
            else {
                
                nums[k] = b[j];
                k++;
                j++;
            }
        }
        while (i<n1){
            nums[k ] = a[i];
            i++;
            k++;

        }
        while (j<n2){
            nums[k ] = b[j];
            j++;
            k++;
            
        }
    return count;
    }
}