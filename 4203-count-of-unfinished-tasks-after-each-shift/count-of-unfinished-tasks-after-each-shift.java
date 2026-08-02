class Solution {
    public int[] countTasks(int[] tks, int[] sts) {
        int n=sts.length;
        int len=tks.length;
        long[] ps=new long[len];
        ps[0]=tks[0];
        for(int i=1;i<len;i++){
            ps[i]=ps[i-1]+1L*tks[i];
        }
        // maintain completion time for every shifts if exceeds make 0
        long com=0;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            long ub=(long)sts[i];
            
            com+=ub;
            if(com>=ps[len-1]){
                ans[i]=0;
                com=0;
                continue;
            }
            int idx=bs(ps,ub,com); //find ps[i]>(com+ub)  upperbound
            // System.out.println(idx+" "+com);
            ans[i]=len-idx;
        }
    return ans;
    }
    public static int bs(long[] ps,long ub,long com){
        int n=ps.length;
        int i=0;
        int j=n-1;
        int ans=n;
        while(i<=j){
            int m=i+(j-i)/2;
            if(ps[m]>com){
                // System.out.println(ps[m]);
                ans=m;
                j=m-1;
            }
            else{
                i=m+1;
            }
        }
    return ans;
    }
}