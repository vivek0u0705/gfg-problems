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
    int ans;
    public int averageOfSubtree(TreeNode root) {
        ans=0;
        f(root);
    return ans;
    }
    public void f(TreeNode root){
        if(root==null) return;
        f(root.left);
        f(root.right);
        int sum=fs(root);
        int count=fc(root);
        if(sum/count==root.val) ans++;
    }
    public int fc(TreeNode root){
        if(root==null) return 0;
        int lc=fc(root.left);
        int rc=fc(root.right);
    return lc+rc+1;
    }
    public int fs(TreeNode root){
        if(root==null) return 0;
        int lc=fs(root.left);
        int rc=fs(root.right);
    return lc+rc+root.val;
    }
}