import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here

        Scanner scn = new Scanner(System.in);
        String ipAddress = scn.nextLine();
        System.out.println(ipAddress.matches("(((1?[0-9]?[0-9])|(2[0-5][0-5]))\\.){3}(1?([0-9]?[0-9])|(2[0-5][0-5]))") ?
                "YES" : "NO");
    }
}