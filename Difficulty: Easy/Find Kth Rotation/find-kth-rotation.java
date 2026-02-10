class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int i=arr.length-1;
        while(i>0){
            if(arr[i-1]>arr[i]){
                return i;
            }
            else i--;
        }
    return 0;
    }
}