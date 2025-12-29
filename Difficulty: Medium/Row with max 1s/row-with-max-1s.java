// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int mi=0;
        int m=0;
        for(int i=0;i<arr.length;i++){
            int c=0;
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1) c++;
            }
            if(c>m){
                mi=i;
                m=c;
            }
        }
    return mi;
    }
}