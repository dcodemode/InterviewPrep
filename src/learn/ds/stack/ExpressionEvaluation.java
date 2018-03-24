package learn.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/expression-evaluation/
 *
 */
public class ExpressionEvaluation {

    public static int calculate(String expression){
        Deque<Integer> numbers= new ArrayDeque<>();
        Deque<Character> operations= new ArrayDeque<>();

        char[] exp = expression.toCharArray();

        for (int i = 0; i < exp.length; i++) {
            if(exp[i] == ' '){
                continue;
            }
            if(exp[i] >= '0' && exp[i] <= '9'){
                StringBuffer sb = new StringBuffer();
                while(i < exp.length && exp[i] >= '0' && exp[i] <= '9'){
                    sb.append(exp[i]);
                    i++;
                }
                numbers.push(Integer.parseInt(sb.toString()));
            }else if(exp[i] =='('){
                operations.push(exp[i]);
            }else if(exp[i] == ')'){
                while(operations.peek()!='('){
                    numbers.push(addNumbers(numbers.pop(),numbers.pop(),operations.pop()));
                }
                operations.pop();
            }else if(exp[i] == '+' ||  exp[i] == '-' || exp[i] == '/' || exp[i] =='*'){
                while(!operations.isEmpty() && checkArthRules(operations.peek(),exp[i])){
                    numbers.push(addNumbers(numbers.pop(),numbers.pop(),operations.pop()));
                }
                operations.push(exp[i]);
            }
        }
        while (!operations.isEmpty()){
            numbers.push(addNumbers(numbers.pop(),numbers.pop(),operations.pop()));
        }
        return numbers.pop();
    }

    public static boolean checkArthRules(char opr1, char opr2){
        if (opr1 == '*' || opr1 == '/' || opr2 == '+' || opr2 == '-'){
            return false;
        }else if (opr1 == '(' && opr2 == ')') {
            return false;
        }else{
            return true;
        }
    }

    public static int addNumbers(int a, int b, char opr) {
        switch (opr) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Can't divide");
                }
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(calculate("100 * ( 2 + 12 ) / 14"));
    }
}
