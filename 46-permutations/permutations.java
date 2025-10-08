class Solution {
    public void helper(int[] nums,List<Integer> ds,boolean[] isvailid,List<List<Integer>> ans){
        int n = nums.length;
        if(ds.size() == n){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<ds.size();i++){
                list.add(ds.get(i));
            }
            ans.add(list);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(isvailid[i] == false){
                ds.add(nums[i]);
                isvailid[i] = true;
                helper(nums,ds,isvailid,ans);
                isvailid[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] isvailid = new boolean[nums.length];
        helper(nums,ds,isvailid,ans);
        return ans;
    }
}