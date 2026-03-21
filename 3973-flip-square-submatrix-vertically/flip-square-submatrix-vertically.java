class Solution {
    public int[][] reverseSubmatrix(int[][] mat, int x, int y, int k) {
        int n=mat.length;
        int m=mat[0].length;
        boolean b=false;
        for(int i=0;i<=n-k;i++){
            for(int j=0;j<=m-k;j++){
                if(i==x && j==y){
                    for(int p=j;p<j+k;p++){
                        int s=i;
                        int e=i+k-1;
                        while(s<e){
                            int t=mat[s][p];
                            mat[s][p]=mat[e][p];
                            mat[e][p]=t;
                            s++;
                            e--;
                        }
                    }
                    b=true;
                }
                if(b) break;
            }
            if(b) break;
        }
    return mat;
    }
}