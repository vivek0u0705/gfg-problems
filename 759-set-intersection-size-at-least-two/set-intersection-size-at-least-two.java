
class Solution {
    public int intersectionSizeTwo(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(a[1]==b[1]) return Integer.compare(b[0],a[0]);
            else return Integer.compare(a[1],b[1]);
        });
        int a=arr[0][1]-1;
        int b=arr[0][1];
        int ans=2;
        for(int i=1;i<n;i++){
            if(b<arr[i][0]){
                ans+=2;
                a=arr[i][1]-1;
                b=arr[i][1];
            }
            else if(a < arr[i][0]){
                ans++;
                a=b;
                b=arr[i][1];
            }
            else ans+=0;
        }
    return ans;
    }
}