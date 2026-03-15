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
    Node node;
    int dim;
    Pair(Node n,int d){
        node=n;
        dim=d;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        TreeMap<Integer,ArrayList<Integer>> tm=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair r=q.poll();
            Node nd=r.node;
            int d=r.dim;
            if(!tm.containsKey(d)){
              tm.put(d,new ArrayList<>());
              tm.get(d).add(nd.data);
            } 
            else{
                tm.get(d).add(nd.data);
            }
            if(nd.left!=null) q.add(new Pair(nd.left,d-1));
            if(nd.right!=null) q.add(new Pair(nd.right,d+1));
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int li:tm.keySet()){
            ans.add(tm.get(li));
        }
    return ans;
    }
}