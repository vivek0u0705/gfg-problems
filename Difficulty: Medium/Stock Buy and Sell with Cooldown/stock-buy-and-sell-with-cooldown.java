class Solution {
    static int p=0;
    public int maxProfit(int arr[]) {
        // Code here
        int n=arr.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,arr,1,dp);
    }
    public static int f(int i,int[] arr,int buy,int dp[][]){
        if(i>=arr.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            p=Math.max(-arr[i]+f(i+1,arr,0,dp),0+f(i+1,arr,1,dp));
        }
        else{
            p=Math.max(arr[i]+f(i+2,arr,1,dp),0+f(i+1,arr,0,dp));
        }
    return dp[i][buy]=p;
    }
}
