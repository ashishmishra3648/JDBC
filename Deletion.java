import java.sql.*;
public class Deletion {
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="10122001Am#";
        String query=("delete from employee where id=4;");

        //STEP 1: DRIVER LOADING
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
//
        try{
            //STEP 2: CONNECTION ESTABLISHMENT
            Connection con=DriverManager.getConnection(url, username, password);
            // Connection is one Interface which is used to established connection btw
            // Java program and Database.This Interface has DriverManager class.
            //This class has one method getConnection which takes three parameters (url, username, password)
            // con is instance of Connection interface.
            System.out.println("Connection Established Successfully!");

            //STEP 3: RUN SQL QUERY
            Statement stm=con.createStatement();

            int rows = stm.executeUpdate(query);
            if(rows!=0){
                System.out.println("Deletion Successful!");
                System.out.println(rows+" row(s) affected.");
            }else{
                System.out.println("Deletion failed!");
            }
            stm.close();
            con.close();
            System.out.println("Connection Closed Successfully!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
