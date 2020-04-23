CREATE TABLE IF NOT EXISTS `employee`
(

    id   int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(MAX),
    surname varchar(MAX),
    job_position varchar (MAX)

) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE SEQUENCE SEQ_EMPLOYEE increment by 1;


insert into employee values (SEQ_EMPLOYEE.nextVal, 'John', 'Smith', 'Manager');
insert into employee values (SEQ_EMPLOYEE.nextVal, 'Jacob', 'Lorenz', 'Sales Rep');
insert into employee values (SEQ_EMPLOYEE.nextVal, 'Anna', 'Kims', 'Sales Rep');
insert into employee values (SEQ_EMPLOYEE.nextVal, 'Jimmy', 'Kips', 'Accountant');
insert into employee values (SEQ_EMPLOYEE.nextVal, 'Alfred', 'Rows', 'Technican');
