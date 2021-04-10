package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class Test {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next=node2;
        Node tem=node2;
        tem=null;
        System.out.println(node1.next);

    }
}

class Node{
    int value;
    public Node(int value){
        this.value=value;
    }

    Node next;
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}