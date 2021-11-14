package test;

import java.util.Scanner;

public class Test216 {
    public static void main(String[] args) {
        double s,sum;
        Scanner scanner=new Scanner(System.in);
        System.out.print("输入6边形边长：");
        s=scanner.nextDouble();
        sum=3*Math.pow(3,0.5)/2*s*s;
        System.out.println("这个6边形面积等于="+sum);
    }
}
