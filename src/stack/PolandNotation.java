package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {
        //1+((5+5)× 4)-5 => 转成 1 5 5 + 4 × + 5 –
        String expression = "2+3*5";
        List<String> list = toSuffixExpressionList(expression);
        System.out.println("后缀表达式：" + list);
        System.out.println(expression + "=" + calculate(list));
    }

    //将一个逆波兰表达式，转换成list集合
    public static List<String> getListByString(String expression) {
        String[] split = expression.split(" ");
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            strings.add(split[i]);
        }
        return strings;
    }

    //计算结果
    public static int calculate(List<String> list) {
        Stack stack = new Stack<>();
        int res = 0;
        for (String el : list) {
            //查看是不是一个数字
            if (el.matches("\\d+")) {
                stack.push(Integer.parseInt(el));
            } else {
                int num1 = (int) stack.pop();
                int num2 = (int) stack.pop();
                if (el.equals("+")) {
                    res = num1 + num2;
                } else if (el.equals("-")) {
                    res = num2 - num1;
                } else if (el.equals("x") || el.equals("*")) {
                    res = num2 * num1;
                } else if (el.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("【" + el + "】这个符号没有匹配到======");
                }
                stack.push(res);
            }
        }
        return (int) stack.pop();
    }


    //将字符转转换成中缀表达式集合
    public static List<String> toInfixExpressionList(String s) {
        if (s.length() == 0) {
            return null;
        }
        List<String> ls = new ArrayList<>();
        int index = 0;
        //临时保存数字，防止读取数字时后面还是数字
        String temSum = "";
        //用于判断在这之前是否读取到数字了
        boolean flag = false;
        while (true) {

            String s1 = s.substring(index, index + 1);
            //如果是一个数字
            if (s1.matches("\\d+")) {
                temSum = temSum + s1;
                flag = true;
            } else {
                if (flag) {//如果之前匹配到数字了，就把数字添加到集合中，并把temSum归空
                    ls.add(temSum);
                    temSum = "";
                    flag = false;
                }
                if (s1.equals("×") || s1.equals("x")) {
                    s1 = "*";
                }
                ls.add(s1);
            }
            index++;
            if (index >= s.length()) {
                break;
            }
        }
        if (flag) {//如果最后一次之前，也匹配到数字了，把数字添加到集合
            ls.add(temSum);
        }

        return ls;
    }

    //将字符转，转换成后缀表达式集合
    //(3+4)×5-6")
    public static List<String> toSuffixExpressionList(String experssion) {
        //先判断是否为空
        if (experssion.length() == 0) {
            return null;
        }
        //先把字符串转换成中缀表达式
        List<String> infixExpressionList = toInfixExpressionList(experssion);
        //初始化2个栈
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for (String s : infixExpressionList) {
            //如果是一个数字，就直接入栈s2
            if (s.matches("\\d+")) {
                s2.push(s);
            } else if (isOper(s)) {//如果是操作符
                // s1 为空,或者s1栈顶运算符为左括号“(” ，就直接入栈
                if (s1.isEmpty() || s1.peek().equals("(")) {
                    s1.push(s);
                } else {
                    while (true) {
                        //如果s1都为空了，就直接入栈s1
                        if (s1.isEmpty()) {
                            s1.push(s);
                            break;
                        }
                        int prority1 = prority(s1.peek());
                        int prority2 = prority(s);
                        //若优先级比栈顶运算符的高， 也将运算符压入 s1；
                        if (prority2 > prority1) {
                            s1.push(s);
                            break;
                        } else {
                            //否则， 将 s1 栈顶的运算符弹出并压入到 s2 中
                            s2.push(s1.pop());
                        }

                    }

                }
            } else {//如果是括号
                //如果是左括号“(” ， 则直接压入 s1
                if (s.equals("(")) {
                    s1.push(s);
                } else if (s.equals(")")) {
                    //. 如果是右括号“)” ， 则依次弹出 s1 栈顶的运算符
                    // 并压入 s2， 直到遇到左括号为止， 此时将这一对括号丢弃
                    while (true) {
                        String peek = s1.peek();
                        if (peek.equals("(")) {
                            s1.pop();
                            break;
                        }
                        s2.push(s1.pop());
                    }
                }
            }
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        ArrayList<String> strings = new ArrayList<>();
        //把s2逆序
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        while (!s1.isEmpty()) {
            strings.add(s1.pop());
        }
        return strings;
    }

    //判断操作符的优先级
    public static int prority(String ch) {
        int res = -1;
        switch (ch) {
            case "*":
            case "/":
                res = 1;
                break;

            case "-":
            case "+":
                res = 0;
                break;
            default:
                res = -1;
        }
        return res;
    }

    //判断是否是操作符
    public static boolean isOper(String ch) {


        return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/");

    }
}
