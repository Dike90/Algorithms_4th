package Basement.Exercise1_3;

import Basement.MyStack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by DK on 2017/2/7.
 */
public class Parentheses {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (pair(s))
            System.out.println("true");
        else
            System.out.println("false");
    }
    public static boolean pair(String str){

        Stack<String> stack = new Stack();   //Stack只能存对象？原始类型不能存？
        for (int i = 0; i < str.length(); i++) {
            String left_brackets = "([{<";
            String brackets = str.substring(i,i+1);
            if (left_brackets.contains(brackets))
                stack.push(brackets);
            else {
                if (stack.isEmpty())
                    return false;
                else if (!match(stack.pop(),brackets))
                    return false;
            }
        }

        return true;
    }
    public static boolean match(String left, String right){
        if (left.equals("(")  && right.equals(")")) return true;
        if (left.equals("{") && right.equals("}")) return true;
        if (left.equals("<") && right.equals(">")) return true;
        if (left.equals("[")&& right.equals("]")) return true;
        return false;
    }
}
