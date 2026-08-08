class Solution {
    long ans;
    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) nums[i]=b;
            else nums[i]=-a;
        }
        long[] ps=new long[n+1];
        for(int i=0;i<n;i++){
            ps[i+1]=ps[i]+nums[i];
        }
        // x * b + y * (-a) <= 0
        //make prefix sum
        // pre[r] - pre[l-1] <=0
        //pre[r]<=pre[l-1];
        //means it is count inversion pb  count all ps[i] > ps[j] when i<j 
        ans=0;
        mergeSort(ps,0,n);
    return ans;
    }
    public void mergeSort(long[] arr,int i,int j){ //0 to n-1
        if(i<j){
            int m=(i+j)/2;
            mergeSort(arr,i,m);
            mergeSort(arr,m+1,j);
            merge(arr,i,m,j);
            // System.out.println(Arrays.toString(arr));
        }
    }
    public void merge(long[] arr,int s,int m,int e){
        int n=arr.length;
        List<Long> li=new ArrayList<>();
        int j=m+1;
        int i=s;
        while(i<=m && j<=e){
            if(arr[i]<arr[j]){
                li.add(arr[i]);
                i++;
            }
            else{
                li.add(arr[j]);
                ans+=(m-i+1);
                j++;
            }
        }
        while(i<=m){
            li.add(arr[i]);
            i++;
        }
        while(j<=e){
            li.add(arr[j]);
            j++;
        }
        for(int k=0;k<li.size();k++){
            arr[s+k]=li.get(k);
        }
    }
}