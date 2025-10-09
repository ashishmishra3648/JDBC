public class throws_keyword {
    public static void division(int dividend, int divisor) throws ArithmeticException{
        System.out.println("The answer is : "+dividend/divisor);
    }
    public static void main(String[] args) {
        division(10,0);

    }
}
