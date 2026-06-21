class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
    return f(0,adj,baseTime);
    }
    public long f(int node,List<List<Integer>> adj,int[] arr){

        if(adj.get(node).size()==0) return arr[node]; //base case
        long mn=(long)1e10;
        long mx=0;
        for(int adjN : adj.get(node)){
            long ans=f(adjN,adj,arr);
            mx=Math.max(mx,ans);   //found max  and min node to leafs
            mn=Math.min(mn,ans);
        }
    return mx+mx-mn+arr[node];
    }
}