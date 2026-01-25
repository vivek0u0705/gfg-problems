class Solution {
    int findWays(int n) {
        // code here
        if(n%2!=0) return 0;
        return f(0,0,0,n);
    }
    public static int f(int i,int oc,int cc,int n){
        if(i==n ) return oc==cc?1:0;
        if(cc>oc) return 0;
        int c=0;
        if(oc<n/2){
            c+=f(i+1,oc+1,cc,n);
        }
        if(cc<oc){
            c+=f(i+1,oc,cc+1,n);
        }
    return c;
    }
}
