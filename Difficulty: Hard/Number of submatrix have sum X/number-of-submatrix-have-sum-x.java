class Solution {
    public int countSquare(int[][] mat, int x) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int[][] ps=new int[n][m];
        ps[0][0]=mat[0][0];
        for(int i=1;i<m;i++) ps[0][i]=mat[0][i]+ps[0][i-1];
        for(int i=1;i<n;i++) ps[i][0]=mat[i][0]+ps[i-1][0];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                ps[i][j]=mat[i][j]+ps[i-1][j]+ps[i][j-1]-ps[i-1][j-1];
            }
        }
        int ct=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<Math.min(n-i,m-j);k++){
                    int r=i+k;
                    int c=j+k;
                    long s=ps[r][c];
                    if(i>0) s-=ps[i-1][c];
                    if(j>0) s-=ps[r][j-1];
                    if(i>0 && j>0) s+=ps[i-1][j-1];
                    if(s==x) ct++;
                }
            }
        }
    return ct;
        
    }
}