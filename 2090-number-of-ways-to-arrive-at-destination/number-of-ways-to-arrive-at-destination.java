class Pair{
    int nd;
    long wt;
    Pair(int n,long w){
        nd=n;
        wt=w;
    }
}
class Solution {
    static int mod=(int)(1e9+7);
    public int countPaths(int n, int[][] roads) {
        //dijktras + some logic with ways array
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];
            adj.get(u).add(new int[]{v,w}); 
            adj.get(v).add(new int[]{u,w}); 
        }
        long[] dist=new long[n];
        int[] ways=new int[n];
        Arrays.fill(dist,(long)1e18);
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.wt,b.wt));
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            int u = cur.nd;
            long d = cur.wt;

            for(int[] adjN :adj.get(u)){
                int v=adjN[0];
                int wtt=adjN[1];
                if(d+wtt<dist[v]){
                    dist[v]=d+wtt;
                    pq.add(new Pair(v,dist[v]));
                    ways[v]=ways[u];
                }
                else if(d+wtt==dist[v]){
                    ways[v]=(ways[v]+ways[u])%mod;
                }
            }
        }
    return ways[n-1];
    }
}




// Remember: Dijkstra gives the shortest distance, ways[] counts how many shortest paths achieve that distance.


// Run Dijkstra to find the shortest distance to every node.
// ways[i] = number of shortest paths reaching node i.
// If a shorter path is found: update dist and set ways[neighbor] = ways[node].
// If an equal shortest path is found: ways[neighbor] += ways[node] (mod 1e9+7).