package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        Runnable runnable=()->{
            while (true){
                System.out.println("你好！");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        while (true){
            System.out.println("我很好！");
        }
    }
}



