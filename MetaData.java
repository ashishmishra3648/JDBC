package JDBCDEMO;

import java.io.BufferedOutputStream;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaData {
	
	

			private static String url="jdbc:postgresql://localhost:5432/school";
			private static String user="postgres";
			private static String pswd="123";
			
			
				public static void main(String[] args) {
				//1 STEP : LOADING & REGISTER DRIVER S/W
				try{Class.forName("org.postgresql.Driver");
				System.out.println("Driver Loaded Successfully!!");
				}catch (ClassNotFoundException e) {
					System.out.println("Driver Loading Failed!");
				}
				
				//2 STEP : ESTABLISH CONNECTION
				try {
					Connection connection=DriverManager.getConnection(url, user, pswd);
					System.out.println("Connnection Done !!!!!!!");
					DatabaseMetaData data=connection.getMetaData();
					System.out.println(data.getDriverName());
					System.out.println(data.getDriverVersion());
					
					
					
					
					String sql="select * from student";
					
					Statement stm=connection.createStatement();
					java.sql.ResultSet rs=stm.executeQuery(sql);
					ResultSetMetaData metaData=rs.getMetaData();
					System.out.println(metaData.getColumnName(1));
					System.out.println(metaData.getColumnType(1));
					while(rs.next()) {
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
					}
					
				  
					
					
					
					//5 STEP : CLOSING CONNECTION
					connection.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				}
			}




	 
	



















