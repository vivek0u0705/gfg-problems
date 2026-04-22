class Solution {
    public List<String> twoEditWords(String[] que, String[] dict) {
        List<String> ans=new ArrayList<>();
        int n1=que.length;
        int n2=dict.length;
        for(int i=0;i<n1;i++){
            String str=que[i];
            for(int j=0;j<n2;j++){
                String str2=dict[j];
                int ct=0;
                for(int k=0;k<str.length();k++){
                    if(k<str.length() && str.charAt(k)!=str2.charAt(k))ct++;
                }
                if(ct<=2){
                    ans.add(str);
                    break;
                }
            }
        }
    return ans;
    }
}