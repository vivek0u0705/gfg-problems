/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public static boolean isL(Node root){
        return root.left==null && root.right==null; 
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(!isL(root)) ans.add(root.data);
        lb(root,ans);
        ln(root,ans);
        rb(root,ans);
    return ans;
    }
    public static void lb(Node root,ArrayList<Integer> ans){
        Node cur=root.left;
        while(cur!=null){
            if(!isL(cur)) ans.add(cur.data);
            if(cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }
    public static void ln(Node root,ArrayList<Integer> ans){
       if(isL(root)){ 
            ans.add(root.data);
            return;
        }
        if(root.left!=null) ln(root.left,ans);
        if(root.right!=null) ln(root.right,ans);
        
    }
    public static void rb(Node root,ArrayList<Integer> temp){
         Node cur=root.right;
        ArrayList<Integer> ans= new ArrayList<>();
        while(cur!=null){
            if(!isL(cur)) ans.add(cur.data);
            if(cur.right!=null) cur=cur.right;
            else cur=cur.left;
        }
        for(int i=ans.size()-1;i>=0;i--){
            temp.add(ans.get(i));
        }
    }
}