class Solution {
    public boolean canPartitionGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        long ans[][]=new long[n][m];
        ans[0][0]=mat[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=mat[i][j];
                if(i>0) ans[i][j]+=ans[i-1][j];
                if(j>0) ans[i][j]+=ans[i][j-1];
                if(i>0 && j>0) ans[i][j]-=ans[i-1][j-1];
            }
        }
        long t=ans[n-1][m-1];
        for(int i=0;i<n-1;i++){
            long ts=ans[i][m-1];
            if(ts==t-ts) return true;
        }
        for(int j=0;j<m-1;j++){
            long ls=ans[n-1][j];
            if(ls==t-ls) return true;
        }
    return false;
    }
}