class Solution {
    public int searchInsert(int[] nums, int target) {
        //binary search modification
        int i = 0;
        int j = nums.length;
        if(nums[0]>target) return 0;
        while(j>=0 && i<j && i<nums.length){
            int k = (i+j)/2;

            if(nums[k]==target) return k;  
            if(k != 0 && nums[k] > target && nums[k-1] < target) return k;
            if( k != nums.length-1 && nums[k] < target && nums[k+1] > target) return k+1;

            if(target<nums[k]){
                j = k-1;
            }
            else{
                i = k+1;
            }
        }
        return (i+j)/2;
    }
}