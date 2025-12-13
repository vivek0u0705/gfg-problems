class Solution {
    public void swapDiagonal(int[][] mat) {
        // code here
        int n=mat.length;
        int i=0;
        while(i<n){
            int t=mat[i][i];
            mat[i][i]=mat[i][n-i-1];
            mat[i][n-i-1]=t;
            i++;
        }
    }
}