class Solution {
    int[] dr={0,-1,0,1};
    int[] dc={-1,0,1,0};
    Integer[][] dp;
    public int longestIncreasingPath(int[][] mat) {
       int ans=0;
       int n=mat.length;
       int m=mat[0].length;
       dp=new Integer[n][m];
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            ans=Math.max(ans,f(mat,i,j));
        }
       }
    return ans;
    }
    
    public int f(int[][] mat,int r,int c){

        if(dp[r][c]!=null) return dp[r][c];

        int ans=1;
        for(int d=0;d<4;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(valid(nr,nc,mat) && mat[r][c]<mat[nr][nc]){
                ans=Math.max(ans,1+f(mat,nr,nc));
            }
        }
    return dp[r][c]=ans;
    }
    public boolean valid(int r,int c,int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
    return r>=0 && c>=0 && r<n && c<m;
    }
}