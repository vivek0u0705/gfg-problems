class Solution {
    public char nextGreatestLetter(char[] arr, char t) {
        int n=arr.length;
        char ans='%';
        int s=0;
        int e=n-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]-'a'>t-'a'){
                ans=arr[mid];
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
    if(ans=='%') return arr[0];
    return ans;
    }
}