class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length;
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                    double x1=points[i][0];
                    double y1=points[i][1];
                    double x2=points[j][0];
                    double y2=points[j][1];
                    int noofP=0;
                    if(x2-x1==0){
                       noofP=verticalP(x1,points); 
                    }
                    else{
                        double m=slope(x1,y1,x2,y2);
                        double c=intercept(x1,y1,m); 
                        noofP=checkP(m,c,points);
                    }
                    max=Math.max(max,noofP);
                    
            }
        }
    return max;
    }
    public int verticalP(double x,int[][] pts){
        int ct=0;
        for(int i=0;i<pts.length;i++){
            if(pts[i][0]==x)ct++;
        }
    return ct;
    }
    public double slope(double x1,double y1,double x2,double y2){
        return (y2-y1)/(x2-x1);
    }
    public double intercept(double x1,double y1,double m){
        return y1-m*x1;
    }
    public int checkP(double m,double c,int[][] pts){
        int ct=0;
        for(int i=0;i<pts.length;i++){
            double x=pts[i][0];
            double y=pts[i][1];
            // double t=m*x-y+c;
            if(Math.abs(m * x + c - y) < 1e-9) ct++;
        }
    return ct;
    }
}