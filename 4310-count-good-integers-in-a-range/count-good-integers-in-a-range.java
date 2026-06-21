class Solution {
    Long[][][][] dp;
    public long goodIntegers(long l, long r, int k) {
        //states    pos,tight,lz,prev
        dp=new Long[17][2][2][11];
        String lt=String.valueOf(l-1);
        String rt=String.valueOf(r);
        long rf=f(0,1,1,-1,k,rt);
        dp=new Long[17][2][2][11];
        long lf=f(0,1,1,-1,k,lt);  
    return rf-lf;
    }
    public long f(int i,int tight,int lz,int prev,int k,String str){
        if(i==str.length()) return 1;
        if(dp[i][tight][lz][prev+1]!=null) return dp[i][tight][lz][prev+1];  
        int ub=tight==1?str.charAt(i)-'0':9;

        long ans=0;
        for(int dig=0;dig<=ub;dig++){

            int ntight=(tight==1 && dig==ub)?1:0;
            int nlz=(lz==1 && dig==0)?1:0;

            if(lz==1 && dig==0){
                ans+=f(i+1,ntight,nlz,prev,k,str);
            }
            else{

                if(prev!=-1 && Math.abs(prev-dig)>k ) continue;

                ans+=f(i+1,ntight,nlz,dig,k,str);
            }
        }
    return dp[i][tight][lz][prev+1]=ans;
    }
}