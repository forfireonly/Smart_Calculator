package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        Addition newAddition = new Addition(scanner);
        newAddition.add();

    }
}
