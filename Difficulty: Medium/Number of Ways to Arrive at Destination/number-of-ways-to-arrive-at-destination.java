class Pair{
    int wt;
    int v;
    Pair(int w,int vv){
        wt=w;
        v=vv;
    }
}
class Solution {
    public int countPaths(int V, int[][] edg) {
        // code here
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edg.length;i++){
            int u=edg[i][0];
            int v=edg[i][1];
            int dd=edg[i][2];
           adj.get(u).add(new Pair(dd,v));
           adj.get(v).add(new Pair(dd,u));
        }
        int[] d=new int[V];
        Arrays.fill(d,(int)1e9);
        d[0]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair r=pq.poll();
            int w=r.wt;
            int node=r.v;
            for(Pair adjN:adj.get(node)){
                if(d[node]+adjN.wt <d[adjN.v]){
                    d[adjN.v]=d[node]+adjN.wt;
                    pq.add(new Pair(d[node]+adjN.wt,adjN.v));
                }
            }
        }
        int rd=d[V-1];
        int c[]=new int[1];
        int wtt=0;
        int vis[]=new int[V];
        dfs(0,adj,vis,c,wtt,rd,V);
    return c[0];
    }
    public static void dfs(int i,List<List<Pair>> adj,int[] vis,int[] c,int wtt,int rd,int V){
        if (wtt > rd) return;
        if(i==V-1){
            if(wtt==rd) c[0]++;
            return;
        }
        vis[i]=1;
        for(Pair adjN:adj.get(i)){
            if(vis[adjN.v]==0){
                dfs(adjN.v,adj,vis,c,wtt+adjN.wt,rd,V);
            }
        }
        vis[i]=0;
    }
}
