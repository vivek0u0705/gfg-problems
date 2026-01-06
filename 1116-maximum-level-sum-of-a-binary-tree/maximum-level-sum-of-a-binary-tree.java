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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int m=-(int)1e9;
        int idx=1;
        int mi=-1;
        while(!q.isEmpty()){
            int cs=0;
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode t=q.poll();
                cs+=t.val;
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            if(cs>m){
                m=cs;
                mi=idx;
            }
            idx++;
        }
    return mi;
    }
}