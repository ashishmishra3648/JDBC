# Hotel Reservation System 🏨
Welcome to the Hotel Reservation System, a comprehensive Java-based application designed to streamline hotel booking operations. This system provides an efficient solution for managing reservations, guest information, and room allocations for hotels of all sizes.

## Features 🌟
Reserve a Room: Create new reservations with guest details, room numbers, and contact information

View Reservations: Display all current bookings with complete reservation details

Get Room Numbers: Quickly retrieve room numbers using reservation ID and guest name

Update Reservations: Modify existing reservation details effortlessly

Delete Reservations: Remove bookings when needed with simple operations

## Technology Stack 💻
Java - Core programming language

MySQL - Database management

JDBC - Database connectivity

MySQL Connector/J - Java database driver

## Installation & Setup 🚀
Prerequisites
Java Development Kit (JDK) 8 or higher

MySQL Database Server

MySQL Connector/J

## Configuration Steps
1. Clone the repository

bash

git clone https://github.com/your-username/Hotel-Reservation-System.git
cd Hotel-Reservation-System

2. Database Setup

sql:

CREATE DATABASE hotel_db;
USE hotel_db;

CREATE TABLE reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name VARCHAR(100) NOT NULL,
    room_number INT NOT NULL,
    contact_number VARCHAR(15) NOT NULL,
    reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

3. Configure Database Connection

Update the database credentials in HotelReservationSystem.java:

java
private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
private static final String username = "your_mysql_username";
private static final String password = "your_mysql_password";

4.Compile and Run

bash
javac HotelReservationSystem.java
java HotelReservationSystem

## Usage Guide 📋
Main Menu Options
1. Reserve a Room: Enter guest name, room number, and contact details to create a new reservation

2. View Reservations: Display all current reservations in a formatted table

3. Get Room Number: Find room number using reservation ID and guest name

4. Update Reservations: Modify existing reservation details

5. Delete Reservations: Remove specific reservations from the system

6. Exit: Gracefully exit the application

## Example Usage Flow
OUTPUT : 
HOTEL MANAGEMENT SYSTEM
1. Reserve a room
2. View Reservations
3. Get Room Number
4. Update Reservations
5. Delete Reservations
0. Exit
Choose an option: 1


## Database Schema 🗃️
The system uses a single table structure:

reservations
- reservation_id (INT, AUTO_INCREMENT, PRIMARY KEY)
- guest_name (VARCHAR(100))
- room_number (INT)
- contact_number (VARCHAR(15))
- reservation_date (TIMESTAMP, DEFAULT CURRENT_TIMESTAMP)

## Code Structure 🏗️
Output :
HotelReservationSystem/
├── HotelReservationSystem.java  # Main application file
├── README.md                    # Project documentation
└── database_setup.sql          # Database initialization script
Key Methods
- reserveRoom() - Handles new room bookings
- viewReservations() - Displays all reservations
- getRoomNumber() - Retrieves room information
- updateReservation() - Modifies existing bookings
- deleteReservation() - Removes reservations
- reservationExists() - Checks reservation validity

## Error Handling ⚠️
SQL exception handling for database operations

Input validation for user data

Reservation existence checks before updates/deletes

Graceful connection management

## Contributing 🤝
Contributions are welcome! Please feel free to submit pull requests for:

Bug fixes

New features

Code optimization

Documentation improvements

## Future Enhancements 🚧
Add room availability checking

Implement user authentication

Add billing and payment features

Create graphical user interface (GUI)

Add reporting and analytics

Support for multiple hotels

## Happy Hotel Managing! 🏨✨

Simplify your hotel operations with this efficient reservation system.
