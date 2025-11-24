package JDBCDEMO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Flight {
	private static String url="jdbc:postgresql://localhost:5432/PASSENGER";
	private static String user="postgres";
	private static String pswd="123";
	private static Connection connection;
	public static void main(String[] args) {
		//1 STEP : LOADING & REGISTER DRIVER S/W
			try{Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded Successfully!!");
			}catch (ClassNotFoundException e) {
				System.out.println("Driver Loading Failed!");
			}
			
			//2 STEP : ESTABLISH CONNECTION
			try {
				connection=DriverManager.getConnection(url, user, pswd);
				System.out.println("Connnection Done !!!!!!!");
				
				
				connection.setAutoCommit(false);
				String sql="insert into passengerinfo values(104,'Pratik','BLR','CCU',23)";
				Statement stm=connection.createStatement();
				stm.execute(sql);
				System.out.println("sql executed");
				
				String sql1="insert into flightinfo values(4113,'INDIGO','BLR','CCU','8','12')";
				stm.execute(sql1);
				
				Savepoint savepoint=connection.setSavepoint();
				String sql2="insert into payment values(4113, 'Pratik', 5212)";
				stm.execute(sql2);
				if(Payment.isSuccess()) {
					
					System.out.println("sql1 is executed");
					System.out.println("sql2 is executed");
					connection.commit();
				}else {
					if(connection!=null) {
					connection.rollback(savepoint);
					connection.commit();
				}
					System.out.println("Payment failed");
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
					
					}catch (SQLException e) {
						e.printStackTrace();
					}
			}

}
}
