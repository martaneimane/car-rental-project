CREATE TABLE IF NOT EXISTS `car_rental`
(

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id int, FOREIGN KEY (employee_id) REFERENCES employee (id),
    rental_date date,
    booking_id int, FOREIGN KEY (booking_id) REFERENCES booking (id),
    comments VARCHAR (MAX)


) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
CREATE SEQUENCE SEQ_CAR_RENTAL increment by 1;

insert into car_rental values (SEQ_CAR_RENTAL.nextVal, 2, 20200202, 1, 'full coverage');
