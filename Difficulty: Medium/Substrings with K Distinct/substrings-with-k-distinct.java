class Solution {
    public int countSubstr(String s, int k) {
        //  code here
        char arr[]=s.toCharArray();
        return f(arr,k)-f(arr,k-1);
    }
    public static int f(char[] arr,int k){
        int s=0;
        int l=0;
        HashMap<Character,Integer> hs=new HashMap<>();
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