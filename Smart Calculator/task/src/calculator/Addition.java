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
        int i = 0;



        /*firstAddend = scn.nextInt();
        /*secondAddend = scn.nextInt();
        /*String stringAddends = scn.nextLine();
        String[] arrayOfAddends = stringAddends.split(" ");
        firstAddend  = Integer.parseInt(arrayOfAddends[0]);
        secondAddend = Integer.parseInt(arrayOfAddends[1]);*/
    }

    public void add() {
        readAddends();
        System.out.println(firstAddend + secondAddend);
    }


}
