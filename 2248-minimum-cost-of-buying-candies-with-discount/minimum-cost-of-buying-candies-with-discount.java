class Solution {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int n=cost.length;
        for(int i=0;i<n;i++){
            pq.add(cost[i]);
        }
        int ts=0;
        while(pq.size()>=2){
            int f=pq.poll();
            int s=pq.poll();
            ts+=f+s;
            if(!pq.isEmpty()) pq.poll();//free
        }
        while(!pq.isEmpty() && pq.size()<2) ts+=pq.poll();
    return ts;
    }
}