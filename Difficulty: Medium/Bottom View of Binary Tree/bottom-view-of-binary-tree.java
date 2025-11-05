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
class Pair{
    int pt;
    Node val;
    Pair(int pt,Node val){
        this.pt=pt;
        this.val=val;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Queue<Pair> q=new LinkedList<>();
        Map<Integer,Integer> hm=new TreeMap<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair nd=q.remove();
            int p=nd.pt;
            Node node=nd.val;
            hm.put(p,node.data);
            if(node.left!=null){
                q.add(new Pair(p-1,node.left));
            }
            if(node.right!=null){
                q.add(new Pair(p+1,node.right));
            }
        }
        ArrayList<Integer> ar=new ArrayList<>();
        for(Integer k:hm.keySet()){
            ar.add(hm.get(k));
        }
    return ar;
    }
}