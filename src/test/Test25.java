package test;

import java.util.Scanner;

public class Test25 {
    public static void main(String[] args) {
        double a,b;
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入费用与费率");
        a=scan.nextInt();
        b=scan.nextInt();
        System.out.println("总费用如下="+(a*b/100+a));
    }
}
