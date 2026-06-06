class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return f(0,arr,k,dp);
    }
    static int f(int i,int[] arr,int k,int dp[]){
        int n=arr.length;
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int max=0;
        int ans=0;
        for(int j=i;(j<n && j<i+k);){
            max=Math.max(max,arr[j]);
            int cost=(j-i+1)*max + f(j+1,arr,k,dp);
            ans=Math.max(ans,cost);
            j++;
        }
    return dp[i]=ans;
    }
}