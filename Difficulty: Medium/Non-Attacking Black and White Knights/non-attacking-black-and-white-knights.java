class Solution {
    public int numOfWays(int n, int m) {
        // code here
        int ct=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 int t=cnt(i,j,n,m);
                 int val=n*m-1-t;
                //  System.out.println(val);
                 ct+=val;
            }
        }
    return ct;
    }
    static int cnt(int i,int j,int n,int m){
        int ct=0;
        //left
        //up
        if(j-2>=0 && i-1>=0) ct++;
        //down
        if(j-2>=0 && i+1<n) ct++;
        
        //right
        //up
        if(j+2<m && i-1>=0) ct++;
        //down
        if(j+2<m && i+1<n) ct++;
        
        //up
        //left right
        if(i-2>=0 && j-1>=0) ct++;
        if(i-2>=0 && j+1<m) ct++;
        
        //down 
        //letf right
        
        if(i+2<n && j-1>=0) ct++;
        if(i+2<n && j+1<m) ct++;
        
        
    return ct;
    }
}