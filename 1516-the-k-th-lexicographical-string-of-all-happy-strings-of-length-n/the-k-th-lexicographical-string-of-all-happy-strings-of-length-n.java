class Solution {
    public String getHappyString(int n, int k) {
        List<String> res=new ArrayList<>();
        f(0,n,res,"");
        if(k>res.size()) return "";
    return res.get(k-1);
    }
    public static void f(int i,int n,List<String> res,String cur){
        if(i==n){
            res.add(cur.toString());
            return;
        }
        if(cur.length()==0 || cur.charAt(cur.length()-1)!='a'){
            f(i+1,n,res,cur+'a');
        } 
        if(cur.length()==0 || cur.charAt(cur.length()-1)!='b'){
            f(i+1,n,res,cur+'b');
        }
        if(cur.length()==0 || cur.charAt(cur.length()-1)!='c'){
            f(i+1,n,res,cur+'c');
        }
    }
}