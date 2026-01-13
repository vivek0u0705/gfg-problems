class Solution {
    public boolean canServe(int[] arr) {
        // code here
        int c5=0;
        int c10=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==5) c5++;
            if(arr[i]==10) {
                if(c5>=1){
                    c5--;
                    c10++;
                } 
                else return false;
            }
            if(arr[i]==20){
                if(c10>=1 &&c5>=1){
                    c10=c10-1;
                    c5=c5-1;
                }
                else if(c5>=3){
                    c5=c5-3;
                }
                else return false;
            }
        }
    return true;
    }
}