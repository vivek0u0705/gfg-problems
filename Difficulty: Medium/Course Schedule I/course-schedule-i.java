class Solution {
    public boolean canFinish(int n, int[][] edg) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int k=edg.length;
        for(int i=0;i<k;i++){
            int u=edg[i][0];
            int v=edg[i][1];
            adj.get(u).add(v);
        }
        int ind[]=new int[n];
        for(int i=0;i<n;i++){
            for(int adjN:adj.get(i)){
                ind[adjN]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        List<Integer> li=new ArrayList<>();
        while(!q.isEmpty()){
            int t=q.poll();
            li.add(t);
            for(int adjN:adj.get(t)){
                ind[adjN]--;
                if(ind[adjN]==0) q.add(adjN);
            }
        }
        if(li.size()==n) return true;
    return false;
    }
}