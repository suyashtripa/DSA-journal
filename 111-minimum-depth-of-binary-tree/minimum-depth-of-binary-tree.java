class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // If leaf found → return current depth
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            depth++;  // ✅ increase after finishing one level
        }

        return depth;
    }
}
