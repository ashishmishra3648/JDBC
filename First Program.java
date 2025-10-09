import java.sql.*;
public class First_Program {
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="10122001Am#";
        String query="select * from employee;";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con=DriverManager.getConnection(url, username, password);
            // Connection is one Interface which is used to established connection btw
            // Java program and Database.This Interface has DriverManager class.
            //This class has one method getConnection which takes three parameters (url, username, password)
            // con is instance of Connection interface.
            System.out.println("Connection Established Successfully!");

            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                double salary=rs.getDouble("salary");
                System.out.println("============================================================================");
                System.out.println("Id : "+id+"|| Name : "+name+"|| Job Title : "+job_title+"|| Salary : "+salary);
            }
            rs.close();
            stm.close();
            con.close();
            System.out.println("Connection Closed Successfully!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
