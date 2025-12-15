class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] q) {
       int n=mat.length;
       int m=mat[0].length;
       int preS[][]=new int[n][m];
       preS[0][0]=mat[0][0];
       for(int i=1;i<m;i++) preS[0][i]=preS[0][i-1]+mat[0][i];
       for(int i=1;i<n;i++) preS[i][0]=preS[i-1][0]+mat[i][0];
       for(int i=1;i<n;i++){
           for(int j=1;j<m;j++){
               preS[i][j]=preS[i-1][j]+preS[i][j-1]-preS[i-1][j-1]+mat[i][j];
           }
       }
       ArrayList<Integer> al=new ArrayList<>();
       for(int i=0;i<q.length;i++){
           int r1=q[i][0];
           int c1=q[i][1];;
           int r2=q[i][2];
           int c2=q[i][3];
           int s1=preS[r2][c2];
           if(r1>0) s1=s1-preS[r1-1][c2];
           if(c1>0) s1=s1-preS[r2][c1-1];
           if(r1>0 && c1>0) s1+=preS[r1-1][c1-1];
           al.add(s1);
       }
    return al;
    }
}
