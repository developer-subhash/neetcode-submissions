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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // use queue simple or dfs and record level

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;

        Deque<TreeNode> q = new LinkedList<>();

        q.addLast(root);
        q.addLast(null); // for level

        List<Integer> curr = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode node = q.pollFirst();
            if(node == null){
                if(!q.isEmpty()){
                    q.addLast(null);
                }
                ans.add(curr);
                curr = new ArrayList<>();
                continue;
            }

            curr.add(node.val);
            if(node.left != null){
                q.addLast(node.left);
            }

            if(node.right != null){
                q.addLast(node.right);
            }
        }

        return ans;
    }
}