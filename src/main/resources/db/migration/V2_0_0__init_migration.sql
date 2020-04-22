CREATE TABLE IF NOT EXISTS `employees`
(

    id   int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(MAX),
    surname varchar(MAX),
    job_position varchar (MAX)

) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


insert into employees values (1, 'John', 'Smith', 'Manager');
insert into employees values (2, 'Jacob', 'Lorenz', 'Sales Rep');
insert into employees values (3, 'Anna', 'Kims', 'Sales Rep');
insert into employees values (4, 'Jimmy', 'Kips', 'Accountant');
insert into employees values (5, 'Alfred', 'Rows', 'Technican');
