class Solution {
    public void sort012(int[] arr) {
        // code here
        int n=arr.length;
        int l=0,m=0,h=n-1;
        while(m<=h){
            if(arr[m]==0){
                swap(arr,l,m);
                l++;
                m++;
            }
            else if(arr[m]==1){
                m++;
            }
            else{
                swap(arr,m,h);
                h--;
            }
        }
    }
    public static void swap(int[] arr,int a,int b){
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }
}