class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // HashSet<Integer> hs=new HashSet<>();
        int n=A.length;
        int[] res=new int[n];
        int[] fa=new int[51];
        int[] fb=new int[51];
        for(int i=0;i<n;i++){
            fa[A[i]]++;
            fb[B[i]]++;
            int ct=0;
            for(int j=1;j<=50;j++){
                if(fa[j]!=0 && fa[j]==fb[j]){
                    ct++;
                }
            }
            res[i]=ct;
        }
    return res;
    }
}