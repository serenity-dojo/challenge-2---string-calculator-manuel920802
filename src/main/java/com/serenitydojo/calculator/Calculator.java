package com.serenitydojo.calculator;

import java.util.Stack;

public class Calculator {

    public int evaluate(String expression) {
    int sum =0;
    int tempSum=0;
    int num=0;
    char lastOp = '+';
    for(int i = 0; i<expression.length(); i++){
        char c = expression.charAt(i);
     if(Character.isDigit(c)) num = num*10 + c - '0';
     if(i == expression.length() -1 || !Character.isDigit(c) && c!=' '){
         switch (lastOp){
             case '+':
                 sum+= tempSum;
                 tempSum = num;
                 break;
             case '-':
                 sum+= tempSum;
                 tempSum = -num;
                 break;
             case '*':
                 tempSum *= num;
                 break;
             case '/':
                 tempSum /= num;
                 break;
         }
         lastOp = c;
         num = 0;
        }
    }
    sum+=tempSum;
    return sum;
    }
}


// Solution using Stack

//  public int evaluate(String expression) {
//        int length;
//        if (expression==null || (length = expression.length()) ==0) return 0;
//        Stack<Integer> stack = new Stack<>();
//        int num =0;
//        char operator = '+';
//        for(int i=0;i<length;i++){
//            if(Character.isDigit(expression.charAt(i))){
//                num = num*10+expression.charAt(i) -'0';
//            }
//            if((!Character.isDigit(expression.charAt(i)) && ' '!=expression.charAt(i)) || i==length-1){
//                if(operator=='-'){
//                    stack.push(-num);
//                }
//                if(operator=='+'){
//                    stack.push(num);
//                }
//                if(operator=='*'){
//                    stack.push(stack.pop()*num);
//                }
//                if(operator=='/'){
//                    stack.push(stack.pop()/num);
//                }
//                operator = expression.charAt(i);
//                num=0;
//            }
//        }
//        int result = 0;
//        for(int i:stack){
//            result += i;
//        }
//        return result;
//    }