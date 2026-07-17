class Solution {
    Integer[][] dp;
    public int minDistance(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        dp=new Integer[n][m];
        return f(n-1,m-1,s1,s2);
    }
    public int f(int i,int j,String s1,String s2){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=null) return dp[i][j];
         //if matches go back
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=0+f(i-1,j-1,s1,s2); 

        else{
            return dp[i][j]=1+Math.min(f(i,j-1,s1,s2),
            Math.min(f(i-1,j,s1,s2),f(i-1,j-1,s1,s2)));
        }
    }
}



//if char matches go back 

//else 1+   every operations take 1 step
//1 insert i,j-1   inserting next idx in s1 
//2 delete  i-1,j
//3 replace i-1,j-1


//base case
// if i<0 then need rem len of s2 j+1
// if j<0 then need rem len of s1 i+1