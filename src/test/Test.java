package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class Test {
    public static void main(String[] args) {
        int a=-56;

        String str = Integer.toBinaryString(a);
        System.out.println(str);
    }
}
