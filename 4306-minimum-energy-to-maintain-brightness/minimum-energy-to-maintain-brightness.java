class Solution {
    public long minEnergy(int n, int bt, int[][] inter) {
        List<int[]> in =new ArrayList<>();
        Arrays.sort(inter,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<inter.length;i++){
            if(in.size()==0 || in.get(in.size()-1)[1]<inter[i][0]){
                in.add(new int[]{inter[i][0],inter[i][1]});
            }
            else{
                int max=Math.max(in.get(in.size()-1)[1],inter[i][1]);
                in.set(in.size()-1,new int[]{in.get(in.size()-1)[0],max});
            }
        }
        long len=0;
        for(int i=0;i<in.size();i++){
            int[] arr=in.get(i);
            len+=(long)(arr[1]-arr[0]+1);
        }
        int bulbs=(int)Math.ceil((double)bt/3);
    return bulbs*len;
    }
}