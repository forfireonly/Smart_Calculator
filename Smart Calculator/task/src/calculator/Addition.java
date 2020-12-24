package calculator;

import java.util.Scanner;

public class Addition {
    Scanner scn;
    int firstAddend;
    int secondAddend;
    boolean input;

    Addition(Scanner scn) {
        this.scn = scn;
    }


    public void readAddends() {
        String stringAddends = scn.nextLine();
        int sum = 0;
        String[] arrayOfAddends = stringAddends.split(" ");
        if (arrayOfAddends[0].matches("[+-]*\\d*(?!^$)")) {
            sum = Integer.parseInt(arrayOfAddends[0]);
        }

        while (true) {
            if (stringAddends.matches("[+-]?\\d*(\\s[+|-]*\\s\\d*)*") ||
                    stringAddends.equals("/help") ||
                    stringAddends.equals("/exit") ||
                    stringAddends.equals("")) {
                if (stringAddends.equals("/exit")) {
                    System.out.println("bye");
                    System.exit(0);
                }
                if (stringAddends.equals("/help")) {
                    System.out.println("Calculator");
                    stringAddends = scn.nextLine();
                    arrayOfAddends = stringAddends.split(" ");
                    if (arrayOfAddends.length > 1 || stringAddends.matches("[+-]*\\d*(?!^$)")) {
                        sum = Integer.parseInt(arrayOfAddends[0]);
                    }
                }
                if (stringAddends.equals("")) {
                    stringAddends = scn.nextLine();
                    arrayOfAddends = stringAddends.split(" ");
                    if (arrayOfAddends.length > 1 || stringAddends.matches("[+-]*\\d*(?!^$)")) {
                        sum = Integer.parseInt(arrayOfAddends[0]);
                    }
                }
                if (stringAddends.matches("[+-]?\\d*(\\s[+|-]*\\s\\d*)*")) {
                    for (int i = 1; i < arrayOfAddends.length; i += 2) {
                        if (arrayOfAddends[i].contains("+")) {
                            sum += Integer.parseInt(arrayOfAddends[i + 1]);
                        } else {
                            if (arrayOfAddends[i].length() % 2 == 0) {
                                sum += Integer.parseInt(arrayOfAddends[i + 1]);
                            } else {
                                sum = sum - Integer.parseInt(arrayOfAddends[i + 1]);
                            }
                        }
                    }
                    System.out.println(sum);
                    stringAddends = scn.nextLine();
                    arrayOfAddends = stringAddends.split(" ");
                    if (arrayOfAddends.length > 1 || stringAddends.matches("[+-]*\\d*(?!^$)")) {
                        sum = Integer.parseInt(arrayOfAddends[0]);
                    }
                }
            } else {

                if (stringAddends.matches("/[a-zA-Z]*")) {
                    System.out.println("Unknown command");
                } else {
                    System.out.println("Invalid expression");
                }
                stringAddends = scn.nextLine();
                arrayOfAddends = stringAddends.split(" ");
                if (stringAddends.matches("[+-]*\\d*(?!^$)")) {
                    sum = Integer.parseInt(arrayOfAddends[0]);
                }
            }

        }
    }
}
