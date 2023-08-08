import java.util.Scanner;

public class Demo1 {
    private static final Scanner scanner = new Scanner (System.in);
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        
        label1: {
            if (name.length() == 0 || (name.strip()).length() == 0){
                System.out.println("\033[31mInvalid Name \033[39m");
                break label1;
            }
        
            else System.out.println("Enter your age: ");
            int age = scanner.nextInt();

        
            if ((age <= 10 & age >= 18)==false) {
                System.out.println("\033[31mInvalid Age \033[39m");
                break label1;
            }

            else System.out.println("Enter your subject");
            int subject1 = scanner.nextInt();

            if (subject1.strip()).length()==0 ) {
                System.out.println("\\033[31mInvalid Age \\033[39m");
            }
        }
            
            


    }
}