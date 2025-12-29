class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int i=0;
        int j=0;
        int n=a.length;
        int m=b.length;
        int t=0;
        while(i<n && j<m){
            if(a[i]<b[j]){
                if(t==k-1) return a[i];
                i++;
            }
            else{
                if(t==k-1) return b[j];
                j++;
            }
            t++;
        }
        while(i<n){
                if(t==k-1) return a[i];
                i++;
            t++;
        }
        while(j<m){
                if(t==k-1) return b[j];
                j++;
            t++;
        }
    return 0;
    }
}