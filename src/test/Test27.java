package test;

import java.util.Scanner;

public class Test27 {
    public static void main(String[] args) {
        int min;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入一个分钟数：");
        min=scanner.nextInt();
        int years=min/365/(60*24);
        int days=(min-years*365*60*24)/(60*24);
        System.out.println(min+"分钟大约是"+years+"年，"+days+"天" );
    }
}
