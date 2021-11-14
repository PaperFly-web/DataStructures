package test;

import java.util.Scanner;

public class Test221 {
    public static void main(String[] args) {
        double money,rate,sum=0;
        int years;
        Scanner scanner=new Scanner(System.in);
        System.out.print("钱的数量：");
        money=scanner.nextDouble();
        System.out.print("年化利率：");
        rate=scanner.nextDouble();
        System.out.print("存入几年：");
        years=scanner.nextInt();
        sum=money;
        for (int i=0;i<years*12;i++){
            sum=(sum)*(rate/12+1);
        }
        System.out.println("最后的钱："+sum);
    }
}
