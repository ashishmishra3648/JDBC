import java.util.Scanner;
public class ExceptionsDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dividend : ");
        int dividend = sc.nextInt();
        System.out.print("Divisor : ");
        int divisor = sc.nextInt();
        try {
            int result = dividend / divisor;
            System.out.println("Your answer is : " + result);

        }catch(ArithmeticException e){
            // System.out.println(e.getMessage());
            System.out.println("Divisor can't be zero!!!");
        }
    }

}
