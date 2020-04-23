CREATE TABLE IF NOT EXISTS `car_return`
(

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee int, FOREIGN KEY (employee) REFERENCES employee (id),
    return_date date,
    booking int, FOREIGN KEY (booking) REFERENCES booking (id),
    additional_payments decimal,
    comments VARCHAR (MAX)


) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
CREATE SEQUENCE SEQ_CAR_RETURN increment by 1;

insert into car_return values (SEQ_CAR_RETURN.nextVal, 2, 20200202, 2,0.0, 'no damages, full tank');
