
drop table Car ;
drop table Company;
drop table Customer;
drop table Emp;
drop table CarCustomer;



DROP sequence cId_seq;
DROP sequence eId_seq;
DROP sequence comId_seq;
DROP sequence custId_seq;


create table Company(
comId number primary key,
companyName varchar2(255),
location varchar2(255)
);


create table Emp(
eId number primary key,
fName varchar(255),
lName varchar (255),
startDate DATE,
comId number,
FOREIGN KEY (comId) references Company(comId)
);





create table Car(
cId number primary key,
regNum varchar(255),
engSize number,
yom date,
price number,
color varchar2(255)
);

create table Customer(
custId number primary key,
fName varchar(255),
lName varchar (255),
dob DATE
);



create table CarCustomer(
cId integer,
custId integer,
primary key (cId,custId),
Foreign Key (cId) references Car (cId) ,
Foreign Key (custId) references Customer (custID)
);



create sequence cId_seq increment by 1 start with 1;
create sequence comId_seq increment by 1 start with 1;
create sequence eId_seq increment by 1 start with 1;
create sequence custId_seq increment by 1 start with 1;

Insert into Company values (1,'Frank Keane Motors','Dublin');