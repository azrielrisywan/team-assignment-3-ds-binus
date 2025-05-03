import java.util.Scanner;

public class Soal1 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Masukkan ekspresi infix (tanpa spasi): ");
    String infix = sc.nextLine();

    /*
      Langkah 1 - User akan diminta inputan berupa notasi infix dengan validasi bahwa notasi yang
      dimasukkan haruslah notasi infix yang valid.
     */
    if (!InfixNotationHelper.isValidInfix(infix)) {
      System.out.println("Ekspresi infix tidak valid.");
      return;
    }

    /*
      Langkah 2 - Notasi yang sudah di input oleh user tadi di ubah ke notasi postfix dan prefix
      dengan menggunakan konsep stack.
     */
    String postfix = InfixNotationHelper.infixToPostfix(infix);
    String prefix = InfixNotationHelper.infixToPrefix(infix);

    System.out.println("Postfix: " + postfix);
    System.out.println("Prefix: " + prefix);

    boolean exit = false;
    while (!exit) {
      /*
        Langkah 3 - Setelah diterjemahkan menjadi notasi postfix dan prefix, notasi tersebut
        dihitung untuk mendapatkan hasil operasinya, juga menggunakan konsep stack.
       */
      System.out.println("Tentuhan pilihan kalkulasi : ");
      System.out.println("1. Postfix : " + postfix);
      System.out.println("2. Prefix : " + prefix);
      String option = sc.nextLine();

      /*
        Langkah 4- Tampilkan hasil operasi ke layer dengan Bahasa pemrograman java.
       */
      switch (option) {
        case "1":
          System.out.println("Hasil dari evalusi notasi postfix " + postfix + " adalah "
              + InfixNotationHelper.evaluatePostfix(postfix));
          exit = true;
          break;
        case "2":
          System.out.println("Hasil dari prefix " + prefix + " adalah "
              + InfixNotationHelper.evaluatePrefix(prefix));
          exit = true;
          break;
        default:
          System.out.println("Pilihan tidak ditemukan!");
          break;
      }
    }
  }
}
