class Pair{
    String str;
    int len;
    Pair(String s,int l){
        str=s;
        len=l;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
                // Why BFS?  Question asks for shortest transformation sequenc
                // Whenever you see:  shortest path  unweighted graph
                // Think:  BFS
        Queue<Pair> q=new LinkedList<>();
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            hs.add(wordList.get(i));
        }
        if(hs.contains(beginWord)){ //visited first 
            hs.remove(beginWord);
        }
        q.add(new Pair(beginWord,1));

        //bfs
        while(!q.isEmpty()){
            String word=q.peek().str;
            int st=q.peek().len;
            if(word.equals(endWord)) return st;   // final print level
            q.poll();
            for(int i=0;i<word.length();i++){
                char[] ca=word.toCharArray();
                for(char ch='a';ch<='z';ch++){ //check with every albhabet 
                    ca[i]=ch;
                    String newS=new String(ca); //if 1 char update string contains then len+1 remove it
                    if(hs.contains(newS)){
                        hs.remove(newS);
                        q.add(new Pair(newS,st+1));
                    }
                }
            }
        }
    return 0;

    }
}