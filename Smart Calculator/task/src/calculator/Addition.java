package calculator;

import java.util.Scanner;

public class Addition {
    Scanner scn;
    int firstAddend;
    int secondAddend;

    Addition(Scanner scn) {
        this.scn = scn;
    }

    public void readAddends() {
        String stringAddends = scn.nextLine();
        int sum = 0;
        String[] arrayOfAddends = stringAddends.split(" ");
        if (arrayOfAddends.length > 1) {
            sum = Integer.parseInt(arrayOfAddends[0]);
        }
        while (!stringAddends.equals("/exit")) {
            if (stringAddends.contains(" ")) {
                //String[] arrayOfAddends = stringAddends.split(" ");
                /*for (String member : arrayOfAddends) {
                    sum += Integer.parseInt(member);
                }*/
                for (int i = 1; i < arrayOfAddends.length; i += 2) {
                    if (arrayOfAddends[i].contains("+")) {
                        sum += Integer.parseInt(arrayOfAddends[i + 1]);
                    } else {
                        if (arrayOfAddends[i].length()%2 == 0) {
                            sum += Integer.parseInt(arrayOfAddends[i + 1]);
                        } else {
                            sum = sum - Integer.parseInt(arrayOfAddends[i + 1]);
                        }
                    }
                }

            } else if (stringAddends.equals("")) {
                stringAddends = scn.nextLine();
                arrayOfAddends = stringAddends.split(" ");
                if (arrayOfAddends.length > 1) {
                    sum = Integer.parseInt(arrayOfAddends[0]);
                }
                continue;
            } else if (stringAddends.equals("/help")) {
                System.out.println("The program calculates the sum of numbers");
            } else {
                sum = Integer.parseInt(stringAddends);

            }

            System.out.println(sum);
            stringAddends = scn.nextLine();
            arrayOfAddends = stringAddends.split(" ");
            if (arrayOfAddends.length > 1) {
                sum = Integer.parseInt(arrayOfAddends[0]);
            }
        }
        System.out.println("Bye!");
    }


    public void add() {
        readAddends();
        System.out.println(firstAddend + secondAddend);
    }


}
