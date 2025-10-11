

import java.sql.*;
import java.util.Scanner;


public class HotelReservationSystem {
     private static final String url="jdbc:mysql://localhost:3306/hotel_db";
     private static final String username="root";
     private static final String password="10122001Am#";

    public static void main(String[] args) throws ClosedSelectorException, SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver loaded Successfully!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection=DriverManager.getConnection(url, username, password);
//            System.out.println("Connection Done!");
            while(true){
                System.out.println();
                System.out.println("HOTEL RESERVATION SYSTEM ");
                Scanner scanner=new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservations");
                System.out.println("5. Delete Reservations");
                System.out.println("0. Exit");
                System.out.println("Choose an option : ");
                int choice=scanner.nextInt();
                switch (choice){
                    case 1:
                        reserveRoom(connection, scanner);
                        break;

                    default:
                        System.out.println("Invalid choice. Try again!");

                }

            }

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
//        }catch (InterruptedException e){
//            throw new RuntimeException(e);
        }
    }
    private static void reserveRoom(Connection connection,Scanner scanner){
        System.out.print("Enter guest name : ");
        String guestName=scanner.next();
        scanner.nextLine();
        System.out.println("Enter room number : ");
        int roomNumber=scanner.nextInt();
        System.out.println("Enter contact number");
        int contactNumber=scanner.nextInt();

        String sql="insert into reservations(guest_name, room_number, contact_number) " +
                "values('" + guestName+"', " + roomNumber + ", '" + contactNumber + "')";

        try(Statement statement=connection.createStatement()){
            int affectedRows=statement.executeUpdate(sql);

            if(affectedRows>0){
                System.out.println("Reservation Succesfull!");
            }else{
                System.out.println("Reservation failed!");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


