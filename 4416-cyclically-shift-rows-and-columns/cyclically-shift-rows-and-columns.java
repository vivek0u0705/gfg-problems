class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rs, int[] cs) {
        // rows
        for(int i=0;i<n;i++){
            int[] mat=grid[i].clone();
            makeRS(mat,rs[i]);
            grid[i]=mat.clone();
        }
        //cols
        for(int i=0;i<n;i++){
            int[] mat=new int[n];
            for(int j=0;j<n;j++){
                mat[j]=grid[j][i];
            }
            makeRS(mat,cs[i]);
            for(int j=0;j<n;j++){
                grid[j][i]=mat[j];
            }
        }
    return grid;
    }
    public void makeRS(int[] mat,int k){
        int n=mat.length;
        reverse(mat,0,k-1);
        reverse(mat,k,n-1);
        reverse(mat,0,n-1);
    }
    public void reverse(int[] mat,int i,int j){
        while(i<=j){
            int t=mat[i];
            mat[i]=mat[j];
            mat[j]=t;
            i++;
            j--;
        }
    }
}