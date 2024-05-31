-- Wyatt Haston Database Project 2

CREATE DATABASE Vacuum
-- Create Tables for Vacuum Company
CREATE TABLE Designer (
EmailID VARCHAR(100) PRIMARY KEY NOT NULL,
Name VARCHAR(100),
StreetNumber INT,
StreetName VARCHAR(250),
City VARCHAR(100),
State VARCHAR(100),
Zip INT,
Phone VARCHAR(20)
);

CREATE TABLE VacuumModel (
ModelID INT PRIMARY KEY NOT NULL,
Name VARCHAR(100),
Color VARCHAR(50),
Price MONEY,
);

CREATE TABLE DesignerVacuum (
ModelID INT PRIMARY KEY REFERENCES VacuumModel(ModelID),
DesignerEmail VARCHAR(100) REFERENCES Designer(EmailID),
);

CREATE TABLE Vacuum (
SerialNumber INT PRIMARY KEY NOT NULL,
ManufactureDate DATETIME,
ModelID INT REFERENCES VacuumModel(ModelID)
);

CREATE TABLE VacuumTechnician (
EmployeeNumber INT PRIMARY KEY NOT NULL,
Name VARCHAR(250),
DateEmployed DATETIME,
StreetNumber INT,
StreetName VARCHAR(250),
City VARCHAR(100),
State VARCHAR(100),
Zip INT
);

CREATE TABLE Phone (
Number VARCHAR(15) PRIMARY KEY NOT NULL,
Employee INT REFERENCES VacuumTechnician(EmployeeNumber)
);

CREATE TABLE Inspector (
Supervisor INT NOT NULL REFERENCES VacuumTechnician(EmployeeNumber),
EmployeeSupervised INT PRIMARY KEY REFERENCES VacuumTechnician(EmployeeNumber) NOT NULL
);

CREATE TABLE InspectVacuum (
TechnicianID INT NOT NULL REFERENCES VacuumTechnician(EmployeeNumber),
SerialNumber INT PRIMARY KEY REFERENCES Vacuum(SerialNumber),
VerificationDate DATETIME NOT NULL,
QualityGrade INT CHECK (QualityGrade > 0 AND QualityGrade <= 100) NOT NULL
);

-- Inserting Data

-- Data for Designer Table
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('mucci@mucci.com', 'Mucci', 123,'Street St', 'Atlanta', 'GA', 20775, '111-111-1111');
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('designell@designell.com', 'Designell', 1000, 'Brook St', 'Atlanta', 'GA', 20775, '222-222-2222');
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('couturer@couturer.com', 'Couturer', 2012, '5th St', 'Atlanta', 'GA',  20775, '333-333-3333');
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('isigner@isigner.com', 'Isigner', 1231, 'North St', 'Atlanta', 'GA',  20775, '444-444-4444');
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('madesign@madesign.com', 'Madesign', 90, 'Made St', 'Atlanta', 'GA',  20775, '555-555-5555');
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('jeggings@jeggings.org', 'Jeggins', 505, 'Under Rd', 'Atlanta', 'GA',  20775, '667-667-6676');
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('vacuum@vacuum.com', 'Vacuum', 123, 'Apple St', 'Atlanta', 'GA', 20775, '432-432-4444');
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('upsign@upsign.com', 'Upsign', 11, '11th St', 'Atlanta', 'GA', 20775, '574-888-2344');
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('clean@cleaners.com', 'Cleaners', 11, '45th St', 'Atlanta', 'GA', 20775, '454-554-5555');
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('hoover@hoover.com', 'Hoover', 123, '123th St', 'Atlanta', 'GA', 20775, '123-123-1233');
INSERT INTO Designer (EmailID, Name, StreetNumber, StreetName, City, State, Zip, Phone)
VALUES ('outof@ideas.com', 'OutOfIdeas', 404, 'Streeter St', 'Atlanta', 'GA', 20775, '234-234-2344');

-- Data for VacuumModel Table
INSERT INTO VacuumModel (ModelID, Name, Color, Price)
VALUES (3000, 'Vacuuminator', 'Blue', $499.99);
INSERT INTO VacuumModel (ModelID, Name, Color, Price)
VALUES (2311, 'Big Vacuum', 'Blue and Green', $199.99);
INSERT INTO VacuumModel (ModelID, Name, Color, Price)
VALUES (1211, 'The Cheap One', 'Beige', $49.99);
INSERT INTO VacuumModel (ModelID, Name, Color, Price)
VALUES (9999, 'High Roller', 'Gold', $9999.99);
INSERT INTO VacuumModel (ModelID, Name, Color, Price)
VALUES (3123, 'Clean Machine', 'Red', $299.99);
INSERT INTO VacuumModel (ModelID, Name, Color, Price)
VALUES (4444, 'Scarer of All Pets', 'Black', $499.99);
INSERT INTO VacuumModel (ModelID, Name, Color, Price)
VALUES (5123, 'Space', 'White', $699.99);
INSERT INTO VacuumModel (ModelID, Name, Color, Price)
VALUES (1231, 'Placeholder', 'Black', $499.99);
INSERT INTO VacuumModel (ModelID, Name, Color, Price)
VALUES (5312, 'Hoover 3000', 'Red', $499.99);
INSERT INTO VacuumModel (ModelID, Name, Color, Price)
VALUES (6565, 'Space Cleaner 3.5', 'Blue', $499.99);

