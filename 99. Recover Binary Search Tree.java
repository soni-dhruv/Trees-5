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

//TC: O(n)
//SC: O(h)

class Solution {
    TreeNode prev, first, second;
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        
        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
                second = root;
            }
            else{
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}