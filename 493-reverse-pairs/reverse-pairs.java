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