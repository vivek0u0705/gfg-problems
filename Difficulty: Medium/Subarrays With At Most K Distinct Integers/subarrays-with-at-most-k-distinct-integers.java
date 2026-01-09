class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        return f(arr,k);
    }
    public static int f(int[] arr,int k){
        int s=0;
        int l=0;
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int r=0;r<arr.length;r++){
            hs.put(arr[r],hs.getOrDefault(arr[r],0)+1);
            while(hs.size()>k){
                hs.put(arr[l],hs.get(arr[l])-1);
                if(hs.get(arr[l])==0) hs.remove(arr[l]);
                l++;
            }
            if(hs.size()<=k) s+=(r-l+1);
        }
    return s;
    }
}
