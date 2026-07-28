class Solution {
    int timer=1;
    int[] dt;
    int[] low;
    List<List<Integer>> adj;
    List<List<Integer>> res;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> edges) {
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int par=-1;
        int vis[]=new int[n];
        dt=new int[n];
        low=new int[n];
        res=new ArrayList<>();
        dfs(0,par,vis);
    return res;
    }
    public void dfs(int u,int par,int[] vis){
        vis[u]=1;
        dt[u]=low[u]=timer++;
        for(int v : adj.get(u)){
            if(vis[v]==0){
                dfs(v,u,vis);
                low[u]=Math.min(low[u],low[v]);
                if(low[v]>dt[u]) {
                    res.add(Arrays.asList(u,v));
                }
            }
            else if(v!=par){
                low[u]=Math.min(low[u],dt[v]);
            }
        }
    }
}



//tarjans algorithm   uses dt,low  to track bridge
//if vis adj not parent then make low[u] min of all its adjcents low
//if not vis make dfs and make low[u] min 
//low[v] > dt[u] → Child cannot reach the parent or any ancestor except through this edge