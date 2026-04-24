class Solution {
    public int visibleBuildings(int arr[]) {
        // code here
        int p=0;
        int ct=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(p<=arr[i]){
                p=arr[i];
                ct++;
            }
        }
    return ct;
    }
}