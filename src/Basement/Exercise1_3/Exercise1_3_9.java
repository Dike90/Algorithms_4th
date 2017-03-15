package Basement.Exercise1_3;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by DK on 2017/3/15.
 */
public class Exercise1_3_9 {
    public static void main(String [] args){
        Stack<String> op = new Stack<>();
        Stack<String> val = new Stack<>();
        String ops = "+-*/";

        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        String [] split_exp = expression.split(" ");
        for (int i = 0;  i< split_exp.length; i++){
            if( ops.contains(split_exp[i])){
                op.push(split_exp[i]);
            }
            else if (split_exp[i].equals(")")){  //遇到右括号，就弹出两个操作数和一个符号，并把它们当做一个操作数存起来。
                String temp_val2 = val.pop();
                String temp_op = op.pop();
                String temp_val1 = val.pop();
                String unit_op_val = "( " + temp_val1+" " + temp_op +" "+ temp_val2 + " )";
                val.push(unit_op_val);
            }
            else {
                val.push(split_exp[i]);
            }
        }
        System.out.println(val.pop());



    }

}
