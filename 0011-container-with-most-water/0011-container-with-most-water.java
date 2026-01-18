class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int s = 0;
        int e = height.length - 1;

        while (s < e) {
            int area = (e - s) * Math.min(height[s], height[e]);
            ans = Math.max(ans, area);

            if (height[s] < height[e]) {
                s++;
            } else {
                e--;
            }
        }
        return ans;
    }
}
