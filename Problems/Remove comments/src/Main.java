import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String codeWithComments = scanner.nextLine();

        // write your code here

        String digitRegex = "/\\*.*?\\*/";
        String digitRegex2 = "//.*";

        String result1 = codeWithComments.replaceAll(digitRegex, "");
        String result2 = result1.replaceAll(digitRegex2, "");

        System.out.println(result2);
    }
}