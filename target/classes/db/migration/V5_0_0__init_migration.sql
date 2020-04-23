CREATE TABLE IF NOT EXISTS `booking`
(

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    booking_date date,
    customer int, FOREIGN KEY (customer) REFERENCES customer (id),
    car int, FOREIGN KEY (car) REFERENCES car (id),
    date_from date,
    date_to date,
    booking_cost decimal


) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
CREATE SEQUENCE SEQ_BOOKING increment by 1;

insert into booking values (SEQ_BOOKING.nextVal, 20200101, 1, 1, 20200202, 20200204, 97.77);
insert into booking values (SEQ_BOOKING.nextVal, 20200306, 3, 6, 20200310, 20200315, 156.65);
