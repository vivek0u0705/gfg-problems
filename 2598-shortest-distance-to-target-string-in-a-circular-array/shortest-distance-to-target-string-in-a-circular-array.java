class Solution {
    public int closestTarget(String[] arr, String tar, int st) {
        int n=arr.length;
        int i=st;
        boolean k=false;
        while(i>st-n){
            if(arr[(i+n)%n].equals(tar)) {
                k=true;
                break;
            }
            i--;
        }
        int j=st;
        while(j<st+n){
            if(arr[j%n].equals(tar)) {
                   k=true;
                   break;
            }
            j++;
        } 
    if(!k) return -1; 
    return Math.min(j-st,st-i);
    }
}