package test;

import java.util.Scanner;

public class Test213 {
    public static void main(String[] args) {
        double money,sum=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入每月存入多少钱：");
        money=scanner.nextDouble();
        for (int i =0;i<6;i++){
            sum=(sum+money)*(0.05/12+1);

        }
        System.out.println("存入6个月后："+sum);
    }
}
