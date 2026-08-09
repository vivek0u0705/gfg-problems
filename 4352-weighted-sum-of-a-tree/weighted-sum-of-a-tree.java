class Solution {
    int height;
    public long weightedSum(int[] par, int[] nums) {
        int n=par.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            int v=i;
            int u=par[i];
            if(u==-1) continue;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis=new int[n];
        int[] depth=new int[n];
        height=1;
        depth[0]=1;
        dfs(0,depth,vis,adj);
        long res=0;
        for(int i=0;i<n;i++){
            res+=1L*nums[i]*(height-depth[i]+1);
        }
    return res;
    }
    public void dfs(int node,int[] depth,int[] vis,List<List<Integer>> adj){
        vis[node]=1;
        for(int adjN: adj.get(node)){
            if(vis[adjN]==0){
                depth[adjN]=depth[node]+1;
                height=Math.max(height,depth[adjN]);
                dfs(adjN,depth,vis,adj);
            }
        }
    }
}