CREATE TABLE IF NOT EXISTS `customer`
(

    'id'   int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    'name' varchar(MAX),
    'surname' varchar(MAX),
    'email' varchar (MAX),
    'address' varchar (MAX)


) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


insert into 'customer' values (1, 'Janis', 'Berzins', 'janis1.berzins@gmail.com', 'Duntes Street 11, Riga, Latvia',);
insert into 'customer' values (1, 'Janis1', 'Berzins2', 'janis12.berzins@gmail.com', 'Duntes Street 10, Riga, Latvia',);
insert into 'customer' values (1, 'Janis2', 'Berzins3', 'janis23.berzins@gmail.com', 'Duntes Street 12, Riga, Latvia',);
insert into 'customer' values (1, 'Janis3', 'Berzins4', 'janis34.berzins@gmail.com', 'Duntes Street 13, Riga, Latvia',);
insert into 'customer' values (1, 'Janis4', 'Berzins5', 'janis45.berzins@gmail.com', 'Duntes Street 14, Riga, Latvia',);
