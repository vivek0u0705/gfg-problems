class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        // code here
        ArrayList<Integer> li=new ArrayList<>();
        int n=mat.length;
        for(int i=0;i<n;i++){
            int r=0;
            int c=i;
            while(r<n && c>=0){
                li.add(mat[r][c]);
                r++;
                c--;
            }
        }
        for(int i=1;i<n;i++){
            int r=i;
            int c=n-1;
            while(r<n){
                li.add(mat[r][c]);
                r++;
                c--;
            }
        }
    return li;
    }
}
