import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map to store the nodes based on their column index
        TreeMap<Integer, List<int[]>> columnTable = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        
        // Start with the root node at row 0 and column 0
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            // Add the node value to the map under its corresponding column
            columnTable.putIfAbsent(col, new ArrayList<>());
            columnTable.get(col).add(new int[] {row, node.val});

            // Add the left and right children to the queue
            if (node.left != null) {
                queue.offer(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        // Prepare the final output
        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> entries : columnTable.values()) {
            // Sort by row first, and then by value
            Collections.sort(entries, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            List<Integer> sortedColumn = new ArrayList<>();
            for (int[] entry : entries) {
                sortedColumn.add(entry[1]);
            }
            result.add(sortedColumn);
        }

        return result;
    }
}

// Helper class to store the node along with its row and column information
class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
