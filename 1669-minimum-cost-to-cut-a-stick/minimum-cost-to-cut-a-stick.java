class Solution {
    public int minCost(int n, int[] cuts) {
        //sort for independent partion would happen
        Arrays.sort(cuts);
        int arr[]=new int[cuts.length+2];
        for(int i=0;i<cuts.length;i++){
            arr[i+1]=cuts[i];
        }
        arr[cuts.length+1]=n;
        int c=cuts.length;
        int dp[][]=new int[c+1][c+1];
        for(int i=0;i<c+1;i++) Arrays.fill(dp[i],-1);
    return f(1,c,arr,dp);
    }
    static int f(int i,int j,int[] arr,int dp[][]){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        //explore all ways
        int min=(int)1e9;
        for(int k=i;k<=j;k++){
            int val=arr[j+1]-arr[i-1]+f(i,k-1,arr,dp)+f(k+1,j,arr,dp);
            min=Math.min(min,val);
        }
    return dp[i][j]=min;
    }
}