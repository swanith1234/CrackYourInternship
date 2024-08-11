import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftPath(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode currentNode = stack.pop();
        int value = currentNode.val;
        if (currentNode.right != null) {
            pushLeftPath(currentNode.right);
        }
        return value;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper method to push all the leftmost nodes starting from the given node onto the stack
    private void pushLeftPath(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
