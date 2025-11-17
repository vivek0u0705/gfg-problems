class Solution {
    public int maxSumIS(int arr[]) {
        // code here
        int n=arr.length;
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,-1,arr,dp);
    }
    public static int f(int i,int p,int[] a,int[][] dp){
        if(i==a.length) return 0;
        if(dp[i][p+1]!=-1) return dp[i][p+1];
        int nt=0+f(i+1,p,a,dp);
        int t=0;
        if(p==-1 || a[p]<a[i]){
            t=a[i]+f(i+1,i,a,dp);
        }
    return dp[i][p+1]=Math.max(t,nt);
    }
}