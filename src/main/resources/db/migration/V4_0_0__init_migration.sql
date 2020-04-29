CREATE TABLE IF NOT EXISTS `customer`
(

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(MAX),
    surname varchar(MAX),
    email varchar (MAX),
    address varchar (MAX)


) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
CREATE SEQUENCE SEQ_CUSTOMER increment by 1;

insert into customer values (SEQ_CUSTOMER.nextVal, 'Janis', 'Berzins', 'janis1.berzins@gmail.com', 'Duntes Street 11, Riga, Latvia');
insert into customer values (SEQ_CUSTOMER.nextVal, 'Juris', 'Ezis', 'juris.eziitis@gmail.com', 'Valmieras Street 10, Riga, Latvia');
insert into customer values (SEQ_CUSTOMER.nextVal, 'Liene', 'Sirds', 'l.sirds@gmail.com', 'Elizabetes Street 12, Riga, Latvia');
insert into customer values (SEQ_CUSTOMER.nextVal, 'Dana', 'Liepa', 'dana.liepa.berzins@gmail.com', 'Bauskas Street 13, Riga, Latvia');
insert into customer values (SEQ_CUSTOMER.nextVal, 'Toms', 'Akmens', 'toms.ak@gmail.com', 'Kantora Street 14, Riga, Latvia');
