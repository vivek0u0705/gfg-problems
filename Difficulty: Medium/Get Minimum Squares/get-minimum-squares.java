class Solution {
   
    public int minSquares(int n) {
        // Code here
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return f(n,dp);
    }
    public static int f(int n,int dp[]){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int t=bs(n);
        int m=Integer.MAX_VALUE;
        for(int j=t;j>=1;j--){
           if(j*j<=n){
            m=Math.min(1+f(n-j*j,dp),m);
           } 
        }
    return dp[n]=m;
    }
    public static int bs(int n){
       int i=1;
       int j=n;
       int ans=0;
       while(i<=j){
           int m=(i+j)/2;
           if(m*m==n){
                return m;
           }
           if(m*m>n){
               j=m-1;
           }
           else{
               ans=m;
               i=m+1;
           }
       }
      return ans;
    }
}