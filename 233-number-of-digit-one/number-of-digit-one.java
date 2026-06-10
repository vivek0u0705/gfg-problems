class Solution {
    static String str;
    static Integer[][][][] dp;
    public int countDigitOne(int n) {
        str=String.valueOf(n);
       //state pos,tight,lz
       dp=new Integer[11][2][2][11];
       return f(0,1,1,0);
    }
    static int f(int i,int tight,int lz,int ct){
        if(i==str.length()) return ct;
        
        if(dp[i][tight][lz][ct]!=null) return dp[i][tight][lz][ct];

        int ub=(tight==1)?str.charAt(i)-'0':9;
        int ans=0;
        for(int d=0;d<=ub;d++){
            int ntight=(tight==1 && d==ub)?1:0;
            int nlz= (lz==1 && d==0)?1:0;
            ans+=f(i+1,ntight,nlz,(d==1)?ct+1:ct);
        }
    return dp[i][tight][lz][ct]=ans;
    }
}