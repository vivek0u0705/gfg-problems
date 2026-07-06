class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0) if(dfs(i,-1,vis,adj)==true) return true;
        }
    return false;
    }
    public boolean dfs(int node,int parent,int[] vis,List<List<Integer>> adj){
        vis[node]=1;
        for(int adjN:adj.get(node)){
            if(vis[adjN]==0){
               if(dfs(adjN,node,vis,adj)==true) return true;
            }
            else if(adjN!=parent) return true;
        }
    return false;
    }
}