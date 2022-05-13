class Solution {
    public int search(int[] nums, int target) {
        //for(int n: nums) {
         //   System.out.
       // }
        
        if(nums.length == 1) {
            return nums[0]==target?0:-1;
        }
        
        int first = 0;
        int last = nums.length-1;
        while(first <= last) {
            
            int idx = (last + first)/2;
            System.out.println("first is " + first + "last is " + last + " and idx is " + idx + "\n and looking for " + target);
            int curr = nums[idx];
            if(curr == target) return idx;
            if(nums[idx] < target) {
                first = idx+1;
            } else  {
                last = idx-1;
            }
        }
        
        return -1;
    }
}
