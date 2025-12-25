class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        // code here
        ArrayList<Integer> al=new ArrayList<Integer>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                //top
                if(i-1>=0) if(mat[i-1][j]>mat[i][j]) continue;
                //left
                if(j-1>=0) if(mat[i][j-1]>mat[i][j]) continue;
               // bottom
                if(i+1<mat.length) if(mat[i+1][j]>mat[i][j]) continue;
                ///right
                if(j+1<mat[0].length) if(mat[i][j+1]>mat[i][j]) continue;
                al.add(i);
                al.add(j);
                return al;
            }
        }
    return al;
    }
}