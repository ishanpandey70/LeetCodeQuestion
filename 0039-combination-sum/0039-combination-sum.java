class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.result = new ArrayList<List<Integer>>();
        comboSum(candidates, target, candidates.length, new ArrayList<Integer>());
        
    return result;
    }
    public void comboSum(int[] candidates , int target, int size, ArrayList<Integer> arr){
        
        // System.out.println("target is " +target);
        // System.out.println("and arraylist is "+ arr);
        
        if(target == 0)
        {
            // arrAns = 
            this.result.add(new ArrayList<>(arr));
            arr.remove(arr.size()-1);
            return;
        }
        if(size==0|| target <=1 )
        {
            // System.out.println("must make a new array List");
            if(arr.size()!=0)
             arr.remove(arr.size()-1);
            // System.out.println(arr);
            return;
        }
        if(candidates[size-1] <= target)
        {
            
            arr.add(candidates[size-1]);
            
            comboSum(candidates,target -(arr.get(arr.size()-1)),size,arr);
             // arr.remove(arr.size()-1);
            comboSum(candidates, target, size-1 , arr );
           
        }
        else comboSum(candidates, target, size-1 , arr );
    }
    
    
    
}