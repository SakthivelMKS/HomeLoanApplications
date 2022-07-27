 
 1.Creation Query
 create table Sakthi.HOME_LOAN(
id int not null auto_increment primary key,
first_name varchar(50) not null,
middle_name varchar(50)  null,
last_name varchar(50) not null,
email varchar(70) null,
loan_number varchar(21) not null,
mobile_number varchar(12) not null,
req_loan_amount int not null,
req_tenure_months int not null,
created_time timestamp default current_timestamp not null,
updated_time timestamp default current_timestamp not null,
UNIQUE (loan_number)
);

2.Sample Insertion Query
insert into Sakthi.HOME_LOAN (first_name,middle_name,last_name,email,loan_number,mobile_number,req_loan_amount,req_tenure_months) values(
"Sakthivel","","M","kalamadhes1993@gmail.com","SAKT2207252222","9865687854",20000000,60);

3.Selct Query
select * from Sakthi.HOME_LOAN;