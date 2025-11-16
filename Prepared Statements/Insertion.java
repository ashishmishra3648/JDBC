import java.sql.*;
import java.util.Scanner;

public class PreparedStatementInsertion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "10122001Am#";

        String query = "insert into employee(id, name, job_title, salary) values(?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully!");
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Id : ");
            int id=sc.nextInt();
            sc.nextLine();  //<--- IMPORTANT LINE !!!!!!!!!!!
            System.out.print("Enter Name : ");
            String name=sc.nextLine();
            System.out.print("Enter Job_Title : ");
            String job_title= sc.nextLine();
            System.out.print("Enter Salary : ");
            double salary=sc.nextInt();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, job_title);
            ps.setDouble(4, salary);

            int rows=ps.executeUpdate();
            if(rows>0){
                System.out.println("Insertion Successfull!");
                System.out.println(rows+" row(s) affected.");
            }else{
                System.out.println("Insertion failed !");
            }




            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//
