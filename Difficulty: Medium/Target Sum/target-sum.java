class Solution {
    static int sum=0;
    public int totalWays(int[] arr, int tar) {
        // code here
        int n=arr.length;
        sum=0;
        for(int X:arr) sum+=X;
        int[][] dp=new int[n][2*sum+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return f(arr,tar,0,0,dp);
    }
    public static int f(int[] arr,int tar,int i,int cur,int[][] dp){
        if(i==arr.length){
            if(cur==tar) return 1;
            else return 0;
        }
        if(dp[i][cur+sum]!=-1) return dp[i][cur+sum];
        int tp=f(arr,tar,i+1,cur+arr[i],dp);
         int tn=f(arr,tar,i+1,cur-arr[i],dp);
        return dp[i][cur+sum]=tp+tn;
    }
}