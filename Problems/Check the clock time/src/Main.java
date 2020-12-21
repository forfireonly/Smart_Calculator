import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([01][0-9]|2[0-3]):[012345][0-9]";
        //String regex = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]";
        //String regex = "([01]\\d|2[0-3]):[0-5]\\d";
        //String regex = "([01][0-9]|2[0-3]):[0-5]\\d";
        //String regex = "(2[0-3]|[01]\\d):[0-5]\\d";

        String time = scanner.nextLine();
        System.out.println(time.matches(regex) ? "YES" : "NO");
    }
}