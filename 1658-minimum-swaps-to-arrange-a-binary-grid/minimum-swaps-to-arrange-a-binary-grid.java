class Solution {
    public int minSwaps(int[][] mat) {
        int n=mat.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int t=0;
            for(int j=n-1;j>=0;j--){
                if(mat[i][j]==1) {
                    t=j;
                    break;
                }
            }
            ans[i]=n-t-1;
        }
        int ct=0;
        for(int i=0;i<n;i++){
            int nd=n-i-1;
            int j=i;
            while(j<n){
                if(ans[j]>=nd) break;
                else j++;
            }
            if(j==n) return -1;
            while(j>i){
                int tm=ans[j];
                ans[j]=ans[j-1];
                ans[j-1]=tm;
                ct++;
                j--;
            }
        }
    return ct;
    }
}