class Solution {
    public int numSpecial(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int ct=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            if(mat[i][j]==1){
                int c1=0;
                for(int k=0;k<m;k++){
                    if(mat[i][k]==1) c1++;
                }
                int c2=0;
                for(int l=0;l<n;l++){
                    if(mat[l][j]==1) c2++;
                }
                if(c1==1 && c2==1) ct++;
            }
                
            }
        }
    return ct;
    }
}