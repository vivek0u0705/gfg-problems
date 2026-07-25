class Pair{
    int r;
    int c;
    int eff;
    Pair(int ro,int co,int ef){
        r=ro;
        c=co;
        eff=ef;
    }
}
class Solution {
    public int minimumEffortPath(int[][] mat) {
        int[] dr={0,-1,0,1};
        int[] dc={-1,0,1,0};
        int n=mat.length;
        int m=mat[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],(int)1e9);
        dist[0][0]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.eff,b.eff));
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair rem=pq.poll();
            int r=rem.r;
            int c=rem.c;
            int eff=rem.eff;
            if(r==n-1 && c==m-1) return eff;
            for(int j=0;j<4;j++){
                int nr=r+dr[j];
                int nc=c+dc[j];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int wt=Math.abs(mat[nr][nc]-mat[r][c]);
                    int eft=Math.max(eff,wt);
                    if(eft<dist[nr][nc]){
                        dist[nr][nc]=eft;
                        pq.add(new Pair(nr,nc,eft));
                    }
                }
                
            }
        }
    return dist[n-1][m-1];
    }
}