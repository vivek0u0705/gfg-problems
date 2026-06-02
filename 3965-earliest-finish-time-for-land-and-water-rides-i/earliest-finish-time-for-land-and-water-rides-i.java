class Solution {
    public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
        int l1=lst.length;
        int l2=wst.length;
        int min=(int)1e9;
        int t=0;
        //land -> water 

        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                // t=0;
                if(lst[i]+ld[i]>=wst[j]){
                    min=Math.min(min,lst[i]+ld[i]+wd[j]);
                }
                else{
                    min=Math.min(min,wst[j]+wd[j]);
                }
            }
        }
        //water -> land

        for(int i=0;i<l2;i++){
            for(int j=0;j<l1;j++){
                // t=0;
                if(wst[i]+wd[i]>=lst[j]){
                    min=Math.min(min,wst[i]+wd[i]+ld[j]);
                }
                else{
                    min=Math.min(min,lst[j]+ld[j]);
                }
            }
        }
    return min;
    }
}