class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(pq.size()>=k){
                    int t=pq.poll();
                    int tp=Math.min(mat[i][j],t);
                    pq.add(tp);
                }
                else pq.add(mat[i][j]);
            }
        }
    return pq.poll();
    }
}
