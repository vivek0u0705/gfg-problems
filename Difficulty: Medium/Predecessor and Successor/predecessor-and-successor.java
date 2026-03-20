/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int k) {
        ArrayList<Node> ln=new ArrayList<>();
        ln.add(null);
        ln.add(null);
        pf(root,k,ln);
        sf(root,k,ln);
    return ln;
    }
    public static void pf(Node root, int k,ArrayList<Node> ln){
        if(root==null) return;
        if(root.data<k){
            ln.set(0,root);
            pf(root.right,k,ln);
        }
        else{
            pf(root.left,k,ln);
        }
    }
    public static void sf(Node root, int k,ArrayList<Node> ln){
        if(root==null) return;
        if(root.data>k){
            ln.set(1,root);
            sf(root.left,k,ln);
        }
        else{
            sf(root.right,k,ln);
        }
    }
}