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
        long[] dist=new long[n];
        int[] ways=new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.wt,b.wt));
        pq.add(new Pair(0,0)); // v,wt

        while(!pq.isEmpty()){
            int node=pq.peek().nd;
            long wtt=pq.peek().wt;
            pq.poll();

            for(int[] adjN : adj.get(node)){
                int edN=adjN[0];
                int edW=adjN[1];
                if(wtt+edW < dist[edN]){
                    dist[edN]=wtt+edW;
                    pq.add(new Pair(edN,dist[edN]));
                    ways[edN]=ways[node];
                }
                else if(wtt+edW == dist[edN]){
                    ways[edN] = (ways[edN] + ways[node]) % mod;
                }
            }
        }
    return ways[n-1] % mod;
    }
}




// Remember: Dijkstra gives the shortest distance, ways[] counts how many shortest paths achieve that distance.


// Run Dijkstra to find the shortest distance to every node.
// ways[i] = number of shortest paths reaching node i.
// If a shorter path is found: update dist and set ways[neighbor] = ways[node].
// If an equal shortest path is found: ways[neighbor] += ways[node] (mod 1e9+7).