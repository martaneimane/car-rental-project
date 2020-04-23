CREATE TABLE IF NOT EXISTS `rental`
(

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee int, FOREIGN KEY (employee) REFERENCES employees (id),
    rental_date date,
    booking int, FOREIGN KEY (booking) REFERENCES booking (id),
    comments VARCHAR (MAX)


) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into rental values (1, 2, 20200202, 1, 'full coverage');
