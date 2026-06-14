class Pair{
    int row;
    int col;
    int dt;
    Pair(int r,int c,int d){
        row=r;
        col=c;
        dt=d;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int st=q.peek().dt;
            q.poll();
            dist[r][c]=st;
            int[] dr={-1,0,1,0};
            int[] dc={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n && vis[nr][nc]==0 && mat[nr][nc]==1){
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc,st+1));
                }
            }
        }
    return dist;
    }
}