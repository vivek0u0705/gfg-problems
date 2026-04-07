class Solution {
    public double myPow(double x, int k) {
        int n=Math.abs(k);
        double r=f(x,n);
        if(k<0) return 1/r;
    return r;
    }
    public double f(double x, int n) {
        if(n==0) return 1;
        if(n%2==0) return f(x*x,n/2);
        else return x*f(x*x,n/2);
    }
}