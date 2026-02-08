class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return result;
    }

    private void solve(int[] nums, int idx, List<Integer> temp) {

        if (idx == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // include current element
        temp.add(nums[idx]);
        solve(nums, idx + 1, temp);

        // backtrack
        temp.remove(temp.size() - 1);

        // exclude current element
        solve(nums, idx + 1, temp);
    }
}
