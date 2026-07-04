class Solution {
    int min;
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        int len=roads.length;
        for(int i=0;i<len;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int wt=roads[i][2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        int[] vis=new int[n+1];
        min=(int)1e9;
        dfs(1,vis,adj);
    return min;
    }
    public void dfs(int node,int vis[],List<List<int[]>> adj){
        vis[node]=1;
        for(int[] arr : adj.get(node)){
            int adjN=arr[0];
            int wt=arr[1];
            min=Math.min(min,wt);
            if(vis[adjN]!=1){
                dfs(adjN,vis,adj);
            }
        }
    }
}