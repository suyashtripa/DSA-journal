class Solution {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for(char c:tiles.toCharArray()){
            count[c-'A']++;
        }
        return backtrac(count);
        
    }
    private int backtrac(int[] count){
        int total =0;
        for(int i=0;i<26;i++){
            if(count[i]>0){
                count[i]--;
                total++;
                total += backtrac(count);
                count[i]++;
            }


        }
        return total;

    }
}