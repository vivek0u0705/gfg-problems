class Solution {
    public ArrayList<String> generateIp(String s) {
        // code here
        ArrayList<String> res=new ArrayList<>();
        f(0,s,"",res);
        return res;
    }
    public static void f(int i,String s,String cur,ArrayList<String> res){
        if(i==s.length()){
            int ct=0;
            for(char c:cur.toCharArray()){
                if(c=='.') ct++;
            }
            if(ct==4) res.add(cur.substring(0,cur.length()-1));
            return;
        }
        for(int idx=i;idx<i+3 && idx<s.length();idx++){
            String str=s.substring(i,idx+1);
            int num=Integer.parseInt(str);
            if(num>255|| (str.length()>1 && str.charAt(0)=='0')) break;
            f(idx+1,s,cur+str+'.',res);
        }
    }
}