class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int k,int v){
            key=k;
            value=v;
            next=null;
            prev=null;
        }
    }
    //creating dummy nodes
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> hm=new HashMap<>();
    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int k) {
        if(!hm.containsKey(k)) return -1;
        Node node=hm.get(k);
        deleteNode(node);
        addNode(node);
    return node.value;
    }
    
    public void put(int key, int val){
        if(hm.containsKey(key)){
            Node node=hm.get(key);
            node.value=val;
            deleteNode(node);
            addNode(node);
        }
        else{
            if(hm.size()==cap){
                Node node=tail.prev;
                deleteNode(node);
                hm.remove(node.key);
            }
            Node newN=new Node(key,val);
            addNode(newN);
            hm.put(key,newN);
        }
    }
    public void addNode(Node node){
        Node nextN=head.next;
        node.next=nextN;
        nextN.prev=node;
        head.next=node;
        node.prev=head;
    }
    public void deleteNode(Node node){
        Node nextN=node.next;
        Node prevN=node.prev;
        prevN.next=nextN;
        nextN.prev=prevN;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */