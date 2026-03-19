class Solution {
    public int numberOfSubmatrices(char[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int mat1[][]=new int[n][m];
        int mat2[][]=new int[n][m];
        if(mat[0][0]=='X') mat1[0][0]=1;
        if(mat[0][0]=='Y') mat2[0][0]=1;
        //1st row,col
        for(int i=1;i<n;i++) {
            if(mat[i][0]=='X') mat1[i][0]=mat1[i-1][0]+1;
            else mat1[i][0]=mat1[i-1][0];
            if(mat[i][0]=='Y') mat2[i][0]=mat2[i-1][0]+1;
            else mat2[i][0]=mat2[i-1][0];
        }
        for(int i=1;i<m;i++) {
            if(mat[0][i]=='X') mat1[0][i]=mat1[0][i-1]+1;
            else mat1[0][i]=mat1[0][i-1];
            if(mat[0][i]=='Y') mat2[0][i]=mat2[0][i-1]+1;
            else mat2[0][i]=mat2[0][i-1];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j]=='X') mat1[i][j]=mat1[i-1][j]+mat1[i][j-1]-mat1[i-1][j-1]+1;
                else{
                    mat1[i][j]=mat1[i-1][j]+mat1[i][j-1]-mat1[i-1][j-1];
                }
                if(mat[i][j]=='Y') mat2[i][j]=mat2[i][j-1]+mat2[i-1][j]-mat2[i-1][j-1]+1;
                else {
                    mat2[i][j]=mat2[i][j-1]+mat2[i-1][j]-mat2[i-1][j-1];
                }
            }
        }
        int ct=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat1[i][j]!=0 && mat1[i][j]==mat2[i][j]) ct++;
            }
        }
    return ct;
    }
}