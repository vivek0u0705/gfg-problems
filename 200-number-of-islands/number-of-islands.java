
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int c=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    c++;
                    dfs(row,col,grid,vis);
                }
            }
        }
    return c;
    }
    public void dfs(int r,int c,char[][] grid,int[][] vis){
        int n=grid.length;
        int m=grid[0].length;
        vis[r][c]=1;
            int[] dr={-1,0,0,1};
            int[] dc={0,-1,1,0};
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1' && vis[nr][nc]==0){
                    dfs(nr,nc,grid,vis);
                }
            }

    }
}