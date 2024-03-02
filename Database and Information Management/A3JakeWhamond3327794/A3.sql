	drop table Courseoffing
	drop table CatalogueSearch
	drop table Course
	drop table Reservation
	drop table Privilege
	drop table Loan
	drop table Acquisition
	drop table ImmoveableResource
	drop table MoveableResource
	drop table Resource
	drop table Location
	drop table Category
	drop table Staff
	drop table Student
	drop table Member
CREATE TABLE Member 
(
  memberId CHAR(30) NOT NULL,
  name VARCHAR(45) NOT NULL,
  address VARCHAR(45) NOT NULL,
  phone CHAR(15) NOT NULL,
  email VARCHAR(45) CHECK(email LIKE '%_@__%.__%') NOT NULL,
  status VARCHAR(45) CHECK(status IN('Disabled', 'Enabled')) DEFAULT 'Enabled' NOT NULL,
  comments VARCHAR (45) NULL,
  primary key(memberId)
)
CREATE TABLE Staff 
(
	memberId CHAR(30) NOT NULL,
	Position CHAR(15) NOT NULL,
	Foreign Key (memberId) REFERENCES Member(memberId)	ON UPDATE CASCADE ON DELETE CASCADE,
	primary key(memberId)
)
CREATE TABLE Student 
(
	memberId CHAR(30) NOT NULL,
	demeritPoints INT DEFAULT 12 NOT NULL,
	FOREIGN KEY (memberId) REFERENCES Member(memberId) ON UPDATE CASCADE ON DELETE CASCADE, 
	primary key(memberId)
)	
CREATE TABLE Category  
(
	code CHAR(15) NOT NULL,
	name VARCHAR(30) NOT NULL,
	description VARCHAR(30) NOT NULL,
	durationInHours int NOT NULL,
	PRIMARY KEY (code)
)
CREATE TABLE CatalogueSearch
(
	CatalogueId CHAR(30) NOT NULL,
	keywords CHAR (30) NOT NULL,
	PRIMARY KEY (CatalogueId)
)
CREATE TABLE Location 
(
	locationId CHAR(30) NOT NULL,
	room CHAR(30) NULL,
	PRIMARY KEY (locationId)
)
CREATE TABLE Resource 
(
  resourceId CHAR(15) NOT NULL,
  description VARCHAR(40) NULL,
  status VARCHAR(25) CHECK(status IN('Not Loaned', 'Loaned', 'Loan Cancelled')) DEFAULT 'Not Loaned ' NOT NULL,
  code CHAR(15) NOT NULL,
  locationId CHAR(30) NOT NULL,
  FOREIGN KEY (code) REFERENCES Category(code) ON UPDATE CASCADE ON DELETE NO ACTION,
  FOREIGN KEY (locationId) REFERENCES Location(locationId) ON UPDATE CASCADE ON DELETE NO ACTION,
  PRIMARY KEY (resourceId)
)
CREATE TABLE Privilege 
(
	privilegeId CHAR(15) NOT NULL,
	description VARCHAR(45) NOT NULL,
	maximumItems INT NOT NULL,
	code CHAR(15) NOT NULL,
	FOREIGN KEY (code) REFERENCES Category(code) ON UPDATE CASCADE ON DELETE NO ACTION,
	PRIMARY KEY(privilegeId)
)
CREATE TABLE Course
(
	courseId CHAR(30) NOT NULL,
	name VARCHAR(30) NOT NULL,
	primary key(courseId)
)
CREATE TABLE ImmoveableResource 
(
  resourceId CHAR(15) NOT NULL,
  capacity INT NULL,
  FOREIGN KEY (resourceId) REFERENCES Resource(resourceId) ON UPDATE CASCADE ON DELETE CASCADE,
  primary key(resourceId)
)
CREATE TABLE MoveableResource
(
	resourceId CHAR(15) NOT NULL,
	name VARCHAR(30) NOT NULL,
	make VARCHAR(30) NULL,
	model VARCHAR(30) NULL,
	year CHAR(4) NULL,
	manufacturer VARCHAR(30) NULL,
	assetValue MONEY NULL,
	FOREIGN KEY (resourceId) REFERENCES Resource(resourceId) ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY(resourceId)
)
CREATE TABLE Courseoffing
(
	courseId CHAR(30) NOT NULL,
	name VARCHAR(30) NOT NULL,
	startDate Date NOT NULL,
	endDate Date NOT NULL,
	semesterOffered VARCHAR(30) CHECK(semesterOffered IN('Summer','Winter', 'Summer and Winter')) NOT NULL,
	yearOffered CHAR(4) NOT NULL,
	privilegeId CHAR(15) NOT NULL,
	memberId CHAR(30) Not NULL,	
	FOREIGN KEY (privilegeId) REFERENCES Privilege(privilegeId) ON UPDATE CASCADE ON DELETE NO ACTION, 
	FOREIGN KEY (memberId) REFERENCES Member(memberId) ON UPDATE CASCADE ON DELETE NO ACTION, 
	FOREIGN KEY (courseId) REFERENCES Course(courseId) ON UPDATE CASCADE ON DELETE NO ACTION,
	PRIMARY KEY (courseId)
)


