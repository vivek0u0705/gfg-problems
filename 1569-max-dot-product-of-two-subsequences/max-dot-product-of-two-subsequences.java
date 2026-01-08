class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[][] dp=new int[n1][n2];
        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(nums1,nums2,n1-1,n2-1,dp);
    }
    public static int f(int a1[],int a2[],int i,int j,int[][] dp){
        if(i<0 || j<0) return -(int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int t=a1[i]*a2[j]+Math.max(0,f(a1,a2,i-1,j-1,dp));
        int nt=0+Math.max(f(a1,a2,i-1,j,dp),f(a1,a2,i,j-1,dp));
    return dp[i][j]=Math.max(nt,t);
    }
}