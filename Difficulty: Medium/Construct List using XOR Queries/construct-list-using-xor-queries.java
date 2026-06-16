class Solution {
    public ArrayList<Integer> constructList(int[][] que) {
        // code here
        int n=que.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int xr=0;
        for(int i=n-1;i>=0;i--){  //iterate from back take test case dry run we can understand   
        //from back we se all xr value with do xr with inserted value and add it
            int a=que[i][0];
            int b=que[i][1];
            if(a==0){
                ans.add(xr^b);
            }
            else{
                xr^=b;
            }
        }
        ans.add(0^xr);  // at last do xor with intial 0 that xor was all xors to right
        Collections.sort(ans);
    return ans;
    }
}