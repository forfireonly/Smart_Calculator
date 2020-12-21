import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);

        String password = scn.nextLine();
        //password = password + "_";

        //String passPattern = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{12,}";
        //String regex = "(?=^.{12,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

        /*System.out.println(password.length() > 12 && password.split("\\d").length > 1 &&
                password.split("[a-z]").length > 1 && password.split("[A-Z]").length > 1
                ? "YES" : "NO");*/

        System.out.println(password.length() >= 12 && password.matches(".*[a-z]+.*") &&
                password.matches(".*[A-Z]+.*") && password.matches(".*\\d+.*")
                ? "YES" : "NO");
    }
}