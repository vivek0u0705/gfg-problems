class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj=new ArrayList<>();
        int n=V;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] deg=new int[n];
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            deg[u]++;
            deg[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(deg[i]==1) q.add(i);
        }
        int rem=n;
        while(rem>2){
            int sz=q.size();
            rem=rem-sz;
            for(int i=0;i<sz;i++){
                int nd=q.poll();
                for(int adjN : adj.get(nd)){
                    deg[adjN]--;
                    if(deg[adjN]==1) q.add(adjN);
                }
            }
        }
        ArrayList<Integer> li=new ArrayList<>();
        while(!q.isEmpty()){
            li.add(q.poll());
        }
    return li;
    }
}