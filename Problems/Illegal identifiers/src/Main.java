import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfVariables = Integer.parseInt(scanner.nextLine());

        String regex = "(_[a-zA-Z0-9]+)|[a-zA-Z][a-zA-Z0-9_]*";

        //String regex = "[a-zA-Z]\\w*|_[a-zA-Z0-9]\\w*";
        //String regex = "([_][a-zA-Z0-9][a-zA-Z0-9_]*)|([a-zA-Z][a-zA-Z0-9_]*)";


        for (int i = 0; i < numberOfVariables; i++) {
            String identifier = scanner.nextLine();
            if (!identifier.matches(regex)) {
                System.out.println(identifier);
            }
        }
    }
}