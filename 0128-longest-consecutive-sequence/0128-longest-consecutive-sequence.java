class Solution {
    public int longestConsecutive(int[] nums) {

        // If array is empty, no consecutive sequence exists
        if (nums.length == 0) {
            return 0;
        }

        // HashSet for fast O(1) lookup and removing duplicates
        HashSet<Integer> set = new HashSet<>();

        // Add all numbers into HashSet
        for (int num : nums) {
            set.add(num);
        }

        // Variable to store the longest sequence length
        int longest = 1;

        // Loop through each unique number
        for (int num : set) {

            // Check if num is the START of a sequence
            // If num-1 exists, skip this number
            

            // num is the start of a sequence
            int currentNum = num;
            int currentLength = 1;
            if (set.contains(num - 1)) {
                continue;
            }

            // Count consecutive numbers forward
            while (set.contains(currentNum + 1)) {
                currentNum++;
                currentLength++;
            }

            // Update longest sequence found
            longest = Math.max(longest, currentLength);
        }

        // Return final result
        return longest;
    }
}
