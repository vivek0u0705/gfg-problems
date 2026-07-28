class Pair{
    int nd;
    int wt;
    Pair(int v,int w){
        nd=v;
        wt=w;
    }
}
class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // code here
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        int[] dist=new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair rem=pq.poll();
            int u=rem.nd;
            int uwt=rem.wt;
            for(int[] adjN:adj.get(u)){
                int v=adjN[0];
                int vwt=adjN[1];
                if(dist[u]+vwt<dist[v]){
                    dist[v]=dist[u]+vwt;
                    pq.add(new Pair(v,dist[u]+vwt));
                }
            }
        }
    return dist[dest]==(int)1e9?-1:dist[dest];
    }
}