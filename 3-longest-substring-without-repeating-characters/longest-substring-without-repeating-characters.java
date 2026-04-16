class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int prev = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.containsKey(curr) && map.get(curr) >= prev) {
                prev = map.get(curr) + 1;
            }

            map.put(curr, i);
            len = Math.max(len, i - prev + 1);
        }

        return len;                     
    }
}