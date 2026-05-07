/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSubTree(Node r1, Node r2) {
        // code here
         if (r2 == null) return true;
        // if (r1 == null) return false;
        return check(r1,r2);
    }
    public static boolean check(Node r1,Node r2){
        if(r1==null) return false;
        if(r1.data==r2.data && same(r1,r2)){
             return true;
            // else return false;
        }
        return check(r1.left,r2) || check(r1.right,r2);
    }
    public static boolean same(Node r1,Node r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null) return false;
        return r1.data==r2.data && same(r1.left,r2.left) && same(r1.right,r2.right);
    }
}