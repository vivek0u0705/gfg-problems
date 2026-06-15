class Pair{
    int nd;
    int wt;
    Pair(int n,int w){
        nd=n;
        wt=w;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
    
            adj.get(u).add(new int[]{v,w}); 
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));
        pq.add(new Pair(k,0));
 
        while(!pq.isEmpty()){
            int node=pq.peek().nd;
            int wtt=pq.peek().wt;
            pq.poll();
            for(int[] adjN : adj.get(node)){  
                int edjN=adjN[0];
                int edjW=adjN[1];
                if(edjW+wtt<dist[edjN]){
                    dist[edjN]=edjW+wtt;
                    pq.add(new Pair(edjN,dist[edjN])); 
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            max=Math.max(max,dist[i]);
        }
    return max==(int)1e9?-1:max;
    }
}