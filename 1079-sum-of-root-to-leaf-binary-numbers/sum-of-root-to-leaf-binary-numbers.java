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
    public int sumRootToLeaf(TreeNode root) {
       return f(root,0);
    }
    public static int f(TreeNode root,int cs){
        if(root==null) return 0;
        cs=cs*2+root.val; 
       if(root.left==null && root.right==null) return cs;
       int ls=f(root.left,cs);
       int rs=f(root.right,cs);
    return ls+rs;
    }
}