CREATE TABLE Acquisition 
(
	acquisitionId CHAR(15) NOT NULL,   
	memberId CHAR(30) Not NULL,	
	itemName VARCHAR(45) Not NULL,
	make VARCHAR(45) Not NULL,
	model VARCHAR(45) Not NULL,
	year CHAR(4)  Not NULL,
	manufacturer VARCHAR(45) NULL,
	description	VARCHAR(45)	Not NULL,
	urgency	VARCHAR(45)	CHECK(urgency IN('High','Low')) NULL,
	status	VARCHAR(15)	CHECK(status IN('Approved','Denied', 'In-process')) DEFAULT 'In-process' NULL,
	vendorCode VARCHAR(45) Not NULL,
	price Decimal(5) Not NULL,
	fundCode VARCHAR(45) Not NULL,
	notes VARCHAR(45) Not NULL,
	FOREIGN KEY (memberId) REFERENCES Member(memberId) ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY (acquisitionId)
)
CREATE TABLE Loan 
(
	loanId	INT IDENTITY(1,1) NOT NULL,
	dateTimeBorrowed dateTime NOT NULL,
	dateTimeReturned dateTime NULL,
	dateTimeDue	dateTime NOT NULL,
	moveableResourceId CHAR(15) NOT NULL,
	memberId CHAR(30) NOT NULL,
	FOREIGN KEY (moveableResourceId) REFERENCES MoveableResource(resourceId) ON UPDATE CASCADE ON DELETE NO ACTION,
	FOREIGN KEY (memberId) REFERENCES Member(memberId) ON UPDATE CASCADE ON DELETE NO ACTION,	
	PRIMARY KEY (loanId)
)
CREATE TABLE Reservation 
(
	reservationId CHAR(45) NOT NULL, 
	dateTimeStart date NOT NULL,
	DateTimeEnd date NOT NULL,
	memberId CHAR(30) NOT NULL,
	resourceId CHAR(15) NOT NULL,
	FOREIGN KEY (resourceId) REFERENCES Resource(resourceId) ON UPDATE CASCADE ON DELETE NO ACTION,
	FOREIGN KEY (memberId) REFERENCES Member(memberId) ON UPDATE CASCADE ON DELETE NO ACTION,
	PRIMARY KEY(reservationId)
)

	INSERT INTO Member VALUES ('S0000001','Fake M one', 'Fake S one','0000000001','FakeMone@hotmail.com', 'Enabled', '')
	INSERT INTO Member VALUES ('S0000002','Fake M two', 'Fake S two','0000000002','FakeMtwo@hotmail.com', 'Enabled', '')
	INSERT INTO Member VALUES ('S0000003','Fake M third', 'Fake S third','0000000003','FakeMthird@hotmail.com', 'Enabled', '')
	INSERT INTO Member VALUES ('S0000004','Fake M fourth', 'Fake S fourth','0000000004','FakeMfourth@hotmail.com', 'Disabled', 'Overdue fines')
	INSERT INTO Member VALUES ('S0000005','Fake M fifth', 'Fake S fifth','0000000005','FakeMfifth@hotmail.com', 'Enabled', '')
	INSERT INTO Member VALUES ('S0000006','Fake M sixth', 'Fake S sixth','0000000006','FakeMsixth@hotmail.com', 'Enabled', '')
	INSERT INTO Member VALUES ('S0000007','Fake M seventh', 'Fake S seventh','0000000007','FakeMseventh@hotmail.com', 'Enabled', '')
	INSERT INTO Member VALUES ('S0000008','Fake M eighth', 'Fake S eighth','0000000008','FakeMeighth@hotmail.com', 'Enabled', '')
SELECT *
FROM Member;
	INSERT INTO Student VALUES ('S0000001', 5)
	INSERT INTO Student VALUES ('S0000002', 10)
	INSERT INTO Student VALUES ('S0000003', 15)
	INSERT INTO Student VALUES ('S0000004', 20)
