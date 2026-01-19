class Solution {
    public int maxSideLength(int[][] mat, int th) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] pf=new int[n][m];
        pf[0][0]=mat[0][0];
        for(int i=1;i<n;i++){
            pf[i][0]=pf[i-1][0]+mat[i][0];
        }
        for(int i=1;i<m;i++){
            pf[0][i]=pf[0][i-1]+mat[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                pf[i][j]=mat[i][j]+pf[i-1][j]+pf[i][j-1]-pf[i-1][j-1];
            }
        }
        int len=Math.min(m,n);
        int max=0;
        int l=1;
        int h=len;
        while(l<=h){
            int k=(l+h)/2;
            boolean f=false;
            for(int i=0;i<n-k+1;i++){
                if(f) break;
                for(int j=0;j<m-k+1;j++){
                        int s=sum(i,j,k,pf);
                        if(s<=th){
                           f=true;
                           break;
                        }
                }
            }
            if(f){
                max=k;
                l=k+1;
            }
            else{
                h=k-1;
            }
        }
    return max;
    }
    public static int sum(int i,int j,int k,int[][] pf){
        int t=pf[i+k-1][j+k-1];
        if(i-1>=0)t-=pf[i-1][j+k-1];
        if(j-1>=0)t-=pf[i+k-1][j-1];
        if(i-1>=0 && j-1>=0) t+=pf[i-1][j-1];

    return t;
    }
}