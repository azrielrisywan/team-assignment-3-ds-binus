import java.util.Scanner;

public class Soal1Case1 {
    static final int MAX = 100;
    static char[] stack = new char[MAX];
    static int top = -1;

    static void push(char c) {
        stack[++top] = c;
    }

    static char pop() {
        return stack[top--];
    }

    static char peek() {
        return stack[top];
    }

    static boolean isEmpty() {
        return top == -1;
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    static boolean isValidInfix(String expr) {
        int brackets = 0;
        int len = expr.length();

        if (len == 0) return false;
        if (isOperator(expr.charAt(0)) || isOperator(expr.charAt(len - 1))) return false;

        for (int i = 0; i < len; i++) {
            char c = expr.charAt(i);
            if (c == '(') brackets++;
            else if (c == ')') brackets--;
            else if (isOperator(c)) {
                if (i + 1 < len && isOperator(expr.charAt(i + 1))) return false;
            }
            if (brackets < 0) return false;
        }

        return brackets == 0;
    }

    static String infixToPostfix(String infix) {
        top = -1;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                output.append(c);
            } else if (c == '(') {
                push(c);
            } else if (c == ')') {
                while (!isEmpty() && peek() != '(')
                    output.append(pop());
                pop(); // pop '('
            } else if (isOperator(c)) {
                while (!isEmpty() && precedence(peek()) >= precedence(c))
                    output.append(pop());
                push(c);
            }
        }

        while (!isEmpty()) {
            output.append(pop());
        }

        return output.toString();
    }

    static String reverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }

    static String swapParentheses(String expr) {
        StringBuilder swapped = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(') swapped.append(')');
            else if (c == ')') swapped.append('(');
            else swapped.append(c);
        }
        return swapped.toString();
    }

    static String infixToPrefix(String infix) {
        String reversed = reverse(infix);
        String swapped = swapParentheses(reversed);
        String postfix = infixToPostfix(swapped);
        return reverse(postfix);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan ekspresi infix (tanpa spasi): ");
        String infix = sc.nextLine();

        if (!isValidInfix(infix)) {
            System.out.println("Ekspresi infix tidak valid.");
            return;
        }

        String postfix = infixToPostfix(infix);
        String prefix = infixToPrefix(infix);

        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + prefix);
    }
}
