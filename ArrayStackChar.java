public class ArrayStackChar {

  private char[] stack;
  private int top;

  public ArrayStackChar() {
    stack = new char[100];
    top = -1;
  }

  public void push(char value) {
    if (top == stack.length - 1) {
      throw new StackOverflowError("Stack overflow");
    }
    stack[++top] = value;
  }

  public char pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return stack[top--];
  }

  public char peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return stack[top];
  }

  public boolean isEmpty() {
    return top == -1;
  }
}
