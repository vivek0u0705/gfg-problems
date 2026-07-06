class Pair{
    int row;
    int col;
    Pair(int r,int c){
        row=r;
        col=c;
    }
}
class Solution {
    static int[] dr={0,-1,0,1};
    static int[] dc={-1,0,1,0};
    public int orangesRotting(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();

        int vis[][]=new int[n][m];
        int fr=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    // vis[i][j]=1;
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    fr++;
                }
            }
        }
        int steps=0;
        while(!q.isEmpty()){
            int len=q.size();
            boolean atLeastOne=false;
            for(int i=0;i<len;i++){
                 Pair rem=q.poll();
                 int r=rem.row;
                 int c=rem.col;
                 for(int j=0;j<4;j++){
                    int nr=r+dr[j];
                    int nc=c+dc[j];
                    if(nr>=0 && nc>=0 && nr<n && nc<m  && grid[nr][nc]==1 && vis[nr][nc]==0){
                        vis[nr][nc]=1;
                        grid[nr][nc]=2;
                        q.add(new Pair(nr,nc));
                        atLeastOne=true;
                        fr--;
                    }
                 }
            }
           if(atLeastOne) steps++;
        }
        if(fr==0) return steps;
        return -1;
    }
}