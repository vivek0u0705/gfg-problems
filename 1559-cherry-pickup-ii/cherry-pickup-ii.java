class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(grid,0,0,m-1,dp);
    }
    public static int f(int[][] grid,int i,int j1,int j2,int[][][] dp){
        int r=grid.length;
        int c=grid[0].length;
        //out of bounds cases for colms
        if(j1<0 ||j1>=c || j2<0 || j2>=c){
            return -(int)1e9;
        }
        //base case
        if(i==r-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        //explore all cases
        int max=0;
        for(int d1=-1;d1<=+1;d1++){
            for(int d2=-1;d2<=+1;d2++){
                int val=0;
                if(j1==j2) val=grid[i][j1];
                else val=grid[i][j1]+grid[i][j2];
                val+=f(grid,i+1,j1+d1,j2+d2,dp);
                max=Math.max(max,val);
            }
        }
    return dp[i][j1][j2]=max;
    }
}