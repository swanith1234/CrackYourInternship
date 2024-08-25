import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;  // endWord not in wordList
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1;  // Start with the beginWord itself

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                
                if (word.equals(endWord)) {
                    return length;
                }
                
                // Explore all possible one-letter transformations
                for (int j = 0; j < word.length(); j++) {
                    char[] wordChars = word.toCharArray();
                    char originalChar = wordChars[j];
                    
                    // Try changing each character from 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;  // Skip if it's the same character
                        
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        
                        // If the transformed word is in the set and not yet visited
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);  // Mark this word as visited
                        }
                    }
                }
            }
            length++;
        }

        return 0;  // No transformation sequence found
    }
}
