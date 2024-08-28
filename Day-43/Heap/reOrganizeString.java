import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String reorganizeString(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a max-heap based on the frequency of characters
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(frequencyMap.entrySet());

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prevEntry = null;

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            
            // Append the most frequent character to the result
            result.append(currentEntry.getKey());

            // If there was a previous character, add it back to the heap if it still has a count
            if (prevEntry != null && prevEntry.getValue() > 0) {
                maxHeap.offer(prevEntry);
            }

            // Decrement the frequency and set prevEntry to currentEntry
            currentEntry.setValue(currentEntry.getValue() - 1);
            prevEntry = currentEntry;
        }

        // Step 4: If the result length matches the input, return it; otherwise, return ""
        return result.length() == s.length() ? result.toString() : "";
    }
}
