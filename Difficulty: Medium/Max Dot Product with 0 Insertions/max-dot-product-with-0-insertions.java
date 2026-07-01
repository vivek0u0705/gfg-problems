class Solution {
    Integer[][] dp;
    public int maxDotProduct(int[] a, int[] b) {
        // code here
        int n=a.length;
        int m=b.length;
        dp=new Integer[n][m];
    return f(n-1,m-1,a,b);
    }
    public int f(int i,int j,int[] a,int[] b){
        
        if(j<0) return 0;
        if(i<0 || i<j) return -(int)1e9;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        int nt=f(i-1,j,a,b);
        int t=a[i]*b[j]+f(i-1,j-1,a,b);
    return dp[i][j]=Math.max(t,nt);
    }
}