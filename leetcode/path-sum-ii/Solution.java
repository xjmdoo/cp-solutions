class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(root, 0, targetSum, new ArrayList<Integer>(), res);
        return res;
    }

    public void dfs(TreeNode node, int sum, int target, ArrayList<Integer> currentNodeVals, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        sum += node.val;
        ArrayList<Integer> next = new ArrayList<>(currentNodeVals);
        next.add(node.val);
        if (node.left == null && node.right == null && sum == target) {
            res.add(next);
            return;
        }
        dfs(node.left, sum, target, next, res);
        dfs(node.right, sum, target, next, res);
    }
}