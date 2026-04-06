class Solution {
    public int minOperations(int[] arr1, int[] arr2) {
        int n=arr1.length;
        Arrays.sort(arr1);
        int n2=arr2.length;
        int gcd=arr2[0];
        for(int j=0;j<n2;j++){
           gcd=f(arr2[j],gcd);
        }
        for(int i=0;i<arr1.length;i++){
            if(gcd%arr1[i]==0) return i;
        }
    return -1;
    }
    public static int f(int a,int b){
        if(b==0) return a;
        return f(b,a%b);
    }
}