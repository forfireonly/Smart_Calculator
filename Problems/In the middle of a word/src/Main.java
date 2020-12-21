import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        // write your code here
        Pattern pattern = Pattern.compile(part, Pattern.CASE_INSENSITIVE);
        String[] words = line.split(" ");
        boolean isMiddle = false;
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            matcher.region(1, word.length() - 1);
            if (matcher.find()) {
                isMiddle = true;
                break;
            }
        }
        System.out.println(isMiddle ? "YES" : "NO");

    }
}