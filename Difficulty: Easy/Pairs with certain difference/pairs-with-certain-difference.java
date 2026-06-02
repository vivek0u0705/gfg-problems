class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,arr,k,dp);
    }
    static int f(int i,int[] arr,int k,int[] dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int nt=0+f(i-1,arr,k,dp);
        int t=0;
        if(i>0 && (arr[i]-arr[i-1]<k)){
            t=arr[i]+arr[i-1]+f(i-2,arr,k,dp);
        }
    return dp[i]=Math.max(t,nt);
    }
}