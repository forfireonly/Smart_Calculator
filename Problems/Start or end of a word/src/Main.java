import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();
        int count = 0;
        String[] words = line.split("\\b");
        Pattern pattern1 = Pattern.compile(part + "$", Pattern.CASE_INSENSITIVE);
        Pattern pattern2 = Pattern.compile("^" + part, Pattern.CASE_INSENSITIVE);

        // write your code here
        //Pattern pattern = Pattern.compile("^" + part + "$");
        //System.out.println(pattern);

        for (String word : words) {
            Matcher matcher1 = pattern1.matcher(word);
            Matcher matcher2 = pattern2.matcher(word);
            if (matcher1.find() || matcher2.find()) {
                count++;
            }
        }

        System.out.println(count > 0 ? "YES" : "NO");
    }
}