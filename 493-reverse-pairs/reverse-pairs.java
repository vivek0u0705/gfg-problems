class Solution {
    static int ct;
    public int reversePairs(int[] nums) {
       ct=0;
       mergeSort(nums,0,nums.length-1);
       System.out.print(Arrays.toString(nums));
    return ct;
    }
    static void mergeSort(int[] nums,int s,int e){
        if(s>=e) return;
            int m=(s+e)/2;
            mergeSort(nums,s,m);
            mergeSort(nums,m+1,e);
            //count  here both are sorted so when right array obeys codn we inc j the add all satisfied values
            int j=m+1;
            for(int i=s;i<=m;i++){
                while(j<=e && nums[i] > 2L*nums[j]){
                    j++;
                }
                ct+=j-(m+1);
            }
            merge(s,m,e,nums);
    }
    static void merge(int i,int m,int e,int nums[]){
        int s=i;
        int j=m+1;
        List<Integer> li=new ArrayList<>();
        while(i<=m && j<=e){
            if(nums[i] <= nums[j]){
                li.add(nums[i]);
                i++;
            }
        //we cant count here with nums[i]> 2*nums[j] why beacuse array wont be sorted we get wrong ct
            else {
                li.add(nums[j]);
                j++;
            }
        }
        while(i<=m){
            li.add(nums[i]);
            i++;
        }
        while(j<=e){
            li.add(nums[j]);
            j++;
        }
        for(int k=0;k<li.size();k++){
            nums[s+k]=li.get(k); 
        }
    }
} 



//inversion count pb
//it is count   nums[i]> nums[j]  so we can directlly do in merge fn with sorted arrays



// class Solution {
//     public int reversePairs(int[] nums) {
//         int ans=m(nums,0,nums.length-1);
//     return ans;
//     }
//     public static int m(int[] arr,int s,int e){
//         if(s<e){
//              int m=s+(e-s)/2;
//              int lC=m(arr,s,m);
//              int rC=m(arr,m+1,e);
//              int invC=Merge(arr,s,m,e);
//         return lC+rC+invC;
//         }
//     return 0;
//     }
//     public static int Merge(int[] arr,int s,int m,int e){
//         int c=0;
//         int i=s;
//         int j=m+1;
//         List<Integer> l=new ArrayList<>();
//         while(i<=m && j<=e){
//             if(arr[i]<=2*arr[j]){
//                 l.add(arr[i]);
//                 i++;
//             }
//             else{
//                 l.add(arr[j]);
//                 j++;
//                 c+=(m-i+1);
//             }
//         }
//         while(i<=m){
//             l.add(arr[i]);
//             i++;
//         }
//          while(j<=e){
//             l.add(arr[j]);
//             j++;
//         }
//         for(int idx=0;idx<l.size();idx++){
//             arr[idx+s]=l.get(idx);
//         }
//     return c;
//     }
// }