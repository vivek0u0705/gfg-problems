class Solution {
    public int maxArea(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] dp=new int[n][m];
        //here we used lc-1277  find max square in matrix
        for(int i=0;i<n;i++) dp[i][0]=mat[i][0];
        for(int i=0;i<m;i++) dp[0][i]=mat[0][i];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>0 && j>0 && mat[i][j]==1){
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }
            }
        }
        int s=1;
        int e=Math.min(m,n);
        int res=-1;
        while(s<=e){
            int k=(s+e)/2;
            if(check(k,dp)){
                res=k;
                s=k+1;
            }
            else{
                e=k-1;
            }
        }
    return res!=-1?res*res:0;
    }
    public boolean check(int k,int[][] dp){
        int n=dp.length;
        int m=dp[0].length;
        int minRow=(int)1e9;
        int minCol=(int)1e9;
        int maxRow=-(int)1e9;
        int maxCol=-(int)1e9;
        // in dp squares side length stored in bottom right 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //top left corner values
                if(dp[i][j]>=k){
                    int r=i-k+1;
                    int c=j-k+1;
                    minRow=Math.min(minRow,r);
                    minCol=Math.min(minCol,c);
                    maxRow=Math.max(maxRow,r);
                    maxCol=Math.max(maxCol,c);
                }
            }
        }
        // if 2 matrices found with k*k  then 
        // 1st mat1 row =minRow,col=minCol
        //2nd mat2 row= maxRow,col=MaxCol;
        // (maxRow-minRow>=k && maxCol-minCol>=k) then only valid
    return (maxCol-minCol)>=k || (maxRow-minRow)>=k;
    }
}