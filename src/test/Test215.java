package test;

import java.util.Scanner;

public class Test215 {
    public static void main(String[] args) {
        double x1,y1,x2,y2,length;
        Scanner scanner=new Scanner(System.in);
        System.out.print("输入第一个点：");
        x1=scanner.nextDouble();
        y1=scanner.nextDouble();
        System.out.print("输入第二个点：");
        x2=scanner.nextDouble();
        y2=scanner.nextDouble();
        length=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2),0.5);
        System.out.println("俩点之间的距离："+length);
    }
}
