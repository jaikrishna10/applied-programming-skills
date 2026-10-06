import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            // Keep the heap size bounded to k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The top element is the kth largest element
        return minHeap.peek();
    }
}