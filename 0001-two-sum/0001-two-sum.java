class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashbox = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(hashbox.containsKey(diff)){
                return new int[]{hashbox.get(diff),i};
            }
            hashbox.put(nums[i],i);
        }
        return null;
    }
}