-- Data for DesignerVacuum
INSERT INTO DesignerVacuum (ModelID, DesignerEmail)
VALUES (3000, 'mucci@mucci.com');
INSERT INTO DesignerVacuum (ModelID, DesignerEmail)
VALUES (2311, 'designell@designell.com');
INSERT INTO DesignerVacuum (ModelID, DesignerEmail)
VALUES (1211, 'couturer@couturer.com');
INSERT INTO DesignerVacuum (ModelID, DesignerEmail)
VALUES (9999, 'clean@cleaners.com');
INSERT INTO DesignerVacuum (ModelID, DesignerEmail)
VALUES (3123, 'madesign@madesign.com');
INSERT INTO DesignerVacuum (ModelID, DesignerEmail)
VALUES (4444, 'jeggings@jeggings.org');
INSERT INTO DesignerVacuum (ModelID, DesignerEmail)
VALUES (5123, 'vacuum@vacuum.com');
INSERT INTO DesignerVacuum (ModelID, DesignerEmail)
VALUES (1231, 'upsign@upsign.com');
INSERT INTO DesignerVacuum (ModelID, DesignerEmail)
VALUES (5312, 'hoover@hoover.com');
INSERT INTO DesignerVacuum (ModelID, DesignerEmail)
VALUES (6565, 'outof@ideas.com');

-- Data for Vacuum Table
INSERT INTO Vacuum (SerialNumber, ManufactureDate, ModelID)
VALUES (434434, '2010-05-11 16:23:44', 3000);
INSERT INTO Vacuum (SerialNumber, ManufactureDate, ModelID)
VALUES (434435, '2010-05-11 17:23:44', 3000);
INSERT INTO Vacuum (SerialNumber, ManufactureDate, ModelID)
VALUES (434436, '2007-05-11 18:23:44', 3000);
INSERT INTO Vacuum (SerialNumber, ManufactureDate, ModelID)
VALUES (434437, '2008-05-11 19:23:44', 3000);
INSERT INTO Vacuum (SerialNumber, ManufactureDate, ModelID)
VALUES (000001, '2011-05-11 16:23:44', 9999);
INSERT INTO Vacuum (SerialNumber, ManufactureDate, ModelID)
VALUES (34234, '2010-05-10 16:23:44', 3123);
INSERT INTO Vacuum (SerialNumber, ManufactureDate, ModelID)
VALUES (231231, '2009-05-11 16:23:44', 1231);
INSERT INTO Vacuum (SerialNumber, ManufactureDate, ModelID)
VALUES (323231, '2013-05-11 16:23:44', 6565);
INSERT INTO Vacuum (SerialNumber, ManufactureDate, ModelID)
VALUES (123111, '2009-05-11 16:23:44', 5312);
INSERT INTO Vacuum (SerialNumber, ManufactureDate, ModelID)
VALUES (878787, '2010-05-11 16:23:44', 3000);

