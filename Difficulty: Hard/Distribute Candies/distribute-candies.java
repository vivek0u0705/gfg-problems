/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static int ans=0;
    public int distCandy(Node root) {
        ans=0;
        // code here
        f(root);
        return ans;
    }
    public static int f(Node root){
        if(root==null) return 0;
        int lc=f(root.left);
        int rc=f(root.right);
        ans+=Math.abs(lc)+Math.abs(rc);
    return root.data+lc+rc-1;
    }
}