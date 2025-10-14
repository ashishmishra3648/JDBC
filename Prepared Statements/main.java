import java.sql.*;

public class PreparedStatements {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="10122001Am#";

        String query="select * from employee where id = ? and name=?";

        try{
           Class.forName("com.mysql.cj.jdbc.Driver") ;
            System.out.println("Driver Loaded Successfully!");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection connection= DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully!");

            PreparedStatement ps=connection.prepareStatement(query);
            ps.setInt(1,2);
            ps.setString(2,"MOhIt");

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String job_title=rs.getString("job_title");
                double salary=rs.getDouble("salary");
                System.out.println("============================================================================");
                System.out.println("Id : "+id+"|| Name : "+name+"|| Job Title : "+job_title+"|| Salary : "+salary);
            }
            rs.close();
            ps.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
