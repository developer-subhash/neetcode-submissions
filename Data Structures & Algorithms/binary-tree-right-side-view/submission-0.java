/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        return levelOrder(root);
    }

    public List<Integer> levelOrder(TreeNode root) {
        // use queue simple or dfs and record level

        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;

        Deque<TreeNode> q = new LinkedList<>();

        q.addLast(root);
        q.addLast(null); // for level

        int last = root.val;
        int curr = 0;

        while(!q.isEmpty()){
            TreeNode node = q.pollFirst();
            if(node == null){
                if(!q.isEmpty()){
                    q.addLast(null);
                }
                ans.add(last);
                last = curr;
                continue;
            }

            if(node.left != null){
                q.addLast(node.left);
                curr = node.left.val;
            }

            if(node.right != null){
                q.addLast(node.right);
                curr = node.right.val;
            }
        }

        return ans;
    }
}