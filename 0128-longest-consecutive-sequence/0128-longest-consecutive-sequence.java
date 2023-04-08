class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        { return 0;}
           
        
        Arrays.sort(nums);
        int count = 1;
        int maxCount =1;

        for(int i = 1  ;i< nums.length; i++)
        {
            if(nums[i]== 1+ nums[i-1] )
            {
                count++;
            }
            else if(nums[i]==  nums[i-1] ){
                continue;

            }
            else {
                maxCount = Math.max(maxCount, count);
                count =1;

            }
        }
       return Math.max(maxCount,count);
        
    }
}