SELECT *
FROM Student;
	INSERT INTO Staff VALUES ('S0000005','Admin')
	INSERT INTO Staff VALUES ('S0000006','Tutor')
	INSERT INTO Staff VALUES ('S0000007','Researcher')
	INSERT INTO Staff VALUES ('S0000008','Former Staff')
SELECT *
FROM Staff;
	INSERT INTO Location VALUES ('new0001','new11')
	INSERT INTO Location VALUES ('new0002','new22')
	INSERT INTO Location VALUES ('new0003','new33')
SELECT *
FROM Location;
	INSERT INTO Category VALUES ('code0001','room', 'Computer room', 5)
	INSERT INTO Category VALUES ('code0002','speaker', 'speakers', 10)
	INSERT INTO Category VALUES ('code0003','Laptop','Desktops', 15)
	INSERT INTO Category VALUES ('code0004','room','Meeting room', 20)
	INSERT INTO Category VALUES ('code0005','room','Study room', 25)
	INSERT INTO Category VALUES ('code0006','Camera','Cameras', 30)
SELECT *
from Category;
	INSERT INTO CatalogueSearch VALUES ('CS000001','K00000001')
	INSERT INTO CatalogueSearch VALUES ('CS000002','K00000002')
	INSERT INTO CatalogueSearch VALUES ('CS000004','K00000003')
	INSERT INTO CatalogueSearch VALUES ('CS000005','K00000004')
SELECT *
from CatalogueSearch;
	INSERT INTO RESOURCE VALUES ('ID000001','Camera', 'Loaned','code0006','new0001')
	INSERT INTO Resource VALUES ('ID000002','Speaker','Loaned','code0002','new0002')
	INSERT INTO Resource VALUES ('ID000003','Laptop','Not Loaned', 'code0003','new0003')
	INSERT INTO Resource VALUES ('ID000004','Meeting Room','Not Loaned','code0004','new0001')
	INSERT INTO Resource VALUES ('ID000005','Computer Room', default, 'code0005','new0002')
	INSERT INTO Resource VALUES ('ID000006','Study room', default,'code0006','new0003')
SELECT *
FROM Resource;
	INSERT INTO MoveableResource (resourceId, name, make, model, year, manufacturer, assetValue) VALUES ('ID000001', 'Camera', 'fakecamera', 'C001', 2020,'fake1',0001)
	INSERT INTO MoveableResource (resourceId, name, make, model, year, manufacturer, assetValue) VALUES ('ID000002', 'Speaker', 'fakespeaker', 'S001', 2020,'fake2',0002)
	INSERT INTO MoveableResource (resourceId, name, make, model, year, manufacturer, assetValue) VALUES ('ID000003', 'Laptop', 'fakelaptop', 'L001', 2020,'fake3',0003)
SELECT *
FROM MoveableResource;
	INSERT INTO ImmoveableResource (resourceId, capacity) VALUES ('ID000004', 5)
	INSERT INTO ImmoveableResource (resourceId, capacity) VALUES ('ID000005', 10)
	INSERT INTO ImmoveableResource (resourceId, capacity) VALUES ('ID000006', 15)
SELECT *
FROM ImmoveableResource;
	INSERT INTO Course VALUES ('FAKE1','Class1010')
	INSERT INTO Course VALUES ('FAKE2','Class1020')
	INSERT INTO Course VALUES ('FAKE3','Class1030')
	INSERT INTO Course VALUES ('FAKE4','Class1040')
	INSERT INTO Course VALUES ('FAKE5','Class1050')
SELECT *
FROM Course;
	INSERT INTO Acquisition VALUES ('Acq00001','S0000001','Producttwo','F2','F3', 2022,'F4', 'F5', 'high', 'Approved', 'v01', 5, 'a01', 'Order approved')
	INSERT INTO Acquisition VALUES ('Acq00002','S0000005','Productthird','F22','F33', 2022,'F44', 'F55', 'low', 'In-process', 'v02', 10, 'a02', 'Order Denied')
	INSERT INTO Acquisition VALUES ('Acq00003','S0000003','Productfour','F222','F333', 2022,'F444', 'F555', 'high', 'In-process', 'v03', 15, 'a03', 'Order approved')
	INSERT INTO Acquisition VALUES ('Acq00004','S0000004','Productfive','F2222 ','F3333', 2022,'F4444', 'F5555', 'low', 'Denied', 'v04', 20, 'a04', 'Order Denied')
