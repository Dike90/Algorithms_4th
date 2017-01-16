package Basement;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by DK on 2017/1/10.
 */
public class Dijkstra {
    public static void main(String[] args)
    {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        Scanner sc = new Scanner(System.in);

        while ( sc.hasNext() )
        {
            // 读取字符，如果是运算符，就压入运算符栈
            String s = sc.next();


            if (s.equals("(")) ;
            else if(s.equals("+"))   ops.push(s);
            else if(s.equals("-"))   ops.push(s);
            else if(s.equals("*"))   ops.push(s);
            else if(s.equals("/"))   ops.push(s);
            else if (s.equals("sqrt"))  ops.push(s);
            else if (s.equals(")")) //如果遇到右括号就把运算符和操作符弹出，计算结果并压入数值栈
            {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+"))         v = vals.pop() + v;
                else if (op.equals("-"))    v = vals.pop() - v;
                else if (op.equals("*"))    v = vals.pop() * v;
                else if (op.equals("/"))    v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }//如果既不是运算符也不是括号，就当做double压入数值栈
            else vals.push(Double.parseDouble(s));



        }

        System.out.println(vals.pop());
    }
}
