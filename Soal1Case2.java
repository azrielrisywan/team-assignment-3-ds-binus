import java.util.Scanner;

public class Soal1Case2 {
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.print("Masukkan ekspresi infix (tanpa spasi): ");
      String infix = sc.nextLine();

      if (!InfixNotationHelper.isValidInfix(infix)) {
        System.out.println("Ekspresi infix tidak valid.");
        return;
      }

      String postfix = InfixNotationHelper.infixToPostfix(infix);
      String prefix = InfixNotationHelper.infixToPrefix(infix);

      System.out.println("Postfix : " + postfix);
      System.out.println("Prefix : " + prefix);
    }
}
