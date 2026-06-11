class Solution {
    static int dp;
    static int mod=1000000007;
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1; // 0 to n nodes;
        int[] vis=new int[n+1]; // to check n node we need len n+1
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++) {   //create for 0 to n   in that  we need from 1 to n 
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dp=0;
        dfs(1,adj,vis,0);

        // from 1 to max depth level    _ _ _ up to d  in each we can kepp 0/1  
        // so there are 2^d choices for this we can for odd sum 
        // even + odd =2^d
        //odd=2^(d-1)
        // if(dp==1) return 1;
        int ans=1;
        for(int i=0;i<dp-1;i++){   //we check 0 to d-2   then 2^d-1
            ans= (ans*2) % mod;
        }
    return ans; 
    }
    static void dfs(int nd,List<List<Integer>> adj,int[] vis,int len){
        vis[nd]=1;
        dp=Math.max(dp,len);
        for(int adjN :adj.get(nd)){
            if(vis[adjN]==0){
                dfs(adjN,adj,vis,len+1);
            }
        }
    }
}