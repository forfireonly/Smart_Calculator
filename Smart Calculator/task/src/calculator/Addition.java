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
        while (!stringAddends.equals("/exit")) {
            if (stringAddends.contains(" ")) {
                String[] arrayOfAddends = stringAddends.split(" ");
                firstAddend = Integer.parseInt(arrayOfAddends[0]);
                secondAddend = Integer.parseInt(arrayOfAddends[1]);
            } else if (stringAddends.equals("")) {
                stringAddends = scn.nextLine();
                continue;
            } else {
                firstAddend = Integer.parseInt(stringAddends);
                secondAddend = 0;
            }
            System.out.println(firstAddend + secondAddend);
            stringAddends = scn.nextLine();
        }
        System.out.println("Bye!");
    }


    public void add() {
        readAddends();
        System.out.println(firstAddend + secondAddend);
    }


}
