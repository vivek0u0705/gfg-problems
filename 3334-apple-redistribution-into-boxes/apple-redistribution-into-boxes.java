class Solution {
    public int minimumBoxes(int[] arr, int[] cap) {
        Arrays.sort(cap);
        int s=0;
        for(int i:arr){
            s+=i;
        }
        int c=0;
        int ts=0;
        for(int i=cap.length-1;i>=0;i--){
            if(ts>=s) break;
            ts+=cap[i];
            c++;
        }
    return c;
    }
}