class Solution {
    public long rob(int[] nums, int[] col) {
        int n=nums.length;
        long[] dp=new long[n];
        Arrays.fill(dp,-1);
        return f(0,nums,col,dp);
    }
    public static long f(int i,int[] arr1,int arr2[],long[] dp){
        int n=arr1.length;
        if(i>=n) return 0;
        long t=0;
        if(dp[i]!=-1) return dp[i];
        long nt=f(i+1,arr1,arr2,dp);
        if(i+1<n && arr2[i]==arr2[i+1]){
            t=arr1[i]+f(i+2,arr1,arr2,dp);
        }
        else{
            t=arr1[i]+f(i+1,arr1,arr2,dp);
        }
    return dp[i]=Math.max(nt,t);
    }
}