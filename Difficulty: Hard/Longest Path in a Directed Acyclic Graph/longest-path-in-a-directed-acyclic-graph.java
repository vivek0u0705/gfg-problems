class Solution {
    public int[] maxDistance(int n, int src, ArrayList<ArrayList<Integer>> edges) {
        // code here
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MIN_VALUE);
        dist[src]=0;
        Queue<Integer> q=new LinkedList<>();
        int[] ind=new int[n];
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.size();i++){
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);
            int wt=edges.get(i).get(2);
            adj.get(u).add(new int[]{v,wt});
            ind[v]++;
        }
        for(int i=0;i<n;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int u=q.poll();
            for(int[] adjN : adj.get(u)){
                int v=adjN[0];
                int wt=adjN[1];
                if(dist[u]!=Integer.MIN_VALUE){
                    dist[v]=Math.max(dist[v],dist[u]+wt);
                }
                ind[v]--;
                if(ind[v]==0){
                    q.add(v);
                }
            }
        }
    return dist;
    }
}
