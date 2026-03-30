

class Solution {

    public int minCost(int[][] pts) {
        // code here
        int n=pts.length;
        //     pq   ->  (wt,node)
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int vis[]=new int[n];
        pq.add(new int[]{0,0});
        int mst=0;
        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            int wt=arr[0];
            int u=arr[1];
            if(vis[u]==1) continue;
            mst+=wt;
            vis[u]=1;
            for(int v=0;v<n;v++){
                int d=Math.abs(pts[u][0]-pts[v][0])+Math.abs(pts[u][1]-pts[v][1]);
                pq.add(new int[]{d,v});
            }
        }
    return mst;
    }
}
