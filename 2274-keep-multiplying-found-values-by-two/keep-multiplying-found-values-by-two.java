class Solution {
    public int findFinalValue(int[] nums, int original) {

        boolean found = true;

        while (found) {
            found = false;  // reset

            for (int num : nums) {
                if (num == original) {
                    original = original * 2;
                    found = true;
                    break; 
                }
            }
        }

        return original;
    }
}