SELECT *
FROM Acquisition;
	INSERT INTO Reservation VALUES ('Res00001', '2022-1-1', '2022-12-1' , 'S0000005', 'ID000001')
	INSERT INTO Reservation VALUES ('Res00002', '2022-1-1', '2022-12-1' , 'S0000005', 'ID000003')
	INSERT INTO Reservation VALUES ('Res00003', getDate(), DATEADD(DAY, +14, getDate()) , 'S0000003', 'ID000002')
	INSERT INTO Reservation VALUES ('Res00004', getDate(), DATEADD(DAY, +14, getDate()) , 'S0000004', 'ID000004')
	INSERT INTO Reservation VALUES ('Res00005', '2022-1-1', '2022-12-1' , 'S0000005', 'ID000005')
SELECT *
FROM Reservation;
	INSERT INTO Privilege VALUES ('P0001','Laptop', 5,'code0001')
	INSERT INTO Privilege VALUES ('P0002','Speaker', 10, 'code0002')
	INSERT INTO Privilege VALUES ('P0003','Camera', 15,'code0003')
	INSERT INTO Privilege VALUES ('P0004','Meeting room', 20, 'code0004')
SELECT *
FROM Privilege
INSERT INTO Courseoffing VALUES ('FAKE1', 'Class1010', '2022-1-1', '2022-12-30','Summer and Winter', '2022','P0001', 'S0000001') 
INSERT INTO Courseoffing VALUES ('FAKE2', 'Class1020', '2022-1-1', '2022-12-30','Summer and Winter', '2022', 'P0002', 'S0000002')
INSERT INTO Courseoffing VALUES ('FAKE3', 'Class1030', '2022-1-1', '2022-12-30','Summer and Winter', '2022','P0003', 'S0000003')
INSERT INTO Courseoffing VALUES ('FAKE4', 'Class1040', '2021-12-1', '2022-2-28','Summer','2022', 'P0004', 'S0000004')
INSERT INTO Courseoffing VALUES ('FAKE5', 'Class1050', '2022-6-1', '2022-8-31','Winter','2022','P0004', 'S0000002')

SELECT *
FROM Courseoffing
	INSERT INTO Loan(memberId, dateTimeBorrowed, dateTimeDue, dateTimeReturned, moveableResourceId) VALUES ('S0000001', getDate(), DATEADD(HOUR, +336, getDate()) , DATEADD(DAY, +9, getDate()) , 'ID000001')
	INSERT INTO Loan(memberId, dateTimeBorrowed, dateTimeDue, dateTimeReturned, moveableResourceId) VALUES ('S0000002', getDate(), DATEADD(HOUR, +336, getDate()) , DATEADD(DAY, +13, getDate()) , 'ID000002')
	INSERT INTO Loan(memberId, dateTimeBorrowed, dateTimeDue, dateTimeReturned, moveableResourceId) VALUES ('S0000003', getDate(), DATEADD(HOUR, +336, getDate()) , DATEADD(DAY, +6, getDate()) , 'ID000003')
SELECT *
FROM Loan;
--Question 1
SELECT m.name
FROM Courseoffing s join Member m ON s.memberId = m.memberId
WHERE s.courseId = 'FAKE2';
--Question 2
SELECT SUM(p.maximumItems) AS 'sum Of Speaker Privileges'
FROM Privilege p, Courseoffing c, Courseoffing m
WHERE p.code = (SELECT code FROM Category cc WHERE cc.name = 'Speaker') 
AND p.privilegeId = c.privilegeId
AND p.privilegeId = c.privilegeId AND c.courseId = m.CourseId
AND m.memberId = (SELECT m.memberId FROM Member m WHERE m.name = 'Fake M two')
--Question 3
select  m.name,m.phone, 
count(DISTINCT r.reservationId) as 'Reservations total'
 from  member m  
join Acquisition a on m.memberId = a.memberId
join Reservation r on m.memberId = r.memberId
where year = '2022' and m.memberId = 'S0000005'
group by m.name,m.phone,a.acquisitionId
--Question 4
SELECT DISTINCT(m.name) FROM Member m
JOIN Student s ON m.memberId = s.memberId 
JOIN Loan l ON s.memberId = l.memberId JOIN MoveableResource m2 ON l.moveableResourceId = m2.resourceId 
JOIN Resource r ON m2.resourceId = r.resourceId JOIN Category c ON r.code = c.code
WHERE YEAR(l.dateTimeBorrowed) = '2022' AND c.name = 'Camera' AND m2.model = 'C001'
--Question 5
SELECT TOP (1) name, l.moveableResourceId FROM MoveableResource m RIGHT JOIN Loan l ON m.resourceId = l.moveableResourceId 
WHERE MONTH(l.dateTimeBorrowed) = MONTH(GETDATE())
GROUP BY name, l.moveableResourceId ORDER BY COUNT(l.moveableResourceId) DESC;

