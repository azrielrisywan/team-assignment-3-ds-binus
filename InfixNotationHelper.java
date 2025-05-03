public class InfixNotationHelper {

  public static boolean isValidInfix(String expr) {
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

  public static String infixToPostfix(String infix) {
    ArrayStackChar stack = new ArrayStackChar();
    StringBuilder output = new StringBuilder();

    for (int i = 0; i < infix.length(); i++) {
      char c = infix.charAt(i);

      if (Character.isDigit(c)) {
        output.append(c);
      } else if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        while (!stack.isEmpty() && stack.peek() != '(')
          output.append(stack.pop());
        stack.pop(); // pop '('
      } else if (isOperator(c)) {
        while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c))
          output.append(stack.pop());
        stack.push(c);
      }
    }

    while (!stack.isEmpty()) {
      output.append(stack.pop());
    }

    return output.toString();
  }

  private static boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
  }

  private static int precedence(char op) {
    if (op == '+' || op == '-') return 1;
    if (op == '*' || op == '/') return 2;
    return 0;
  }

  public static String infixToPrefix(String infix) {
    String reversed = reverse(infix);
    String swapped = swapParentheses(reversed);
    String postfix = infixToPostfix(swapped);
    return reverse(postfix);
  }

  private static String reverse(String s) {
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

  private static String swapParentheses(String expr) {
    StringBuilder swapped = new StringBuilder();
    for (int i = 0; i < expr.length(); i++) {
      char c = expr.charAt(i);
      if (c == '(') swapped.append(')');
      else if (c == ')') swapped.append('(');
      else swapped.append(c);
    }
    return swapped.toString();
  }

  public static double evaluatePrefix(String exprsn) {
    ArrayStackDouble Stack = new ArrayStackDouble();

    for (int j = exprsn.length() - 1; j >= 0; j--) {

      if (Character.isDigit(exprsn.charAt(j))) {
        Stack.push((double)exprsn.charAt(j) - 48);
      } else {

        double o1 = Stack.peek();
        Stack.pop();
        double o2 = Stack.peek();
        Stack.pop();

        calculateNumbers(exprsn.charAt(j), Stack, o1, o2);
      }
    }

    return Stack.peek();
  }

  public static double evaluatePostfix(String exprsn) {
    char[] arr = exprsn.toCharArray();
    ArrayStackDouble stack = new ArrayStackDouble();

    for (char token : arr) {

      if (Character.isDigit(token)) {
        stack.push(Double.parseDouble(String.valueOf(token)));
      } else {
        double val1 = stack.pop();
        double val2 = stack.pop();

        calculateNumbers(token, stack, val2, val1);
      }
    }
    return stack.pop();
  }

  private static void calculateNumbers(char exprsn, ArrayStackDouble Stack, double o1, double o2) {
    switch (exprsn) {
      case '+':
        Stack.push(o1 + o2);
        break;
      case '-':
        Stack.push(o1 - o2);
        break;
      case '*':
        Stack.push(o1 * o2);
        break;
      case '/':
        Stack.push(o1 / o2);
        break;
    }
  }
}
