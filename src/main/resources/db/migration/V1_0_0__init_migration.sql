CREATE TABLE IF NOT EXISTS `rental_office`
(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(MAX),
    address varchar(MAX),
    web_page varchar (MAX),
    cars_total integer,
    employees_total integer

) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE SEQUENCE SEQ_RENTALOFFICE increment by 1;

insert into rental_office values (SEQ_RENTALOFFICE.nextVal, 'The Rental Company', 'Company road 1, 10117 Berlin', 'www.therentalcompany.com',10,5);
