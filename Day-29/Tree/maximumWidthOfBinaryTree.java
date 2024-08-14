import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().getValue();
            int first = 0, last = 0;
            
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> current = queue.poll();
                TreeNode node = current.getKey();
                int index = current.getValue() - minIndex; // Normalize index to prevent overflow
                
                if (i == 0) first = index;
                if (i == size - 1) last = index;
                
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * index + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * index + 2));
                }
            }
            
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        
        return maxWidth;
    }
}

// Helper class to store the TreeNode and its index
class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
    
    public void setKey(K key) {
        this.key = key;
    }
    
    public void setValue(V value) {
        this.value = value;
    }
}
