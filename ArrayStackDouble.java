public class ArrayStackDouble {

  private double[] stack;
  private int top;


  public ArrayStackDouble() {
    stack = new double[100];
    top = -1;
  }

  public void push(double value) {
    if (top == stack.length - 1) {
      throw new StackOverflowError("Stack overflow");
    }
    stack[++top] = value;
  }

  public double pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return stack[top--];
  }

  public double peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return stack[top];
  }

  public boolean isEmpty() {
    return top == -1;
  }
}
