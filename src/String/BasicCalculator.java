package String;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        System.out.println(calculator.calculate("-(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == ' ') {
                continue;
            } else if (curr == '+' || curr == '-') {
                if (i == 0 || s.charAt(i - 1) == '(' || s.charAt(i - 1) == '-') {
                    numbers.push(0);
                }
                while (!characters.isEmpty() && !numbers.isEmpty() && characters.peek() == '(' ) {
                    int n1 = numbers.pop();
                    int n2 = numbers.pop();
                    char ch = characters.pop();
                    int res = operation(n2, n1, ch);
                    numbers.push(res);
                }
                characters.push(curr);
            } else if (curr == '(') {
                characters.push(curr);
            } else if (curr == ')') {
                while (!characters.isEmpty() && !numbers.isEmpty() && characters.peek() != '(') {
                    int n1 = numbers.pop();
                    int n2 = numbers.isEmpty() ? 0 : numbers.pop();
                    char ch = characters.pop();
                    int res = operation(n2, n1, ch);
                    numbers.push(res);
                }
                if (!characters.isEmpty()) {
                    characters.pop();
                }
            }
            else{
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                numbers.push(num);
            }
        }
        while (!characters.isEmpty()) {
            int n1 = numbers.pop();
            int n2 = numbers.pop();
            char ch = characters.pop();
            int res = operation(n2, n1, ch);
            numbers.push(res);
        }
        return numbers.pop();
    }

    public static int operation(int n1, int n2, char ch) {
        if (ch == '+') return n1 + n2;
        return n1 - n2;
    }
}
