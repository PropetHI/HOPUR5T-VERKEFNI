INSERT INTO
    Users(email,name)
VALUES
    ('alx@netfang.com','Alexandra'),
    ('helg@netfang.com','Helga'),
    ('silj@netfang.com','Silja'),
    ('thrand@netfang.com','Þrándur');


INSERT INTO
    Hotels(name, location)
VALUES
    ('Fosshótel', 'Reykjavík'),
    ('Hotel KEA', 'Akureyri'),
    ('ION Adventure Hotel', 'Selfoss'),
    ('Edition', 'Reykjavík');

INSERT INTO
    Rooms(roomNumber, hotelName, hotelLocation, roomType)
VALUES
    -- Fosshótel, Reykjavík
    (101, 'Fosshótel', 'Reykjavík', 'SINGLE'),
    (102, 'Fosshótel', 'Reykjavík', 'DOUBLE'),
    (103, 'Fosshótel', 'Reykjavík', 'SUITE'),

    -- Hotel KEA, Akureyri
    (201, 'Hotel KEA', 'Akureyri', 'SINGLE'),
    (202, 'Hotel KEA', 'Akureyri', 'DOUBLE'),
    (203, 'Hotel KEA', 'Akureyri', 'SUITE'),

    -- ION Adventure Hotel, Selfoss
    (301, 'ION Adventure Hotel', 'Selfoss', 'SINGLE'),
    (302, 'ION Adventure Hotel', 'Selfoss', 'DOUBLE'),
    (303, 'ION Adventure Hotel', 'Selfoss', 'SUITE');


INSERT INTO
    Bookings(fromDate, toDate, roomNumber, userEmail, hotelName, hotelLocation)--
VALUES
-- Setjum inn bókanir í hvert roomtype, hvert hotel, hvern user
    ('2024-04-01', '2024-04-05', 101, 'alx@netfang.com', 'Fosshótel', 'Reykjavík'),
    ('2024-04-03', '2024-04-10', 202, 'helg@netfang.com', 'Hotel KEA', 'Akureyri'),
    ('2024-04-06', '2024-04-08', 303, 'silj@netfang.com', 'ION Adventure Hotel', 'Selfoss');




