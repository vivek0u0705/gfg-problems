class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        ArrayList<int[]> al=new ArrayList<>();
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<arr.length;i++){
            if(al.isEmpty() || al.get(al.size()-1)[1]<arr[i][0]){
                al.add(arr[i]);
            }
            else{
                int m=Math.max(al.get(al.size()-1)[1],arr[i][1]);
                al.get(al.size()-1)[1]=m;
            }
        }
    return al;
    }
}