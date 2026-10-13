
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int x) { this.val = x; }
 *     TreeNode(int x, TreeNode left, TreeNode right) {
 *         this.val = x;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Process the node
            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }

            // Move to the right subtree
            curr = curr.right;
        }

        return -1;
    }
}
