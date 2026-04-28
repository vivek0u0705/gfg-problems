class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        int N=n*m;
        if(N==1) return 0;
        int k=0;
        int[] arr=new int[N];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[k++]=grid[i][j];
            }
        }
        Arrays.sort(arr);
        int ct=0;
        int same=arr[0]%x;
        int mid=arr[(N-1)/2];
        for(int i=0;i<N;i++){
            if(arr[i]%x!=same) return -1;
            int val=Math.abs(arr[i]-mid);
            ct+=val/x;
        }
    return ct;
    }
}