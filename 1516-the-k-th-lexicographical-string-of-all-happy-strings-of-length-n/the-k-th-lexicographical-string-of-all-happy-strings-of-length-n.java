class Solution {
    public String getHappyString(int n, int k) {
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        f(0,n,res,sb);
        if(k>res.size()) return "";
    return res.get(k-1);
    }
    public static void f(int i,int n,List<String> res,StringBuilder cur){
        if(i==n){
            res.add(cur.toString());
            return;
        }
        if(cur.length()==0 || cur.charAt(cur.length()-1)!='a'){
            cur.append('a');
            f(i+1,n,res,cur);
            cur.deleteCharAt(cur.length()-1);
        } 
        if(cur.length()==0 || cur.charAt(cur.length()-1)!='b'){
            cur.append('b');
            f(i+1,n,res,cur);
            cur.deleteCharAt(cur.length()-1);
        }
        if(cur.length()==0 || cur.charAt(cur.length()-1)!='c'){
            cur.append('c');
            f(i+1,n,res,cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}