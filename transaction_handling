import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class transaction_handling {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "10122001Am#";

        String withdrawQuery="update accounts set balance = balance - ? where account_number =?";
        String depositQuery="update accounts set balance = balance + ? where account_number =?";

        Connection connection = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();}
            try {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection successful!");

                connection.setAutoCommit(false); //This ensures that all the commits will be done manually

                try {
                    PreparedStatement withdrawStatement = connection.prepareStatement(withdrawQuery);
                    PreparedStatement depositStatement = connection.prepareStatement(depositQuery);

                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter the amount to be withdraw: ");
                    double withdraw_amt = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter the account number : ");
                    String withdraw_acc = sc.next();
                    System.out.println();
                    withdrawStatement.setDouble(1, withdraw_amt);
                    withdrawStatement.setString(2, withdraw_acc);

                    System.out.print("In which account you want? : ");
                    String deposit_acc = sc.next();
                    depositStatement.setDouble(1, withdraw_amt);
                    depositStatement.setString(2, deposit_acc);

                    int rowsAffectedWithdraw=withdrawStatement.executeUpdate();
                    int rowsAffectedDeposit=depositStatement.executeUpdate();

                    if(rowsAffectedWithdraw>0&&rowsAffectedDeposit>0){
                    connection.commit();
                        System.out.println("Transaction Successfull !!!!!!!!");
                    }else{
                        connection.rollback();
                        System.out.println("Transaction Failed!!!!!!");
                    }

                }catch (SQLException e1){

                    System.out.println(e1.getMessage());
                }




            }catch (SQLException e2) {
                System.out.println("Failed to connect to the database.");
                e2.printStackTrace();
            }
        }
    }



