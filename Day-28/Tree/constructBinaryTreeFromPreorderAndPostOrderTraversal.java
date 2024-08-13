import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postorderIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postorderIndexMap.put(postorder[i], i);
        }
        return constructTree(preorder, postorder, postorderIndexMap, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int[] postorder, Map<Integer, Integer> postorderIndexMap,
                                   int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int leftRootVal = preorder[preStart + 1];
        int leftSubtreeIndexInPostorder = postorderIndexMap.get(leftRootVal);

        int leftSubtreeSize = leftSubtreeIndexInPostorder - postStart + 1;

        root.left = constructTree(preorder, postorder, postorderIndexMap,
                                  preStart + 1, preStart + leftSubtreeSize,
                                  postStart, leftSubtreeIndexInPostorder);

        root.right = constructTree(preorder, postorder, postorderIndexMap,
                                   preStart + leftSubtreeSize + 1, preEnd,
                                   leftSubtreeIndexInPostorder + 1, postEnd - 1);

        return root;
    }
}
