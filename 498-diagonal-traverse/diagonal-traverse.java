class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int a[]=new int[m*n];
        int r=0,c=0,idx=0;
        boolean up=true;
        while(r<m && c<n){
            if(up){
                while(r>=0 && c<=n-1){
                    a[idx++]=mat[r][c];
                    r--;
                    c++;
                }
                if(c==n){
                    c=n-1;
                    r=r+2;
                }
                else{
                    r=0;
                }
                up=false;
            }
            else{
                while(c>=0 && r<=m-1){
                    a[idx++]=mat[r][c];
                    r++;
                    c--;
                }
                // a[idx++]=mat[r][c];
                if(r==m){
                    c=c+2;
                    r=m-1;
                }
                else{
                    c=0;
                }
                up=true;
            }
        }
    return a;
    }
}