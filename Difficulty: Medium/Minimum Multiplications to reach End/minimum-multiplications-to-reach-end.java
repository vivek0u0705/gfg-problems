class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // code here
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{start,0});
        int[] dist=new int[1000+1];
        Arrays.fill(dist,(int)1e9);
        dist[start]=0;
        while(!q.isEmpty()){
            int[] r=q.poll();
            int val=r[0];
            int s1=r[1];
            if(val==end)   return s1;
            for(int t:arr){
                int tt=(val*t)%1000;
                if(dist[val]+1<dist[tt]) {
                    dist[tt]=dist[val]+1;
                    q.add(new int[]{tt,dist[tt]});
                }
            }
        }
    return -1;
    }
}