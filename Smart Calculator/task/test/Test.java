import calculator.Main;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.TestCase;
import org.hyperskill.hstest.testing.TestedProgram;

import java.util.Arrays;
import java.util.List;

public class Test extends StageTest<String> {
    @Override
    public List<TestCase<String>> generate() {
        return Arrays.asList(
                new TestCase<String>().setDynamicTesting(() -> {

                    TestedProgram main = new TestedProgram(Main.class);

                    // The base test suit that checks if the program correctly responses to the commands and can stop
                    main.start();

                    // test of /help
                    String output = main.execute("/help").trim();
                    if (output.length() < 4) {
                        return CheckResult.wrong("It seems like there was no any \"help\" message.");
                    }

                    // input empty string
                    output = main.execute("");
                    if (output.length() != 0) {
                        return CheckResult.wrong("Incorrect response to an empty string. " +
                                "The program should not print anything.");
                    }

                    // test of /exit
                    output = main.execute("/exit").trim().toLowerCase();
                    if (!output.startsWith("bye")) {
                        return CheckResult.wrong("Your program didn't print \"bye\" after entering \"/exit\".");
                    }

                    return new CheckResult(main.isFinished(), "Your program should exit after entering \"/exit\".");
                }),
                new TestCase<String>().setDynamicTesting(() -> {
                    TestedProgram main = new TestedProgram(Main.class);

                    // The test suit that checks functionality of the previous steps
                    main.start();

                    // sum of positive numbers
                    String output = main.execute("7 + 1 + 4").trim();
                    if (!output.equals("12")) {
                        return CheckResult.wrong("The program cannot sum more than two numbers.");
                    }

                    // sum mixed numbers & negative answer
                    output = main.execute("23 - 17 - 13").trim();
                    if (!output.equals("-7")) {
                        return CheckResult.wrong("Incorrect sum of positive and negative numbers.");
                    }

                    // testing a big amount of numbers
                    output = main.execute("33 + 21 + 11 + 49 - 32 - 9 + 1 - 80 + 4").trim();
                    if (!output.equals("-2")) {
                        return CheckResult.wrong("The program cannot process a large number of numbers.");
                    }

                    // input one number
                    output = main.execute("101").trim();
                    if (!output.equals("101")) {
                        return CheckResult.wrong("The program printed not the same number that was entered " +
                                "(when one number is entered it is a valid expression).");
                    }

                    // input one negative number
                    output = main.execute("-302").trim();
                    if (!output.equals("-302")) {
                        return CheckResult.wrong("The program printed not the same number that was entered.");
                    }

                    // input empty string
                    output = main.execute("");
                    if (output.length() != 0) {
                        return CheckResult.wrong("Incorrect response to an empty string. " +
                                "The program should not print anything.");
                    }

                    // the sum of the numbers is zero
                    output = main.execute("10 - 7 - 3").trim();
                    if (!output.equals("0")) {
                        return CheckResult.wrong("The problem when sum is equal to 0 has occurred.");
                    }

                    // test of multiple operations
                    output = main.execute("5 --- 2 ++++++ 4 -- 2 ---- 1").trim();
                    if (!output.equals("10")) {
                        return CheckResult.wrong("The program cannot process multiple operations with several operators.");
                    }

                    // test of /exit
                    output = main.execute("/exit").trim().toLowerCase();
                    if (!output.startsWith("bye")) {
                        return CheckResult.wrong("Your program didn't print \"bye\" after entering \"/exit\".");
                    }

                    return new CheckResult(main.isFinished(), "Your program should exit after entering \"/exit\".");
                }),
                new TestCase<String>().setDynamicTesting(() -> {
                    TestedProgram main = new TestedProgram(Main.class);

                    // A set of positive tests for this step
                    main.start();

                    // tests of invalid expressions
                    String output = main.execute("123+").trim().toLowerCase();
                    if (!output.startsWith("invalid")) {
                        return CheckResult.wrong("The program cannot process an invalid expression.");
                    }

                    output = main.execute("321-").trim().toLowerCase();
                    if (!output.startsWith("invalid")) {
                        return CheckResult.wrong("The program cannot process an invalid expression.");
                    }

                    // input one number with plus in front of it
                    output = main.execute("+7").trim();
                    if (!output.equals("7")) {
                        return CheckResult.wrong("The program not correctly processes useless plus sign.");
                    }

                    // test of /exit
                    output = main.execute("/exit").trim().toLowerCase();
                    if (!output.startsWith("bye")) {
                        return CheckResult.wrong("Your program didn't print \"bye\" after entering \"/exit\".");
                    }

                    return new CheckResult(main.isFinished(), "Your program should exit after entering \"/exit\".");
                }),
                new TestCase<String>().setDynamicTesting(() -> {
                    TestedProgram main = new TestedProgram(Main.class);

                    // A set of negative tests for this step
                    main.start();

                    // test of entering not numbers
                    String output = main.execute("abc").trim().toLowerCase();
                    if (!output.startsWith("invalid")) {
                        return CheckResult.wrong("The program should print \"Invalid expression\" " +
                                "when not a numbers are entered");
                    }

                    output = main.execute("one + two + three").trim().toLowerCase();
                    if (!output.startsWith("invalid")) {
                        return CheckResult.wrong("The program should print \"Invalid expression\" " +
                                "when not a numbers are entered.");
                    }

                    // test of a nonexistent command
                    output = main.execute("/go").trim().toLowerCase();
                    if (!output.startsWith("unknown")) {
                        return CheckResult.wrong("The program should print \"Unknown command\" " +
                                "when a nonexistent command is entered.");
                    }

                    // test of /exit
                    output = main.execute("/exit").trim().toLowerCase();
                    if (!output.startsWith("bye")) {
                        return CheckResult.wrong("Your program didn't print \"bye\" after entering \"/exit\".");
                    }

                    return new CheckResult(main.isFinished(), "Your program should exit after entering \"/exit\".");
                })
        );
    }
}
