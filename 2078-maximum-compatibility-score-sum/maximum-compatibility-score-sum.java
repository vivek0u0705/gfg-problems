class Solution {
    public int maxCompatibilitySum(int[][] stu, int[][] men) {
        int n=stu.length;
        int m=stu[0].length;
        int cost[][]=new int[n][n];
        for(int i=0;i<n;i++){
            int[] arr=stu[i];
            for(int j=0;j<n;j++){
                int b[]=men[j];
                int ct=0;
                for(int k=0;k<m;k++){
                    if(arr[k]==b[k]) ct++;
                }
                cost[i][j]=ct;
            }
        }
    int mask=0;
    return f(0,cost,mask,n);
    }
    static int f(int i,int[][] cost,int mask,int n){
        if(i==n) return 0;
        int ans=-(int)1e9;
        for(int j=0;j<n;j++){
            if((mask & (1<<j))==0){
                ans=Math.max(ans,cost[i][j]+f(i+1,cost,mask | (1<<j) ,n));
            }
        }
    return ans;
    }
}