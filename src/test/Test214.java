package test;

import java.util.Scanner;

public class Test214 {
    public static void main(String[] args) {
        double high,weight;
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入体重：");

        weight=scanner.nextDouble();
        System.out.print("请输入身高：");
        high=scanner.nextDouble();
        high=high*0.0254;
        weight=weight*0.45359237;
        System.out.println("BMI:"+weight/(high*high));
    }
}
