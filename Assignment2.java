import java.util.Scanner;
public class Assignment2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_GREEN_BOLD = "\033[32;1m";
        final String COLOR_YELLOW_BOLD = "\033[33;1m";
        final String RESET = "\033[30;0m";

 
        String name;
        int age;
        String subject1;
        String subject2;
        String subject3;
        double marks1;
        double marks2;
        double marks3;

        final String ERROR_MSG = String
                                .format("%s%s%s \n", COLOR_RED_BOLD, "%s", RESET);
        
        app:{
            System.out.print("Enter your name: ");
            name = scanner.nextLine().strip();

            if (name.length() == 0) {
                System.out.printf(ERROR_MSG, "Name can't be empty");
                break app;
            }
            System.out.print("Enter your age: ");
            age = scanner.nextInt();
            scanner.nextLine();
            // scanner.skip(System.lineSeparator()); // \n, \r\n

            if (age < 10 || age > 18) {
                System.out.printf(ERROR_MSG, "Invalid age");
                break app;
            }
            System.out.print("Enter subject1: ");
            subject1 = scanner.nextLine().strip();

            if (subject1.isBlank()){
                System.out.printf(ERROR_MSG, "Subject 1 can't be empty");
                break app;
            } else if (!subject1.startsWith("SE-")){
                System.out.printf(ERROR_MSG,"Invalid subject 1");
                break app;
            }
            System.out.printf("Enter marks for %s: ", subject1);
            marks1 = scanner.nextDouble();
            scanner.nextLine();

            if (marks1 < 0 || marks1 >100) {
                System.out.printf(ERROR_MSG, "Invalid marks");
                break app;
            }
            /* Subject 2 */
            System.out.print("Enter subject2: ");
            subject2 = scanner.nextLine().strip();

            if (subject2.isBlank()){
                System.out.printf(ERROR_MSG, "Subject 2 can't be empty");
                break app;
            } else if (!subject2.startsWith("SE-")){
                System.out.printf(ERROR_MSG,"Invalid subject 2");
                break app;
            } else if (subject2.equals(subject1)) {
                System.out.printf(ERROR_MSG,"Invalid subject 2"); //
            }
            System.out.printf("Enter marks for %s: ", subject2);
            marks2 = scanner.nextDouble();
            scanner.nextLine();

            if (marks2 < 0 || marks2 >100) {
                System.out.printf(ERROR_MSG, "Invalid marks");
                break app;
            }
            System.out.print("Enter subject3: ");
            subject3 = scanner.nextLine().strip();

            if (subject3.isBlank()){
                System.out.printf(ERROR_MSG, "Subject 3 can't be empty");
                break app;
            } else if (!subject3.startsWith("SE-")){
                System.out.printf(ERROR_MSG,"Invalid subject 3");
                break app;
            } else if (subject3.equals(subject1) || subject3.equals(subject2)) {
                System.out.printf(ERROR_MSG,"Invalid subject 3"); //
            }
            System.out.printf("Enter marks for %s: ", subject3);
            marks3 = scanner.nextDouble();
            scanner.nextLine();

            if (marks3 < 0 || marks3 >100) {
                System.out.printf(ERROR_MSG, "Invalid marks");
                break app;
            }
            double total = marks1 + marks2 + marks3;
        double avg = total / 3;

        String status;
        String subject1Status;
        String subject2Status;
        String subject3Status;

        final String DISTINGUISHED_PASS = COLOR_GREEN_BOLD + "DISTINGUISHED PASS (DP)" + RESET;
        final String CREDIT_PASS = COLOR_YELLOW_BOLD + "CREDIT PASS (CP)" + RESET;
        final String PASS = COLOR_BLUE_BOLD + "PASS (P)" + RESET;
        final String FAIL = COLOR_RED_BOLD + "FAIL (F)" + RESET;

        // Determine the overall status
        if (avg >= 75) status = DISTINGUISHED_PASS;  // without block
        else if (avg >= 65) status = CREDIT_PASS;
        else if (avg >= 55) status = PASS;
        else status = FAIL; // without this line, status not initialized..

        // if (avg >= 75) {
        //     status = "Distinguished Pass (DP)";
        // }else if (avg >= 65) {
        //     status = "Credit Pass (CP)";
        // }else if (avg >= 55) {
        //     status = "Pass (P)";
        // }else {
        //     status = "Fail (F)";
        // }           // with block

        // Subject1 status
        if (marks1 >= 75) subject1Status = DISTINGUISHED_PASS;  // without block
        else if (marks1 >= 65) subject1Status = CREDIT_PASS;
        else if (marks1 >= 55) subject1Status = PASS;
        else subject1Status = FAIL;

        // Subject2 status
        if (marks2 >= 75) subject2Status = DISTINGUISHED_PASS;  // without block
        else if (marks2 >= 65) subject2Status = CREDIT_PASS;
        else if (marks2 >= 55) subject2Status = PASS;
        else subject2Status = FAIL;

        // Subject3 status
        if (marks3 >= 75) subject3Status = DISTINGUISHED_PASS;  // without block
        else if (marks3 >= 65) subject3Status = CREDIT_PASS;
        else if (marks3 >= 55) subject3Status = PASS;
        else subject3Status = FAIL;

        subject1 = String.format("SE-%03d", 
                                Integer.valueOf(subject1.substring(3))); ///should extract

        subject2 = String.format("SE-%03d", 
                                Integer.valueOf(subject2.substring(3)));

        subject3 = String.format("SE-%03d", 
                                Integer.valueOf(subject3.substring(3)));


        name = String.format("%s%s%s", COLOR_BLUE_BOLD, name.toUpperCase(), RESET);

        // Let's generate the table
        System.out.println("+".concat("-".repeat(50)).concat("+"));
        System.out.printf("|%-10s: %-52s| \n", "Name", name);
        System.out.printf("|%-10s: %-38s| \n", "Age", age + " years old");
        System.out.printf("|%-10s: %-52s| \n", "Status", status);
        System.out.printf("|%-10s: %-38s| \n", "Total",
                                        String.format("%.2f", total));
        System.out.printf("|%-10s: %-38s| \n", "Average",
                                        String.format("%.2f", avg).concat("%"));
        
        final String LINE = "+".concat("-".repeat(10)).concat("+")
                            .concat("-".repeat(12)).concat("+")
                            .concat("-".repeat(26)).concat("+");

        System.out.println(LINE);
        System.out.printf("|%-10s|%-12s|%-26s| \n","Subject", "Marks", "Grade");
        System.out.println(LINE);
        System.out.printf("|%-10s|%-12.2f|%-40s| \n", subject1, marks1, subject1Status);
        System.out.printf("|%-10s|%-12.2f|%-40s| \n", subject2, marks2, subject2Status);
        System.out.printf("|%-10s|%-12.2f|%-40s| \n", subject3, marks3, subject3Status);
        System.out.println("+".concat("-".repeat(50)).concat("+"));

        }

    }  
}
