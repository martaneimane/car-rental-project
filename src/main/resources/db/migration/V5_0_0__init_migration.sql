CREATE TABLE IF NOT EXISTS `booking`
(

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    booking_date date,
    client int, FOREIGN KEY (client) REFERENCES customer (id),
    car int, FOREIGN KEY (car) REFERENCES cars (id),
    date_from date,
    date_to date,
    booking_cost decimal


) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into booking values (1, 020200101, 1, 1, 20200202, 20200203, 97.77);
