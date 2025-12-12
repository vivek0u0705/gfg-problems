class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // code here
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            ArrayList<Integer> l=new ArrayList<>();
            for(int j=0;j<m;j++){
                l.add(mat[j][i]);
            }
            al.add(l);
        }
    return al;
    }
}