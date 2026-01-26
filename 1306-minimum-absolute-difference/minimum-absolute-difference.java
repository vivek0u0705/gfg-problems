class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> a=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]<min){
                min=arr[i]-arr[i-1];
            }
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==min){
                a.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return a;
    }
}