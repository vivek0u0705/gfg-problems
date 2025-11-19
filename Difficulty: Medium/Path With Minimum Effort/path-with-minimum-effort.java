class Pair{
    int d;
    int r;
    int c;
    Pair(int dist,int row,int col){
        d=dist;
        r=row;
        c=col;
    }
}
class Solution {
    public int minCostPath(int[][] mat) {
        // code here
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.d,b.d));
        int n=mat.length;
        int m=mat[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],(int)1e9);
        }
        dist[0][0]=0;
        pq.add(new Pair(0,0,0));
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        while(!pq.isEmpty()){
            Pair rem=pq.poll();
            int di=rem.d;
            int row=rem.r;
            int col=rem.c;
            if(row==n-1 && col==m-1) return di;
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int Gd=Math.max(di,Math.abs(mat[row][col]-mat[nr][nc]));
                    if(Gd<dist[nr][nc]){
                        dist[nr][nc]=Gd;
                        pq.add(new Pair(Gd,nr,nc));
                    }
                }
            }
        }
    return -1;
    }
}
