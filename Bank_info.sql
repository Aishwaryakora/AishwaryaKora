CREATE TABLE Bank_info(id int null, b_name varchar(40) unique not null, b_id int not null, no_of_customers int not null, loan_status varchar(30) default 'ACTIVE', location varchar(30) not null);

insert into Bank_info values(1, 'SBI',501, 100, 'ACTIVE', 'Kalaburagi');
insert into Bank_info values(2, 'ICICI', 502, 150, 'ACTIVE', 'Bangalore');
insert into Bank_info values(3, 'CANARA', 503, 100, 'ACTIVE', 'Mysore');
insert into Bank_info values(4, 'KARNATAKA', 504, 200, 'ACTIVE', 'Bidar');
insert into Bank_info values(5, 'KRUHSNA', 505, 400, 'ACTIVE', 'Hassan');
insert into Bank_info values(6, 'KOTAK', 506, 350, 'ACTIVE', 'Hubbli');
insert into Bank_info values(7, 'AXIS', 507, 250, 'ACTIVE', 'Shivamogga');
insert into Bank_info values(8, 'SYNDICATE', 508, 100, 'ACTIVE', 'Mangalore');
insert into Bank_info values(9, 'YES', 509, 100, 'ACTIVE', 'Ballari');
insert into Bank_info values(10, 'RBS', 510, 100, 'ACTIVE', 'Belgaum');

select * from Bank_info;

CREATE TABLE Cust_info(id int not null, c_name varchar(30) not null, balance int not null, c_id int not null, b_id int not null, c_location varchar(30));

insert into Cust_info values(1, 'saraswati',5065245,701, 505, 'Hsssan');
insert into Cust_info values(2, 'vani',10245630,702, 501, 'Kalaburagi');
insert into Cust_info values(3, 'mahesh',84563221,703, 504, 'Bidar');
insert into Cust_info values(4, 'pooja',2000000,704, 516, 'Koppal');
insert into Cust_info values(5, 'raj',8000000,705, 509, 'Ballari');
insert into Cust_info values(6, 'spoorthi',7000000,706, 506, 'Hubbli');
insert into Cust_info values(7, 'Kavya',8400000,707, 610, 'Bidar');
insert into Cust_info values(8, 'megha',4000000,708, 502, 'Banglore');
insert into Cust_info values(9, 'vishal',236000000,709, 350, 'Hassan');
insert into Cust_info values(10, 'divya',100000,710, 507, 'Shivamogga');

select * from Cust_info;

CREATE TABLE loan_info(id int null, loan_type varchar(40), loan_amount int not null, c_id int not null);
insert into loan_info values(1, 'goldloan', 500000,705);
insert into loan_info values(2, 'vehicleloan', 200000,701);
insert into loan_info values(3, 'homeloan', 2200000,710);
insert into loan_info values(4, 'educationloan', 5500000,703);
insert into loan_info values(5, 'personalloan', 1000000,702);
insert into loan_info values(6, 'businessloan', 5800000,810);
insert into loan_info values(7, 'agriculturalloan', 8000000,708);
insert into loan_info values(8, 'consumerloan', 100000,570);
insert into loan_info values(9, 'cashcreditloan', 5900000,706);
insert into loan_info values(10, 'festivalloan', 1500000,690);

select*from loan_info;

select*from Bank_info inner join Cust_info on Bank_info.b_id=Cust_info.b_id;
select*from Bank_info inner join Cust_info on Bank_info.b_id=Cust_info.b_id inner join loan_info on Cust_info.c_id=loan_info.c_id;

select*from Bank_info left join Cust_info on Bank_info.b_id=Cust_info.b_id;
select*from Bank_info right join Cust_info on Bank_info.b_id=Cust_info.b_id;

select*from Bank_info full outer join Cust_info on Bank_info.id=Cust_info.id where location='Kalaburagi';

