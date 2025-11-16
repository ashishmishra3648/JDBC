import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//
import java.util.Scanner;

public class batch_processing {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "10122001Am#";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");

            try (
                    Connection connection = DriverManager.getConnection(url, user, password);
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "insert into employee(name, job_title, salary) values(?, ?, ?)");
                    Scanner scanner = new Scanner(System.in)
            ){
                System.out.println("Connection Established Successfully");
                connection.setAutoCommit(false);

                while (true) {
                    System.out.print("Name : ");
                    String name = scanner.nextLine();
                    System.out.print("Job Title : ");
                    String job_title = scanner.nextLine();
                    System.out.print("Salary :");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume the leftover newline

                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, job_title);
                    preparedStatement.setDouble(3, salary);

                    preparedStatement.addBatch();
                    System.out.print("Add more values Y/N :");
                    String decision = scanner.nextLine();
                    if (decision.equalsIgnoreCase("N")) {
                        break;
                    }
                }
                // Execute all batched inserts at once
                int[] batchResult = preparedStatement.executeBatch();
                connection.commit();
                System.out.println("Batch Executed Successfully!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
