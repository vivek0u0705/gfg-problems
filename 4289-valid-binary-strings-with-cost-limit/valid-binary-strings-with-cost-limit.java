class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans=new ArrayList<>();
        char[] ca=new char[n];
        f(0,ans,n,k,ca);
    return ans;
    }
    static void f(int i,List<String> ans,int n,int k,char ca[]){
        if(i==n){
            String str=new String(ca);
            
            int cost=0;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='1') cost+=j;
            }
            if(cost<=k) ans.add(new String(str));
            return;
        }

        ca[i]='0';
        f(i+1,ans,n,k,ca);
        if(i==0 || ca[i-1]!='1'){
           ca[i]='1';
           f(i+1,ans,n,k,ca);
        }
    }
}