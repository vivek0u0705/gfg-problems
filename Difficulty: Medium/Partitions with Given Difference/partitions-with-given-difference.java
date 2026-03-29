class Solution {
    public int countPartitions(int[] arr, int d) {
        // code here
        int n=arr.length;
        int ts=0;
        for(int x:arr) ts+=x;
        int tar=(ts+d)/2;
        if((ts+d)%2!=0) return 0;
        int[][] dp=new int[n][tar+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
    return f(0,arr,tar,dp);
    }
    public static int f(int i,int[] arr,int tar,int[][] dp){
        if(i==arr.length){
            if(tar==0) return 1;
            else return 0;
        }
        if(dp[i][tar]!=-1) return dp[i][tar];
        int nt=f(i+1,arr,tar,dp);
        int t=0;
        if(arr[i]<=tar){
            t=f(i+1,arr,tar-arr[i],dp);
        }
    return dp[i][tar]=t+nt;
    }
}
