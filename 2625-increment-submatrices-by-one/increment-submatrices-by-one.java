class Solution {
    public int[][] rangeAddQueries(int n, int[][] q) {
        int[][] mat=new int[n][n];
        for(int i=0;i<q.length;i++){
            int r1=q[i][0];
            int c1=q[i][1];
            int r2=q[i][2];
            int c2=q[i][3];
            for(int j=r1;j<=r2;j++){
                for(int k=c1;k<=c2;k++){
                    mat[j][k]++;
                }
            }
        }
    return mat;
    }
}