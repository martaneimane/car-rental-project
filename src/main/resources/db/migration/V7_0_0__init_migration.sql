CREATE TABLE IF NOT EXISTS `return`
(

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee int, FOREIGN KEY (employee) REFERENCES employees (id),
    return_date date,
    booking int, FOREIGN KEY (booking) REFERENCES booking (id),
    add_payments decimal,
    comments VARCHAR (MAX)


) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into return values (1, 2, 20200202, 2,0.0, 'no damages, full tank');
