//Multiple catch blocks:

import java.lang.reflect.Array;

public class ExceptionsDemo2 {
    public static void main(String[] args) {
        int arr[]=new int[5];
        try {
            arr[6] = 10/0;
        }
        //METHOD 1:
//        catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }
//        catch (ArrayIndexOutOfBoundsException e){
//            System.out.println(e.getMessage());
//        }

        //METHOD 2:
        catch (ArithmeticException |ArrayIndexOutOfBoundsException m){
            System.out.println(m.getMessage());
        }

    }
}
