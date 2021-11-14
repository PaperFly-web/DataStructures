package test;

import java.util.Scanner;

public class Test26 {
    public static void main(String[] args) {
        int a;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入一个介于0-1000的整数：");
        a=scanner.nextInt();
        int sum=0;
        while (a!=0){
            sum+=a%10;
            a=a/10;
        }
        System.out.println("最后的结果："+sum);
    }
}
