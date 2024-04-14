DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Hotels;
DROP TABLE IF EXISTS Bookings;
DROP TABLE IF EXISTS Rooms;

CREATE TABLE Users(
    email VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE Hotels (
    name VARCHAR(50),
    location VARCHAR(50),
    --total_rooms INT,    kannski ætti þetta frekar bara að vera aðgerð?
    --available_rooms INT,--
    PRIMARY KEY(name, location)
);

CREATE TABLE Bookings (
    bookingId INTEGER PRIMARY KEY,
    fromDate DATE,
    toDate DATE,
    roomNumber INT,
    userEmail VARCHAR(10) REFERENCES Users(email),
    hotelName VARCHAR(50),
    hotelLocation VARCHAR(50),
    FOREIGN KEY(hotelName, hotelLocation) REFERENCES Hotels(name,location),
    FOREIGN KEY(roomNumber, hotelName, hotelLocation) REFERENCES Rooms(roomNumber, hotelName, hotelLocation)
);

CREATE TABLE Rooms (
    roomNumber INT,
    hotelName VARCHAR(50),
    hotelLocation VARCHAR(50),
    roomType TEXT CHECK(roomType IN('SINGLE','DOUBLE','SUITE')),  -- því sqlite leyfir ekki enum
    FOREIGN KEY(hotelName, hotelLocation) REFERENCES Hotels(name, location),
    PRIMARY KEY (roomNumber, hotelName, hotelLocation)
);

