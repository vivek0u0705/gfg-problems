class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][k+1];
        for(int arr[][] :dp){
            for(int ar[] :arr){
              Arrays.fill(ar,-1);
            }
        }
        int val = f(n-1,m-1,grid,k,dp);
    return val<0?-1:val;
    }
    static int f(int i,int j,int[][] grid,int k,int[][][] dp){
        if(i<0 || j<0 || k<0) return -(int)1e9; 
        if(i==0 && j==0){
            if(grid[i][j]==0) return 0;
            if((grid[i][j]==1 || grid[i][j]==2) && k>=1) return grid[i][j];
            return -(int)1e9;
        }
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        int left;
        int up;
        if(grid[i][j]==0){
            left=f(i,j-1,grid,k,dp);
            up=f(i-1,j,grid,k,dp);
        }
        else{
            left=grid[i][j]+f(i,j-1,grid,k-1,dp);
            up=grid[i][j]+f(i-1,j,grid,k-1,dp);
        }
    return dp[i][j][k]=Math.max(left,up);
    }
}