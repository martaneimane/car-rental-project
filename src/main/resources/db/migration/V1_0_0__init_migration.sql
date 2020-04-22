CREATE TABLE IF NOT EXISTS `rental_office`
(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(MAX),
    address varchar(MAX),
    web_page varchar (MAX),
    cars_total integer,
    employees_total integer

) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


insert into rental_office values (1, 'The Rental Company', 'Company road 1, 10117 Berlin', 'www.therentalcompany.com',10,5);
