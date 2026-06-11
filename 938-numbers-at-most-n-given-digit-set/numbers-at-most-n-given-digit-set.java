class Solution {
    static HashSet<String> hs;
    static String s;
    static Integer[][][] dp;
    public int atMostNGivenDigitSet(String[] digits, int n) {

        //make values as static
        hs=new HashSet<>(Arrays.asList(digits));
        s=String.valueOf(n);
        dp=new Integer[11][2][2];

        //states pos,tight,lz
    return f(0,1,1) - 1;  // here fn include 0 we need from 1 to n
    }
    static int f(int i,int tight,int lz){
        if(i==s.length()) return 1;

        if(dp[i][tight][lz]!=null) return dp[i][tight][lz];

        int lb=0;
        int ub=(tight==1)?s.charAt(i)-'0':9;

        int ans=0;

        for(int dig=lb;dig<=ub;dig++){
            
            int ntight=(tight==1 && dig==ub)?1:0;
            int nlz=(lz==1 && dig==0)?1:0;

            // for lz cases skips the position upto the non zero dig occurs
            if(lz==1 && dig==0){
                ans+=f(i+1,ntight,nlz);
            }
            else{
                // non zero dig occurs
                //skip the dig if not in set
                if(!hs.contains(String.valueOf(dig))) continue;
                
                ans+=f(i+1,ntight,nlz);
            }
        }
    return dp[i][tight][lz]=ans;
    }
}