class Solution {
    public double[] internalAngles(int[] sides) {
        Arrays.sort(sides);
        int a=sides[0],b=sides[1],c=sides[2];
        if(a+b<=c) return new double[]{};
        double cosA=(b*b+c*c-a*a) / (2.0*b*c);
        double cosB=(-b*b+c*c+a*a) / (2.0*a*c);
        double cosC=(b*b-c*c+a*a) / (2.0*b*a);     // cos   range [-1 t0 1]   
        double Ad=Math.toDegrees(Math.acos(cosA));    //cos value to radian
        double Bd=Math.toDegrees(Math.acos(cosB));   //   pi rac = 180 deg
        double Cd=Math.acos(cosC)* (180)/Math.PI;     // ran -> deg    x*(180)/pi
        double[] arr=new double[3];
        arr[0]=Ad;
        arr[1]=Bd;
        arr[2]=Cd;
        Arrays.sort(arr);
        return arr;
    }
}