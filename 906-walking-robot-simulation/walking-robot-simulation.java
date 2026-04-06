class Solution {
    public int robotSim(int[] cmds, int[][] risk) {
        //storing risks
        HashSet<String> hs=new HashSet<>();
        int n=risk.length;
        for(int[] arr:risk){
            int a=arr[0];
            int b=arr[1];
            hs.add(a+","+b);
        }

        int dir=0;
        int x=0;
        int y=0;
        //0 N , 1 E , 2 S  , 3 W     -1 right     -2 left
        int len=cmds.length;
        int dr[]={0,1,0,-1};
        int dc[]={1,0,-1,0};
        int max=0;
        for(int i=0;i<len;i++){
        
            if(cmds[i]==-1){       //-1 -> right
                dir=(dir+1)%4;
            }
            
            else if(cmds[i]==-2){   //-2-> left
                dir=(dir-1)%4;
                if(dir<0) dir+=4;
            }
            //by dir go
            else{
                for(int j=0;j<cmds[i];j++){
                    int nr=x;
                    int nc=y;
                    if(dir==0) nc++;//N
                    else if(dir==1) nr++; //E
                    else if(dir==2) nc--; //S
                    else if(dir==3) nr--; //W
                    String str=nr+","+nc;
                    if(hs.contains(str)) break;
                    int val= nr*nr + nc*nc;

                    max=Math.max(max,val);
                    x=nr;
                    y=nc;

                }
            }
        }
    return max;
    }
}