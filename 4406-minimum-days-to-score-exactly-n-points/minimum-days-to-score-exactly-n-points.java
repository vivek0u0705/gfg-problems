class Solution {
    int[][] dp;
    public int minDays(int n) {
        int len=450;
        dp=new int[n][len];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,1,n);
    }
    public int f(int sum,int current,int n){
        if(sum==n) return 0;
        if(sum>n) return (int)1e9;

        if(dp[sum][current]!=-1) return dp[sum][current];

        int t=1+f(sum+current,current+1,n);
        int nt=(int)1e9;
        if(current>1){
            nt=1+f(sum,1,n);
        }
    return dp[sum][current]=Math.min(nt,t);
    }
}