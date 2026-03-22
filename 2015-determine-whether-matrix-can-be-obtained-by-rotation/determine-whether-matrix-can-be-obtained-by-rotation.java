class Solution {
    public boolean findRotation(int[][] mat, int[][] tar) {
        int n=mat.length;
        int m=mat[0].length;
        boolean b=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=tar[i][j]){
                    b=false;
                    break;
                }
            }
            if(!b) break;
        }
        if(b) return true;
        //90
        f(mat);
        b=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=tar[i][j]){
                    b=false;
                    break;
                }
            }
            if(!b) break;
        }
        if(b) return true;
        //180
        f(mat);
         b=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=tar[i][j]){
                    b=false;
                    break;
                }
            }
            if(!b) break;
        }
        if(b) return true;
        //270
        f(mat);
        b=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=tar[i][j]){
                    b=false;
                    break;
                }
            }
            if(!b) break;
        }
        if(b) return true;
    return false;
    }
    public static void f(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                int t=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=t;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m/2;j++){
                int t=mat[i][j];
                mat[i][j]=mat[i][m-j-1];
                mat[i][m-j-1]=t;
           }
        }
    }
}