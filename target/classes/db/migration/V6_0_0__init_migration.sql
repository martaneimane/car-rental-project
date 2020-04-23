CREATE TABLE IF NOT EXISTS `car_rental`
(

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee int, FOREIGN KEY (employee) REFERENCES employee (id),
    rental_date date,
    booking int, FOREIGN KEY (booking) REFERENCES booking (id),
    comments VARCHAR (MAX)


) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
CREATE SEQUENCE SEQ_CAR_RENTAL increment by 1;

insert into car_rental values (SEQ_CAR_RENTAL.nextVal, 2, 20200202, 1, 'full coverage');
