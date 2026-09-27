class Solution {
    Integer[] dp;
    public int jobScheduling(int[] st, int[] et, int[] p) {
        int n=st.length;
        int[][] mat=new int[n][3];
        for(int i=0;i<n;i++){
            mat[i][0]=st[i];
            mat[i][1]=et[i];
            mat[i][2]=p[i];
        }
        Arrays.sort(mat,(a,b)->Integer.compare(a[0],b[0]));
        dp=new Integer[n];
    return f(0,mat);
    }
    // public int f(int p,int i,int mat[][]){
    //     if(i==mat.length) return 0;
    //     if(dp[i][p+1]!=null) return dp[i][p+1];
    //     int nt=f(p,i+1,mat);
    //     int t=0;
    //     if(p==-1 || mat[p][1]<=mat[i][0]){
    //         t=mat[i][2]+f(i,i+1,mat);
    //     }
    // return dp[i][p+1]=Math.max(nt,t);
    // }
    public int f(int i,int mat[][]){
        if(i==mat.length) return 0;

        if(dp[i]!=null) return dp[i];

        int nt=f(i+1,mat);

        int next=binarySearch(i,mat);
        int t=mat[i][2]+f(next,mat); 

    return dp[i]=Math.max(nt,t);
    }
    public int binarySearch(int i,int[][] mat){
        int curEnd=mat[i][1];
        int s=i+1;
        int e=mat.length-1;
        int ans=mat.length;
        while(s<=e){
            int m=(s+e)/2;
            if(mat[m][0]>=curEnd){
                ans=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
    return ans;
    }
}


//make o(n^2) for dp 2 states (prev,next)
// make o(nlongn) by  finding next using binary bearch