import java.util.Scanner;

public class throw_keyword {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your Age : ");
        int age=sc.nextInt();
        if(age<18){
            throw new RuntimeException("Sorry u can't vote!!!");
        }
        else{
            System.out.println("You are eligible to vote!!!");
        }
    }
}
