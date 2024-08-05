import java.util.*;

class Solution {
    public String removeDuplicates(String s, int k) {
        // Stack to keep track of characters and their counts
        Deque<Pair> stack = new LinkedList<>();
        
        // Traverse the string
        for (char c : s.toCharArray()) {
            // If stack is not empty and top element has the same character
            if (!stack.isEmpty() && stack.peek().ch == c) {
                // Increment the count of the top element
                stack.peek().count++;
                // If count reaches k, pop the element from the stack
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                // Otherwise, push the character with count 1 onto the stack
                stack.push(new Pair(c, 1));
            }
        }
        
        // Reconstruct the result from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.removeLast(); // Remove from the end to get the correct order
            for (int i = 0; i < p.count; i++) {
                result.append(p.ch);
            }
        }
        
        return result.toString();
    }
    
    // Helper class to store a character and its count
    private static class Pair {
        char ch;
        int count;
        
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
