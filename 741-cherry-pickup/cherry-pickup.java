class Solution {
    int[] dr={0,1};
    int[] dc={1,0};//right,down
    Integer[][][][] dp;
    public int cherryPickup(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        dp=new Integer[n][n][n][n];
        int sum=f(0,0,0,0,mat);
    return Math.max(sum,0);
    }
    public int f(int r1,int c1,int r2,int c2,int[][] mat){
        int n=mat.length;
        // invalid states
        if(r1>=n || r2>=n || c1>=n || c2>=n || mat[r1][c1]==-1 || mat[r2][c2]==-1) {
            return -(int)1e9;
        }
        //base case only reaches to botton right corner
        if(r1==n-1 && c1==n-1){ // here r1=r2 and c1=c2  always beacuse r1+c1=r2+c2
            return mat[r1][c1];
        }
        if(dp[r1][c1][r2][c2]!=null) return dp[r1][c1][r2][c2];
        
        int ans=-(int)1e9;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                int nr1=r1+dr[i];
                int nc1=c1+dc[i];
                int nr2=r2+dr[j];
                int nc2=c2+dc[j];
                int val=0;
                if(r1==r2 && c1==c2) val+=mat[r1][c1];
                else val+=mat[r1][c1]+mat[r2][c2];
                ans=Math.max(ans,val+f(nr1,nc1,nr2,nc2,mat));
            }
        }
    return dp[r1][c1][r2][c2]=ans;

    }
}
//we can also reduce dimention to 3d state (r1,c1,r2) or (r1,c1,c2)
//beacuse (r1+c1)==(r2+c2) for k-steps equal 
// c2=r1+c1-r2;
