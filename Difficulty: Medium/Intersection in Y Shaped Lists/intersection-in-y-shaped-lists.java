/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node h1, Node h2) {
        // code here
        Node t1=h1;
        Node t2=h2;
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
            if(t1==null)t1=h2;
            if(t2==null)t2=h1;
        }
    return t1;
        
    }
}