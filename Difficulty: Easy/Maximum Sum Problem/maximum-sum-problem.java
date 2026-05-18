class Solution {
    public int maxSum(int n) {
        // code here.
        return f(n);
    }
    static int f(int n){
    if(n<4) return n;
    return Math.max(n,f(n/2)+f(n/3)+f(n/4));
    }
}
