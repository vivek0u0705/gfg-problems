class Node{
    Node left;
    Node right;
    int data;
    Node(int val){
        data=val;
        this.left=null;
        this.right=null;
    }
}
class Solution {
    public boolean isMaxHeap(int[] arr) {
        // code here
        Node root=build(arr);
    return f(root);
    }
    public static boolean f(Node root){
        if(root==null) return true;
        if(root.left!=null &&  root.data<root.left.data) return false;
        if(root.right!=null && root.data<root.right.data) return false;
    return f(root.left) && f(root.right);
    }
    public static Node build(int[] arr){
        Node root=new Node(arr[0]);
        Queue<Node> q=new LinkedList<>();
        int n=arr.length;
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<n){
            Node rem=q.poll();
            if(i<n){
                rem.left=new Node(arr[i]);
                q.add(rem.left);
                i++;
            }
             if(i<n){
                rem.right=new Node(arr[i]);
                q.add(rem.right);
                i++;
            }
        }
    return root;
    }
}