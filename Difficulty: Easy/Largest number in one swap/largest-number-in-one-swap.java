class Solution {
    public String largestSwap(String s) {
        // code here
         char[] ca=s.toCharArray();
         int m=0;
         int p=0;
         int n=ca.length;
         int ss[]=new int[n];
         ss[n-1]=n-1;
           for(int i=ca.length-2;i>=0;i--){
                 if(ca[i]<=ca[ss[i+1]]) ss[i]=ss[i+1];
                 else ss[i]=i;
            }
            for(int i=0;i<ca.length;i++){
                if(ca[i]<ca[ss[i]]){
                    char t=ca[i];
                    ca[i]=ca[ss[i]];
                    ca[ss[i+1]]=t;
                    break;
                }
            }
    String str=new String(ca);
    return str;
    }
}