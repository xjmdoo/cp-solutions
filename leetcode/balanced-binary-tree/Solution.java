class Solution {
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root, 0);
        return balanced;
    }

    public int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);
        if (Math.abs(left - right) > 1) balanced = false;
        return Math.max(left, right);
    }
}