import java.io.*;
import java.sql.*;

public class Image_Handling {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="10122001Am#";

        String image_path="C:\\Users\\LENOVO\\OneDrive\\Pictures\\wallpaperflare.com_wallpaper.jpg";
        String folder_path="C:\\Users\\LENOVO\\OneDrive\\Pictures\\";
        String query="insert into image_table(image_data) values(?)";
        String query1="select image_data from image_table where image_id=(?)";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established Successfully!");

            
            // FOR IMAGE ADDING TO DATABASE FROM FOLDER :
//            FileInputStream fileInputStream=new FileInputStream(image_path);
//            byte[] imageData=new byte[fileInputStream.available()];
//            fileInputStream.read(imageData);
//            PreparedStatement ps= con.prepareStatement(query);
//            ps.setBytes(1,imageData);
//            int affectedrows=ps.executeUpdate();
//            if(affectedrows>0){
//                System.out.println("Image Inserted !");
//            }else System.out.println("Image Not Inserted!");

            
            // FOR IMAGE ADDING TO FOLDER FROM DATABASE :
            PreparedStatement ps= con.prepareStatement(query1);
            ps.setInt(1,1);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                byte[] image_data=rs.getBytes("image_data");

                OutputStream outputStream=new FileOutputStream("C:\\Users\\LENOVO\\OneDrive\\Pictures\\ThomasShelby.jpg");
                outputStream.write(image_data);
                System.out.println("Image added to Folder!");
            }else System.out.println("Image Not Found!");




            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
