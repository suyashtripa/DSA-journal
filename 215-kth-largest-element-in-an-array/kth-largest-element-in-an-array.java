class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> min =  new PriorityQueue<>();
        for(int num:nums){
            min.add(num);
            if(min.size() > k){
                min.poll();
            }
            
        }
        return min.peek();
    }
}
        






















//         PriorityQueue<Integer> minheap= new PriorityQueue<>();
//         for(int i:nums){
//             minheap.add(i);
//             if(minheap.size() > k){
//                 minheap.poll();
//             }
//         }
//         return minheap.peek();
//     }
// }