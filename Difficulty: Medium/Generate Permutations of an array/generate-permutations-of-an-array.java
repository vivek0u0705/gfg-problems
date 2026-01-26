class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> li=new ArrayList<>();
        f(0,arr,li);
    return li;
    }
    public static void f(int idx,int[] arr,ArrayList<ArrayList<Integer>> li){
        if(idx==arr.length){
            ArrayList<Integer> l=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                l.add(arr[i]);
            }
            li.add(l);
            return;
        }
        for(int i=idx;i<arr.length;i++){
            swap(i,idx,arr);
            f(idx+1,arr,li);
            swap(idx,i,arr);
        }
    }
    public static void swap(int i ,int j,int[] arr){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
};