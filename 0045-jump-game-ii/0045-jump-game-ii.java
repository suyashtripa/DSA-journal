class Solution {
    public int jump(int[] nums) {
        int jumps = 0;         // number of jumps taken
        int end = 0;           // current jump boundary
        int farthest = 0;      // farthest index we can reach

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump range
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }

        return jumps;
    }
}





























