class Solution {
    public int[][] minAbsDiff(int[][] mat, int ky) {
        int n=mat.length;
        int m=mat[0].length;
        int ans[][]=new int[n-ky+1][m-ky+1];
        for(int i=0;i<n-ky+1;i++){
            for(int j=0;j<m-ky+1;j++){
                List<Integer> li=new ArrayList<>();
                HashSet<Integer> hs=new HashSet<>();
                for(int k=i;k<i+ky;k++){
                    for(int l=j;l<j+ky;l++){
                        if(!hs.contains(mat[k][l])){
                            hs.add(mat[k][l]);
                            li.add(mat[k][l]);
                        }
                    }
                }
                ans[i][j]=f(li,hs);
            }
        }
    return ans;
    }
    public static int f(List<Integer> li,HashSet<Integer> hs){
        int m=(int)1e9;
        if(li.size()==1) return 0;
        for(int i=0;i<li.size();i++){
            for(int j=i+1;j<li.size();j++){
                m=Math.min(m,Math.abs(li.get(i)-li.get(j)));
            }
        }
    return m;
    }
}