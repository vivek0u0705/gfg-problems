class Solution {
    public int largestMagicSquare(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int max=0;
        for(int k=1;k<=Math.min(n,m);k++){
            for(int i=0;i<n-k+1;i++){
                for(int j=0;j<m-k+1;j++){
                    if(check(i,j,k,mat)){
                        max=Math.max(max,k);
                    }
                }
            }
        }
    return max;
    }
    public static boolean check(int i,int j,int k,int[][] mat){
        int t=0;
        for(int r=i;r<=i+k-1;r++){
            t+=mat[r][j];
        }
        // rows

        for(int r=i+1;r<=i+k-1;r++){
            int sc=0;
            for(int c=j;c<=j+k-1;c++){
                sc+=mat[r][c];
            }
            if(sc!=t) return false;
        }

        //cols

        for(int c=j;c<=j+k-1;c++){
            int sc=0;
            for(int r=i;r<=i+k-1;r++){
                sc+=mat[r][c];
            }
            if(sc!=t) return false;
        }
        //dia
        int sc=0;
        for(int r=i,c=j;r<=i+k-1 && c<=j+k-1;r++,c++){
            sc+=mat[r][c];
        }
        if(sc!=t) return false;
        sc=0;
        for(int r=i,c=j+k-1;r<=i+k-1 && c>=j;r++,c--){
            sc+=mat[r][c];
        }
        if(sc!=t) return false;
    return true;
    }
}