-- Data for VacuumTechnician
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (100, 'James', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (101, 'Alex', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (102, 'Wyatt', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (103, 'Greg', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (104, 'Harrison', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (105, 'Joe', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (106, 'Mary', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (107, 'Suzy', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (108, 'Justine', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (109, 'James II', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);
INSERT INTO VacuumTechnician (EmployeeNumber, Name, DateEmployed, StreetNumber, StreetName, City, State, Zip)
VALUES (110, 'Josh', '2010-05-11 16:23:44', 123, 'Street St', 'Atlanta', 'GA', 40333);

-- Data for Phone
INSERT INTO Phone (Number, Employee)
VALUES ('111-111-1111', 100);
INSERT INTO Phone (Number, Employee)
VALUES ('222-222-2222', 101);
INSERT INTO Phone (Number, Employee)
VALUES ('333-333-3333', 102);
INSERT INTO Phone (Number, Employee)
VALUES ('444-444-4444', 103);
INSERT INTO Phone (Number, Employee)
VALUES ('555-555-5555', 104);
INSERT INTO Phone (Number, Employee)
VALUES ('666-666-6666', 105);
INSERT INTO Phone (Number, Employee)
VALUES ('777-777-7777', 106);
INSERT INTO Phone (Number, Employee)
VALUES ('888-888-8888', 107);
INSERT INTO Phone (Number, Employee)
VALUES ('999-999-9999', 108);
INSERT INTO Phone (Number, Employee)
VALUES ('121-121-1212', 109);
INSERT INTO Phone (Number, Employee)
VALUES ('434-342-1231', 110);
INSERT INTO Phone (Number, Employee)
VALUES ('434-342-1000', 110);

-- Data for Inspector
INSERT INTO Inspector (Supervisor, EmployeeSupervised)
VALUES (100, 102)
INSERT INTO Inspector (Supervisor, EmployeeSupervised)
VALUES (100, 104)
INSERT INTO Inspector (Supervisor, EmployeeSupervised)
VALUES (100, 106)
INSERT INTO Inspector (Supervisor, EmployeeSupervised)
VALUES (100, 108)
INSERT INTO Inspector (Supervisor, EmployeeSupervised)
VALUES (100, 110)  
INSERT INTO Inspector (Supervisor, EmployeeSupervised)
VALUES (101, 103)
INSERT INTO Inspector (Supervisor, EmployeeSupervised)
VALUES (101, 105)
INSERT INTO Inspector (Supervisor, EmployeeSupervised)
VALUES (101, 107)
INSERT INTO Inspector (Supervisor, EmployeeSupervised)
VALUES (101, 109)

-- Data for InspectVacuum
INSERT INTO InspectVacuum (TechnicianID, SerialNumber, VerificationDate, QualityGrade)
VALUES (102, 434434, '2010-05-11 16:23:44', 50);
INSERT INTO InspectVacuum (TechnicianID, SerialNumber, VerificationDate, QualityGrade)
VALUES (102, 434435, '2010-05-11 16:23:44', 80);
INSERT INTO InspectVacuum (TechnicianID, SerialNumber, VerificationDate, QualityGrade)
VALUES (102, 434436, '2010-05-11 16:23:44', 80);
INSERT INTO InspectVacuum (TechnicianID, SerialNumber, VerificationDate, QualityGrade)
VALUES (101, 434437, '2010-05-11 16:23:44', 90);
INSERT INTO InspectVacuum (TechnicianID, SerialNumber, VerificationDate, QualityGrade)
VALUES (100, 000001, '2010-05-11 16:23:44', 10);
INSERT INTO InspectVacuum (TechnicianID, SerialNumber, VerificationDate, QualityGrade)
VALUES (108, 34234, '2010-05-11 16:23:44', 100);
INSERT INTO InspectVacuum (TechnicianID, SerialNumber, VerificationDate, QualityGrade)
VALUES (107, 231231, '2010-05-11 16:23:44', 90);
INSERT INTO InspectVacuum (TechnicianID, SerialNumber, VerificationDate, QualityGrade)
VALUES (106, 323231, '2010-05-11 16:23:44', 20);
INSERT INTO InspectVacuum (TechnicianID, SerialNumber, VerificationDate, QualityGrade)
VALUES (110, 123111, '2010-05-11 16:23:44', 90);
INSERT INTO InspectVacuum (TechnicianID, SerialNumber, VerificationDate, QualityGrade)
VALUES (103, 878787, '2010-05-11 16:23:44', 90);

-- Question 1: The Model of each vacuum along with its price 
SELECT Name as 'Vacuum Name', Price FROM VacuumModel;

-- Question 2: The number of Vacuums that were manufactured after 2010
SELECT * FROM Vacuum WHERE ManufactureDate > '2010-01-01';

--  Question 3: The name of the technician who has inspected the most number of vacuums
SELECT TOP 1 InspectVacuum.TechnicianID, VacuumTechnician.Name,  COUNT(InspectVacuum.TechnicianID) AS 'Vacuums Inspected'
FROM InspectVacuum
INNER JOIN VacuumTechnician ON InspectVacuum.TechnicianID = VacuumTechnician.EmployeeNumber
GROUP BY InspectVacuum.TechnicianID, VacuumTechnician.Name
ORDER BY 'Vacuums Inspected' DESC;

-- Question 4: List the vacuum models which were graded with an average along with its verification date.
SELECT VacuumModel.Name, InspectVacuum.VerificationDate, AVG(InspectVacuum.QualityGrade) as 'Average Grade'
FROM InspectVacuum
INNER JOIN Vacuum ON Vacuum.SerialNumber = InspectVacuum.SerialNumber
INNER JOIN VacuumModel ON Vacuum.ModelID = VacuumModel.ModelID
GROUP BY VacuumModel.ModelID, VacuumModel.Name, InspectVacuum.VerificationDate;

-- Question 5: The serial number of each vacuum along with its designer�s name & technician�s name.
SELECT Vacuum.SerialNumber as 'Serial Number', VacuumTechnician.Name AS Inspector, Designer.Name AS Designer
FROM InspectVacuum
INNER JOIN Vacuum ON InspectVacuum.SerialNumber = Vacuum.SerialNumber
INNER JOIN VacuumModel ON Vacuum.ModelID = VacuumModel.ModelID
INNER JOIN DesignerVacuum ON VacuumModel.ModelID = DesignerVacuum.ModelID
INNER JOIN Designer ON DesignerVacuum.DesignerEmail = Designer.EmailID
INNER JOIN VacuumTechnician  ON InspectVacuum.TechnicianID = VacuumTechnician.EmployeeNumber;