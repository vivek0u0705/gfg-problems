class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] p) {
        // code here
        ArrayList<Integer> li=new ArrayList<>();
        int[] ind=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            adj.get(p[i][1]).add(p[i][0]);
        }
        for(int i=0;i<n;i++){
            for(int it : adj.get(i)){
                ind[it]++;
            }
        }
        for(int i=0;i<n;i++){
            if(ind[i]==0) q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            int rem=q.peek();
            q.poll();
            li.add(rem);
            c++;
            for(int adjN:adj.get(rem)){
                ind[adjN]--;
                if(ind[adjN]==0)q.add(adjN);
            }
        }
       return li;
    }
}