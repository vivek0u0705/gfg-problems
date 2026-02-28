class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // code here
        int v1=0;
        int v2=0;
        int i=0;
        int j=arr2.length-1;
        int d=(int)1e9;
        while(i<arr1.length && j>=0){
            int a=arr1[i];
            int b=arr2[j];
            int s=a+b;
            int diff=Math.abs(s-x);
            if(d>diff){
                v1=a;
                v2=b;
                d=diff;
            }
            
            if(s<x){
                i++;
            }
            else{
                j--;
            }
        }
        ArrayList<Integer> li=new ArrayList<>();
        li.add(v1);
        li.add(v2);
    return li;
    }
}