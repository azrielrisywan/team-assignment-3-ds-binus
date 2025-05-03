import java.util.Scanner;

public class Soal1Case3 {
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

      System.out.println("Postfix: " + postfix);
      System.out.println("Prefix: " + prefix);

      boolean exit = false;
      while (!exit) {
        System.out.println("Tentuhan pilihan kalkulasi : ");
        System.out.println("1. Postfix : " + postfix);
        System.out.println("2. Prefix : " + prefix);
        String option = sc.nextLine();
        switch (option) {
          case "1" :
            System.out.println("Hasil dari evalusi notasi postfix " + postfix + " adalah "
                + InfixNotationHelper.evaluatePostfix(postfix));
            exit = true;
            break;
          case "2" :
            System.out.println("Hasil dari prefix " + prefix + " adalah "
                + InfixNotationHelper.evaluatePrefix(prefix));
            exit = true;
            break;
          default :
            System.out.println("Pilihan tidak ditemukan!");
            break;
        }
      }
    }
}
