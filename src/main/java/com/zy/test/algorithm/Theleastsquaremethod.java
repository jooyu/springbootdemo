package com.zy.test.algorithm;

/** 
 * 最小二乘法 y=ax+b 
 *  
 * @author yu joo
 *  
 */  
public class Theleastsquaremethod {  
  
    private static double a;  
  
    private static double b;  
  
    private static int num;  
  
    /** 
     * 训练 
     *  
     * @param x 
     * @param y 
     */  
    public static void train(double x[], double y[]) {  
        num = x.length < y.length ? x.length : y.length;  
        calCoefficientes(x,y);  
    }  
  
    /** 
     * a=(NΣxy-ΣxΣy)/(NΣx^2-(Σx)^2) 
     * b=y(平均)-a*x（平均） 
     * @param x 
     * @param y 
     * @return 
     */  
    public static void calCoefficientes (double x[],double y[]){  
        double xy=0.0,xT=0.0,yT=0.0,xS=0.0;  
        for(int i=0;i<num;i++){  
            xy+=x[i]*y[i];  
            xT+=x[i];  
            yT+=y[i];  
            xS+=Math.pow(x[i], 2.0);  
        }  
        a= (num*xy-xT*yT)/(num*xS-Math.pow(xT, 2.0));  
        b=yT/num-a*xT/num;  
    }  
  
    /** 
     * 预测 
     *  
     * @param xValue 
     * @return 
     */  
    public static double predict(double xValue) {  
        System.out.println("a="+a);  
        System.out.println("b="+b);  
        return a * xValue + b;  
    }  
  
    public static void main(String args[]) {  
        double[] x = { 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 } ;    
        double[] y = {23 , 44 , 32 , 56 , 33 , 34 , 55 , 65 , 45 , 55 } ;    
        Theleastsquaremethod.train(x, y);  
        System.out.println(Theleastsquaremethod.predict(10.0));  
    }  
  
}  