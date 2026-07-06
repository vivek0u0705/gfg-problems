class Solution {
    Integer[][][][] dp;
    public int countSpecialNumbers(int n) {
        String s=String.valueOf(n);
        dp=new Integer[s.length()][2][2][1<<10];
        //states -> pos,tight,lz,mask
        return f(0,1,1,0,s)-1;
    }
    public int f(int i,int tight,int lz,int mask,String s){

        if(i==s.length()) return 1;
        if(dp[i][tight][lz][mask]!=null) return dp[i][tight][lz][mask]; 
        int lb=0;
        int ub=tight==1?s.charAt(i)-'0':9;

        int ans=0;
        for(int dig=lb;dig<=ub;dig++){
            int nt=(tight==1 && dig==ub)==true?1:0;
            int nlz=(lz==1 && dig==0)==true?1:0;
            if(lz==1 && dig==0){ 
                ans+=f(i+1,nt,nlz,0,s);
            }
            else{// non zero came
                
                if((mask & (1<<dig))!=0) continue;

                ans+=f(i+1,nt,nlz,mask | (1<<dig),s);

            }
        }
    return dp[i][tight][lz][mask]=ans;
    }
}