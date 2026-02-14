class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length()); // Shorter string is smaller
            }
            return a.compareTo(b); // If same length, compare alphabetically
        });
        for(String i:nums){
            heap.offer(i);
            if(heap.size() > k){
                heap.poll();
            }

        }
        return heap.peek();
        
    }
}