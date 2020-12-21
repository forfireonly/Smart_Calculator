import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();
        String[] words = line.split("\\b");
        boolean isThree = false;
        Pattern pattern = Pattern.compile("[A-Za-z]{" + size + "}");

        // write your code here
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                isThree = true;
                break;
            }
        }
        System.out.println(isThree ? "YES" : "NO");

    }
}