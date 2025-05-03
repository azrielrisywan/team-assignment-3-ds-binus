import java.util.Scanner;

public class Soal1Case1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan ekspresi infix (tanpa spasi): ");
        String infix = sc.nextLine();

        if (!InfixNotationHelper.isValidInfix(infix)) {
            System.out.println("Ekspresi infix tidak valid.");
            return;
        }
      System.out.println("Ekspresi infix valid.");
    }
}
