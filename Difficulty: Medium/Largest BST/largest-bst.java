// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }
class Way{
    int sz;
    int min;
    int max;
    Way(int s,int mi,int ma){
        sz=s;
        min=mi;
        max=ma;
    }
    
}
class Solution {

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        return f(root).sz;
    }
    public static Way f(Node root){
        if(root==null){
            return new Way(0,(int)1e9,-(int)1e9);
        }
        Way left=f(root.left);
        Way right=f(root.right);
        if(left.max<root.data && root.data<right.min){
            return new Way(left.sz+right.sz+1,Math.min(root.data,left.min),Math.max(root.data,right.max));
        }
        
        return new Way(Math.max(left.sz,right.sz),-(int)1e9,(int)1e9);
    } 
}