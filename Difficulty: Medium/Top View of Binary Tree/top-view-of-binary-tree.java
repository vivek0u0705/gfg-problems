/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Pair{
    Node node;
    int dim;
    Pair(Node n,int d){
        node=n;
        dim=d;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair rem=q.poll();
            int d=rem.dim;
            Node nd=rem.node;
            if(!tm.containsKey(d)) tm.put(d,nd.data);
            if(nd.left!=null)q.add(new Pair(nd.left,d-1));
            if(nd.right!=null)q.add(new Pair(nd.right,d+1));
        }
        ArrayList<Integer> li=new ArrayList<>();
        for(int k:tm.keySet()){
            li.add(tm.get(k));
        }
    return li;
    }
}