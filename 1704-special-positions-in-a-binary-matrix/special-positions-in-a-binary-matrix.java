class Solution {
    public int numSpecial(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int r[]=new int[m];
        int c[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    r[j]++;
                    c[i]++;
                }
            }
        }
        int ct=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1 && r[j]==1 && c[i]==1) ct++;
            }
        }
    return ct;
    }
}