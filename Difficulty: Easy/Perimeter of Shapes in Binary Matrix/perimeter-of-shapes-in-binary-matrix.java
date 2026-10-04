class Solution {
    static int findPerimeter(int[][] mat) {
        // code here
        int ans=0;
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int ctt=0;
                if(mat[i][j]==1){
                    if(i-1<0 || mat[i-1][j]!=1) ctt++;
                    if(i+1==n || mat[i+1][j]!=1) ctt++;
                    if(j-1<0 || mat[i][j-1]!=1) ctt++;
                    if(j+1==m || mat[i][j+1]!=1) ctt++;
                    ans+=ctt;
                }
                //up
                //down
                //right
                //left
                
            }
        }
    return ans;
    }
}