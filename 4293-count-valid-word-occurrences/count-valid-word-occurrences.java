class Solution {
    public int[] countWordOccurrences(String[] s, String[] que) {
        String str="";
        int n=s.length;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(s[i]);
        }
        str=sb.toString();
        String fs="";
        StringBuilder sbb=new StringBuilder();
        boolean b=false;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c>='a' && c<='z'){
                sbb.append(c);
                b=false;
            }
            else if(c=='-'){
                boolean pc=(i>0) && str.charAt(i-1)>='a' && str.charAt(i-1)<='z';
                boolean nc=(i<str.length()-1) && str.charAt(i+1)>='a' && str.charAt(i+1)<='z';
                if(pc && nc){
                    sbb.append(c);
                }
                else {
                    if(b==false){
                        sbb.append(' ');
                        b=true;
                    }
                }
            }
            else{
                if(b==false){
                   sbb.append(' ');
                    b = true;
                }
            }
        }
        fs=sbb.toString();
        // System.out.print(fs);
        String[] stg = fs.split("[^a-z-]+");
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<stg.length;i++){
            String c=stg[i];
            if(c.isEmpty()) continue;
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int[] ans=new int[que.length];
        for(int i=0;i<que.length;i++){
            ans[i]=hm.getOrDefault(que[i],0);
        }
    return ans;
    }
}