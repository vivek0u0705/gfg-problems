class Solution {
    // Function to find number of strongly connected components in the graph
    int vis[];
    List<List<Integer>> adj;
    List<List<Integer>> revAdj;
    Stack<Integer> st;
    public int kosaraju(int n, int[][] edges) {
        st=new Stack<>();
        adj=new ArrayList<>();
        revAdj=new ArrayList<>();
        vis=new int[n];
        
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i);
            }
        }
        for(int i=0;i<n;i++) revAdj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            revAdj.get(v).add(u);
        }
        int ct=0;
        Arrays.fill(vis,0);
        while(!st.isEmpty()){
            int nd=st.pop();
            if(vis[nd]==0){
                revDfs(nd);
                ct++;
            }
        }
    return ct;
    }
    public void revDfs(int nd){
        vis[nd]=1;
        for(Integer adjN : revAdj.get(nd)){
            if(vis[adjN]==0){
                revDfs(adjN);
            }
        }
    }
    public void dfs(int nd){
        vis[nd]=1;
        for(Integer adjN : adj.get(nd)){
            if(vis[adjN]==0){
                dfs(adjN);
            }
        }
    st.push(nd);
    }
}