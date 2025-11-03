class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] e) {
        // Code here\
        List<List<Integer>> ad=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            ad.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e.length;i++){
            int u=e[i][0];
            int v=e[i][1];
            ad.get(u).add(v);
        }
        int ind[]=new int[V];
        for(int i=0;i<V;i++){
            for(int it:ad.get(i)){
                adj.get(it).add(i);
                ind[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<Integer>();
        for(int i=0;i<V;i++){
            if(ind[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int r=q.peek();
            q.poll();
            ans.add(r);
            for(int it:adj.get(r)){
                ind[it]--;
                if(ind[it]==0) q.add(it);
            }
        }
        Collections.sort(ans);
    return ans;
    }
}