class Solution {
    static Integer[][][][] dp;
    public int numDupDigitsAtMostN(int n) {
        //state (pos,tight,lz,mask)
        dp=new Integer[11][2][2][1<<11];
        return n-f(String.valueOf(n),0,1,1,0)+1; //fn has from 0 -> n  we wnat 1 to n so did +1
    }
    static int f(String s,int pos,int tight,int lz,int mask){
        if(pos==s.length()) return 1;
        //if already exist 
        if(dp[pos][tight][lz][mask]!=null) return dp[pos][tight][lz][mask];
        int ub=(tight==1)?s.charAt(pos)-'0':9;
        int ans=0;
        for(int dig=0;dig<=ub;dig++){

            int ntight=(tight==1 && dig==ub)?1:0;

            //for leading zeros case

            if(lz==1 && dig==0){ //before all zeros and now dig is also zero
                ans+=f(s,pos+1,ntight,1,0);  // mask will be 0  wont change until non zero num comes 
            }

            else{//non zero comes 

                //check is taken or not if taken skip that num 
                if((mask & (1<<dig))!=0) continue;

                 ans+=f(s,pos+1,ntight,0,mask | (1<<dig));
            }
        }
    return dp[pos][tight][lz][mask]=ans;
    }
}