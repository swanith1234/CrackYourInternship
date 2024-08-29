import java.util.HashMap;

class GfG {
    int maxLen(int arr[], int n) {
        // HashMap to store (sum, index) pairs
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        
        int maxLength = 0; // Initialize the maximum length of subarray
        int sum = 0; // Initialize sum of elements
        
        for (int i = 0; i < n; i++) {
            sum += arr[i]; // Add current element to sum
            
            if (sum == 0) {
                // If sum is 0, it means subarray from index 0 to i has sum 0
                maxLength = i + 1;
            } else if (sumIndexMap.containsKey(sum)) {
                // If sum is already seen, a subarray with 0 sum is found
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum));
            } else {
                // Store sum with index if not seen before
                sumIndexMap.put(sum, i);
            }
        }
        
        return maxLength;
    }
}
