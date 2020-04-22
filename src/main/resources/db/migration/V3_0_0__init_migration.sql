CREATE TABLE IF NOT EXISTS `cars`
(

    id   int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    brand varchar(MAX),
    model varchar(MAX),
    body_type varchar (MAX),
    year smallint,
    color varchar(MAX),
    mileage int,
    status varchar (MAX),
    price_per_day decimal

) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


insert into cars values (1, 'Audi', 'A4', 'Sedan', 2018, 'gray', 14576, 'Available', 34.96);
insert into cars values (2, 'Audi', 'A6', 'Sedan', 2017, 'black', 47621, 'Available', 52.70);
insert into cars values (3, 'BMW', '3 Series', 'Sedan', 2017, 'blue', 38655, 'Available', 46.79);
insert into cars values (4, 'BMW', '3 Series', 'Wagon', 2017, 'black', 41669, 'Available', 48.52);
insert into cars values (5, 'BMW', '5 Series', 'Sedan', 2016, 'white', 62413, 'Available', 56.33);
insert into cars values (6, 'Skoda', 'Scala', 'Hatchback', 2019, 'blue', 15776, 'Available', 31.33);
insert into cars values (7, 'Skoda', 'Superb', 'Wagon', 2019, 'gray', 22321, 'Available', 44.86);
insert into cars values (8, 'Opel', 'Corsa', 'Hatchback', 2017, 'white', 19476, 'Available', 32.51);
insert into cars values (9, 'Opel', 'Insignia', 'Sedan', 2017, 'red', 42973, 'Available', 42.45);
insert into cars values (10, 'Fiat', 'C500', 'Hatchback', 2018, 'red', 39676, 'Available', 31.22);

