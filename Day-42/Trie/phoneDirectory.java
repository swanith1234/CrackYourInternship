//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends



// Trie Node Class
class TrieNode {
    HashMap<Character, TrieNode> children;
    Set<String> words; // Use Set to avoid duplicates

    TrieNode() {
        children = new HashMap<>();
        words = new HashSet<>();
    }
}

// Trie Class
class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            node.words.add(word); // Add word to the set
        }
    }

    List<String> searchPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return Collections.emptyList(); // Return empty list if no match
            }
            node = node.children.get(c);
        }
        List<String> result = new ArrayList<>(node.words);
        Collections.sort(result); // Sort the results
        return result;
    }
}

// Solution Class
class Solution {
    static ArrayList<ArrayList<String>> displayContacts(int n, String[] contact, String s) {
        Trie trie = new Trie();
        
        // Insert all contacts into the Trie
        for (String word : contact) {
            trie.insert(word);
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        
        // Process each prefix of the query string
        for (char c : s.toCharArray()) {
            prefix.append(c);
            List<String> matchingWords = trie.searchPrefix(prefix.toString());
            
            if (matchingWords.isEmpty()) {
                result.add(new ArrayList<>(Collections.singletonList("0")));
            } else {
                result.add(new ArrayList<>(matchingWords));
            }
        }
        
        return result;
    }
}

