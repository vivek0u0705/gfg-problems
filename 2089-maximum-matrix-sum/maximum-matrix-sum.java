class Solution {
    public long maxMatrixSum(int[][] mat) {
        int c=0;
        long s=0;
        int min=(int)1e9;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]<0) c++;
                min=Math.min(min,Math.abs(mat[i][j]));
                s+=Math.abs(mat[i][j]);
            }
        }
        if(c%2==0) return s;
        s=s-2*min;
    return s;
    }
}