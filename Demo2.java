public class Demo2 {
    public static void main(String[] args) {
        String something = "   ";

        System.out.println(something.strip().length() == 0);
    
        //strip() + length ==0
        System.out.println(something.isBlank());

        //length() == 0
        System.out.println(something.isEmpty());

        //Hibernate Validator
    }
    
}
