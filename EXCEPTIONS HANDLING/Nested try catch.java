//Nested try catch blocks:

public class ExceptionsDemo3 {
    public static void main(String[] args) {
        int arr[]=new int[5];
        try{
            System.out.println("This is first try block ");
            try{
                arr[6]=10/0;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
