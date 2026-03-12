import java.util.*;

class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, k);
    }

    private int helper(String s, int k) {
        if (s.length() < k) return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Find invalid character
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) < k) {
                int left = helper(s.substring(0, i), k);
                int right = helper(s.substring(i + 1), k);
                return Math.max(left, right);
            }
        }

        // All characters valid
        return s.length();
    }
}