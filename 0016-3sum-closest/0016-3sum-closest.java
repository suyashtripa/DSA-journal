class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        int resultSum = nums[0] + nums[1] + nums[2]; // Initialize resultSum with the first three numbers
        int minDifference = Integer.MAX_VALUE; // Initialize minDifference to the maximum possible value

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right]; // Calculate the sum of the three numbers
                
                // If the sum equals the target, return the sum
                if (sum == target) {
                    return sum;
                }
                
                // Calculate the difference from the target
                int diffToTarget = Math.abs(sum - target);
                
                // Update resultSum if the current sum is closer to the target
                if (diffToTarget < minDifference) {
                    resultSum = sum; // Update resultSum to the current sum
                    minDifference = diffToTarget; // Update minDifference to the current difference
                }
                
                // Move pointers based on the comparison of sum and target
                if (sum < target) {
                    left++; // Move left pointer to the right
                } else {
                    right--; // Move right pointer to the left
                }
            }
        }
        
        return resultSum; // Return the closest sum found
    }
}