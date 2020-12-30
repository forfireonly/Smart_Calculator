package calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Addition {
    Scanner scn;
    int firstAddend;
    int secondAddend;
    boolean input;
    HashMap<String, Integer> variables = new HashMap<String, Integer>();

    Addition(Scanner scn) {
        this.scn = scn;
    }


    public void readAddends() {
        String stringAddends = scn.nextLine().trim();
        int sum = 0;
        String[] arrayOfAddends = stringAddends.split(" ");
        if (arrayOfAddends[0].matches("[+-]*\\d*(?!^$)")) {
            sum = Integer.parseInt(arrayOfAddends[0]);
        } else if (arrayOfAddends[0].matches("[a-zA-Z]*")) {
            if (variables.containsKey(arrayOfAddends[0])) {
               sum =  variables.get(arrayOfAddends[0]);
            }
        }
        while (true) {
            if (stringAddends.matches("[+-]?\\d*(\\s[+|-]*\\s\\d*)*") ||
                    stringAddends.equals("/help") ||
                    stringAddends.equals("/exit") ||
                    stringAddends.equals("") ||
                    stringAddends.matches("[a-zA-Z]*\\s*=\\s*\\d*") ||
                    stringAddends.matches("[+-]?\\w*(\\s[+|-]*\\s\\w*)*") ||
                    stringAddends.matches("[a-zA-Z]*\\s*=\\s*[a-zA-Z]*")) {
                if (stringAddends.matches("[a-zA-Z]*\\s*=\\s*[a-zA-Z]*")) {
                    String[] varValue = stringAddends.split("\\s*=\\s*");
                    if (!variables.containsKey(varValue[1])) {
                        System.out.println("Unknown variable");
                        stringAddends = scn.nextLine();
                        arrayOfAddends = stringAddends.split("\\s+");
                        if ((arrayOfAddends.length > 1 || stringAddends.matches("[+-]*\\d*(?!^$)"))
                                && arrayOfAddends[0].matches("\\d")) {
                            sum = Integer.parseInt(arrayOfAddends[0]);
                        } else if (arrayOfAddends[0].matches("[a-zA-Z]*")) {
                            if (variables.containsKey(arrayOfAddends[0])) {
                                sum = variables.get(arrayOfAddends[0]);
                            }
                        }
                    } else {
                        int variable = 0;
                        if (variables.containsKey(varValue[1])) {
                            variable = variables.get(varValue[1]);
                            variables.put(varValue[0], variable);
                            //variables.remove(varValue[1], variable);
                        }
                        stringAddends = scn.nextLine();
                        arrayOfAddends = stringAddends.split("\\s+");
                        if ((arrayOfAddends.length > 1 || stringAddends.matches("[+-]*\\d*(?!^$)"))
                                && arrayOfAddends[0].matches("\\d")) {
                            sum = Integer.parseInt(arrayOfAddends[0]);
                        } else if (arrayOfAddends[0].matches("[a-zA-Z]*")) {
                            if (variables.containsKey(arrayOfAddends[0])) {
                                sum = variables.get(arrayOfAddends[0]);
                            }
                        }
                    }
                }
                if (stringAddends.matches("[a-zA-Z]*\\s*=\\s*\\d*")) {
                    String[] varValue = stringAddends.split("\\s*=\\s*");
                    variables.put(varValue[0], Integer.parseInt(varValue[1]));
                    stringAddends = scn.nextLine().trim();
                    arrayOfAddends = stringAddends.split("\\s+");
                    if ((arrayOfAddends.length > 1 || stringAddends.matches("[+-]*\\d*(?!^$)"))
                            && arrayOfAddends[0].matches("\\d")) {
                        sum = Integer.parseInt(arrayOfAddends[0]);
                    } else if (arrayOfAddends[0].matches("[a-zA-Z]*")) {
                        if (variables.containsKey(arrayOfAddends[0])) {
                            sum =  variables.get(arrayOfAddends[0]);
                        }
                    }
                }
                if (stringAddends.equals("/exit")) {
                    System.out.println("bye");
                    System.exit(0);
                }
                if (stringAddends.equals("/help")) {
                    System.out.println("Calculator");
                    stringAddends = scn.nextLine().trim();
                    arrayOfAddends = stringAddends.split(" ");
                    if (arrayOfAddends.length > 1 || stringAddends.matches("[+-]*\\d*(?!^$)")) {
                        sum = Integer.parseInt(arrayOfAddends[0]);
                    } else if (arrayOfAddends[0].matches("[a-zA-Z]*")) {
                        if (variables.containsKey(arrayOfAddends[0])) {
                            sum =  variables.get(arrayOfAddends[0]);
                        }
                    }
                }
                if (stringAddends.equals("")) {
                    stringAddends = scn.nextLine();
                    arrayOfAddends = stringAddends.split(" ");
                    if (arrayOfAddends.length > 1 || stringAddends.matches("[+-]*\\d*(?!^$)")) {
                        sum = Integer.parseInt(arrayOfAddends[0]);
                    } else if (arrayOfAddends[0].matches("[a-zA-Z]*")) {
                        if (variables.containsKey(arrayOfAddends[0])) {
                            sum =  variables.get(arrayOfAddends[0]);
                        }
                    }
                }
                /*if (stringAddends.matches("[+-]?\\d*(\\s[+|-]*\\s\\d*)*")) {
                    for (int i = 1; i < arrayOfAddends.length; i += 2) {
                        if (arrayOfAddends[i].contains("+")) {
                            sum += Integer.parseInt(arrayOfAddends[i + 1]);
                        } else if (arrayOfAddends[i].contains("-")){
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
                    } else if (arrayOfAddends[0].matches("[a-zA-Z]*")) {
                        if (variables.containsKey(arrayOfAddends[0])) {
                            sum =  variables.get(arrayOfAddends[0]);
                        }
                    }
    `                }*/
                if (stringAddends.matches("[+-]?\\w*(\\s[+|-]*\\s\\w*)*")) {
                    if (stringAddends.length() == 1 || arrayOfAddends.length == 1) {
                        if (variables.containsKey(stringAddends)) {
                            System.out.println(variables.get(stringAddends));
                        } else {
                            System.out.println("Unknown variable");
                        }
                        stringAddends = scn.nextLine().trim();
                        arrayOfAddends = stringAddends.split("\\s*=\\s*");
                        if (stringAddends.matches("[+-]*\\d*(?!^$)")) {
                            sum = Integer.parseInt(arrayOfAddends[0]);
                        } else if (arrayOfAddends[0].matches("[a-zA-Z]*")) {
                            if (variables.containsKey(arrayOfAddends[0])) {
                                sum =  variables.get(arrayOfAddends[0]);
                            }
                        }
                    } else {
                        int addend = 0;
                        for (int i = 1; i < arrayOfAddends.length; i += 2) {
                            if (arrayOfAddends[i].contains("+")) {
                                if (arrayOfAddends[i + 1].matches("[a-zA-Z]*")) {
                                    if (variables.containsKey(arrayOfAddends[i + 1])) {
                                        addend = variables.get(arrayOfAddends[i + 1]);
                                    } else {
                                        System.out.println("Unknown variable");
                                    }
                                } else {
                                    addend = Integer.parseInt(arrayOfAddends[i + 1]);
                                }
                                sum += addend;

                            } else {
                                if (arrayOfAddends[i].length() % 2 == 0) {
                                    if (arrayOfAddends[i + 1].matches("[a-zA-Z]*")) {
                                        if (variables.containsKey(arrayOfAddends[i + 1])) {
                                            addend = variables.get(arrayOfAddends[i + 1]);
                                        } else {
                                            System.out.println("Unknown variable");
                                        }
                                    } else {
                                        addend = Integer.parseInt(arrayOfAddends[i + 1]);
                                        System.out.println(addend);
                                    }
                                    sum += addend;
                                } else {
                                    if (arrayOfAddends[i + 1].matches("[a-zA-Z]*")) {
                                        if (variables.containsKey(arrayOfAddends[i + 1])) {
                                            addend = variables.get(arrayOfAddends[i + 1]);
                                        } else {
                                            System.out.println("Unknown variable");
                                        }
                                    } else {
                                        addend = Integer.parseInt(arrayOfAddends[i + 1]);
                                    }
                                    sum = sum - addend;
                                }
                            }
                        }
                        System.out.println(sum);
                        stringAddends = scn.nextLine();
                        arrayOfAddends = stringAddends.split(" ");
                        if ((arrayOfAddends.length > 1 || stringAddends.matches("[+-]*\\d*(?!^$)")) &&
                        !arrayOfAddends[0].matches("[a-zA-Z]*")) {
                            sum = Integer.parseInt(arrayOfAddends[0]);
                        } else if (arrayOfAddends[0].matches("[a-zA-Z]*")) {
                            if (variables.containsKey(arrayOfAddends[0])) {
                                sum =  variables.get(arrayOfAddends[0]);

                            }
                        }
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
                } else if (arrayOfAddends[0].matches("[a-zA-Z]*")) {
                    if (variables.containsKey(arrayOfAddends[0])) {
                        sum =  variables.get(arrayOfAddends[0]);
                    }
                }
            }
        }
    }
}