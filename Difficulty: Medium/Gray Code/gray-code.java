class Solution {
    public ArrayList<String> graycode(int n) {
        // code here
        ArrayList<String> li=new ArrayList<>();
        StringBuilder cur=new StringBuilder();
        ArrayList<String> li2=new ArrayList<>();
        f(0,n,li,cur);
        for(int i=0;i<li.size();i++){
            String bn=li.get(i);
            if(bn.length()>0){
                String s="";
                s+=bn.charAt(0);
                for(int j=1;j<bn.length();j++){
                    int p=bn.charAt(j-1)-'0';
                    int u=bn.charAt(j)-'0';
                    int ans=p^u;
                    s+=ans;
                }
                li2.add(s);
            }
        }
    return li2;
            
    }
    public static void f(int i,int n,ArrayList<String> li, StringBuilder cur){
        if(i==n){
            li.add(cur.toString());
            return;
        }
        cur.append('0');
        f(i+1,n,li,cur);
        cur.deleteCharAt(cur.length()-1);
        cur.append('1');
        f(i+1,n,li,cur);
        cur.deleteCharAt(cur.length()-1);
    }
}