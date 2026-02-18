class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int l = nums.length - 1;
        
        while (s < l) {
            int mid = s + (l - s) / 2;
            
            if (nums[mid] > nums[l]) {
                s = mid + 1;   // minimum is on right
            } else {
                l = mid;       // minimum is on left including mid
            }
        }
        
        return nums[s];  // or nums[l]
    }
}
