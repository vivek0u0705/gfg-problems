class Solution {
    public int countUnguarded(int m, int n, int[][] g, int[][] w) {
        int[][] mat=new int[m][n];
        for(int i=0;i<g.length;i++){
            mat[g[i][0]][g[i][1]]=1;
        }
        for(int i=0;i<w.length;i++){
            mat[w[i][0]][w[i][1]]=-1;
        }
        //l-r
        for(int i=0;i<m;i++){
            boolean b=false;
            for(int j=0;j<n;j++){
                if(mat[i][j]==-1) b=false;
                if(mat[i][j]==1) b=true;
                if(b && mat[i][j]==0) mat[i][j]=2;
            }
        }
        //r-l
        for(int i=0;i<m;i++){
            boolean b=false;
            for(int j=n-1;j>=0;j--){
                if(mat[i][j]==-1)b=false;
                if(mat[i][j]==1) b=true;
                if(b && mat[i][j]==0) mat[i][j]=2;
            }
        }
        //t-b
         for(int i=0;i<n;i++){
            boolean b=false;
            for(int j=0;j<m;j++){
                if(mat[j][i]==-1)b=false;
                if(mat[j][i]==1) b=true;
                if(b && mat[j][i]==0) mat[j][i]=2;
            }
        }
        // b-t
         for(int i=0;i<n;i++){
            boolean b=false;
            for(int j=m-1;j>=0;j--){
                if(mat[j][i]==-1) b=false;
                if(mat[j][i]==1) b=true;
                if(b && mat[j][i]==0) mat[j][i]=2;
            }
        }


        int c=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0) c++;
            }
        }
    return c;

    }
}