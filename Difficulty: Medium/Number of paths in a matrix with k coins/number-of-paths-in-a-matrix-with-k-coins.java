class Solution {
    public int numberOfPath(int[][] mat, int k) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int[][][] dp=new int[n][m][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              Arrays.fill(dp[i][j],-1);   
            }
        }
        return f(0,0,mat,k,dp);
    }
    public static int f(int i,int j,int [][]m,int k,int[][][] dp){
        if(i>=m.length || j>=m[0].length){
            return 0;
        }
        if(i==m.length-1 && j==m[0].length-1){
            if(k==m[i][j]) return 1;
            else return 0;
        }
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        int r=k-m[i][j];
        int rt=0;
        int ct=0;
        if(r>=0){
            rt=f(i,j+1,m,r,dp);
            ct=f(i+1,j,m,r,dp);
        }
        
        return dp[i][j][k]=rt+ct;
    }
}