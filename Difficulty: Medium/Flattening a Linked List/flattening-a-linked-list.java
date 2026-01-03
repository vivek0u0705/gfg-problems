/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        // code here
        List<Integer> li=new ArrayList<>();
        Node t=root;
        while(t!=null){
            Node t1=t;
            while(t1!=null){
                li.add(t1.data);
                t1=t1.bottom;
            }
            t=t.next;
        }
        Node d=new Node(0);
        Node cur=d;
        Collections.sort(li);
        for(int i :li){
            int val=i;
            Node v=new Node(val);
            cur.bottom=v;
            cur=cur.bottom;
        }
    return d.bottom;
    }
}