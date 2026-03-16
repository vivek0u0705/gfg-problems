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
    static int ct=0;
    public int countAllPaths(Node root, int k) {
        ct=0;
        // code here
        List<Integer> li=new ArrayList<>();
        f(root,li,k);
    return ct;
    }
    public static void f(Node root,List<Integer> li, int k){
        if(root==null) return;
        li.add(root.data);
        ck(li,k);
        f(root.left,li,k);
        f(root.right,li,k);
        li.remove(li.size()-1);
    }
    public static void ck(List<Integer> li,int k){
        int n=li.size();
        int s=0;
        for(int i=n-1;i>=0;i--){
            s=s+li.get(i);
            if(s==k) ct++;
        }
    }
}