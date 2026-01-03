class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]","");
        int st = 0;
        int l = s.length()-1;
        while(st < l){
            if(s.charAt(st) != s.charAt(l)){
                return false;
            }
            st++;
            l--;
        }
        return true;
    }
}