CREATE DATABASE Elijay;
USE Elijay;

CREATE TABLE Patient (
PatientID int PRIMARY KEY NOT NULL,
FirstName VARCHAR(250),
LastName VARCHAR(250),
DOB INT,
Age INT,
Gender VARCHAR(250),
Email VARCHAR(250),
StreetNumber INT,
StreetName VARCHAR(250),
State VARCHAR(250),
ZipCode INT,
PatientType VARCHAR(250) CHECK (PatientType IN ('Resident', 'Out-patient'))
);

CREATE TABLE Phone (
RecordID INT PRIMARY KEY,
PatientID INT FOREIGN KEY REFERENCES Patient(PatientID),
PhoneNumber VARCHAR(250) NOT NULL
);

CREATE TABLE Bed (
BedNumber int PRIMARY KEY NOT NULL,
PatientID int FOREIGN KEY REFERENCES Patient(PatientID)
);

CREATE TABLE Test (
TestCode INT PRIMARY KEY NOT NULL,
Description VARCHAR(250),
Cost DECIMAL
);

CREATE TABLE Treatment (
TreatmentCode INT PRIMARY KEY NOT NULL,
Description VARCHAR(250)
);

CREATE TABLE Department (
DepartmentCode INT PRIMARY KEY,
Name VARCHAR(250)
);

CREATE TABLE Personnel (
PersonnelID INT PRIMARY KEY NOT NULL,
FirstName VARCHAR(250),
LastName VARCHAR(250),
Phone VARCHAR(250),
StreetNumber INT,
StreetName VARCHAR(250),
State VARCHAR(250),
ZipCode INT,
Gender VARCHAR(250),
HireDate VARCHAR(250),
Position VARCHAR(250),
DepartmentCode INT REFERENCES Department(DepartmentCode),
EmploymentType VARCHAR(250) CHECK (EmploymentType IN ('Full-time', 'Part-time'))
);

CREATE TABLE Email (
Email VARCHAR(250) PRIMARY KEY,
PersonnelID INT REFERENCES Personnel(PersonnelID),
);

CREATE TABLE PatientTests (
RecordID INT NOT NULL,
PersonnelID INT REFERENCES Personnel(PersonnelID),
PatientID INT REFERENCES Patient(PatientID),
Date DATETIME,
TestCode INT REFERENCES Test(TestCode)
);

CREATE TABLE PatientTreatments (
RecordID INT NOT NULL,
PersonnelID INT REFERENCES Personnel(PersonnelID),
PatientID INT REFERENCES Patient(PatientID),
Date DATETIME,
TreatmentCode INT REFERENCES Treatment(TreatmentCode)
);

---Data for Patient
INSERT INTO Patient (PatientID,FirstName,LastName,DOB,Age,Gender,Email,StreetNumber,StreetName,State,ZipCode,PatientType)
VALUES (0, 'Alex', 'James', 10101990, 33, 'Male', 'ajames@gmail.com', 201, 'Street', 'GA', 30644, 'Resident');
INSERT INTO Patient (PatientID,FirstName,LastName,DOB,Age,Gender,Email,StreetNumber,StreetName,State,ZipCode,PatientType)
VALUES (1, 'James', 'Jamerson', 10101991, 32, 'Male', 'jjames@gmail.com', 201, 'StreetStreet', 'GA', 30644, 'Out-patient');
INSERT INTO Patient (PatientID,FirstName,LastName,DOB,Age,Gender,Email,StreetNumber,StreetName,State,ZipCode,PatientType)
VALUES (2, 'Real', 'Namerson', 10101980, 43, 'Male', 'rnamerson@gmail.com', 201, 'Streeterson', 'TN', 55554, 'Resident');
INSERT INTO Patient (PatientID,FirstName,LastName,DOB,Age,Gender,Email,StreetNumber,StreetName,State,ZipCode,PatientType)
VALUES (3, 'John', 'Smith', 10101998, 25, 'Male', 'jsmith@gmail.com', 200, '5th Street', 'FL', 506444, 'Out-patient');
INSERT INTO Patient (PatientID,FirstName,LastName,DOB,Age,Gender,Email,StreetNumber,StreetName,State,ZipCode,PatientType)
VALUES (4, 'Sally', 'Salleydaughter', 10102000, 23, 'Female', 'ssalleydaughter@gmail.com', 499, '2nd Street', 'GA', 306444, 'Resident');

--Data for Phone
INSERT INTO Phone (RecordID, PatientID, PhoneNumber)
VALUES(0, 0, '423-444-5555');
INSERT INTO Phone (RecordID, PatientID, PhoneNumber)
VALUES(1, 1, '111-111-4444');
INSERT INTO Phone (RecordID, PatientID, PhoneNumber)
VALUES(2, 2, '222-444-3333');
INSERT INTO Phone (RecordID, PatientID, PhoneNumber)
VALUES(3, 3, '111-222-3333');
INSERT INTO Phone (RecordID, PatientID, PhoneNumber)
VALUES(4, 3, '123-456-7899');

--Data for Bed
INSERT INTO Bed (BedNumber, PatientID)
VALUES (0, 0);
INSERT INTO Bed (BedNumber, PatientID)
VALUES (1, 2);
INSERT INTO Bed (BedNumber, PatientID)
VALUES (2, 4);

--Data for Test
INSERT INTO Test (TestCode, Description, Cost)
VALUES (0, 'Physical Examination', 50.00);
INSERT INTO Test (TestCode, Description, Cost)
VALUES (1, 'Blood Test', 200.00);
INSERT INTO Test (TestCode, Description, Cost)
VALUES (2, 'Mental Health Test', 250.00);
INSERT INTO Test (TestCode, Description, Cost)
VALUES (3, 'Nose Job', 500.00);
INSERT INTO Test (TestCode, Description, Cost)
VALUES (4, 'Cancer Screening', 1000.00);

--Data for Treatments
INSERT INTO Treatment (TreatmentCode, Description)
VALUES (0, 'Antibotics');
INSERT INTO Treatment (TreatmentCode, Description)
VALUES (1, 'IV Drip');
INSERT INTO Treatment (TreatmentCode, Description)
VALUES (2, 'Electroshock Therapy');
INSERT INTO Treatment (TreatmentCode, Description)
VALUES (3, 'Weight loss pills');
INSERT INTO Treatment (TreatmentCode, Description)
VALUES (4, 'Physical Therapy');

--Data for Department
INSERT INTO Department (DepartmentCode, Name)
VALUES (0, 'Administration');
INSERT INTO Department (DepartmentCode, Name)
VALUES (1, 'HR Department');
INSERT INTO Department (DepartmentCode, Name)
VALUES (2, 'Accounting');
INSERT INTO Department (DepartmentCode, Name)
VALUES (3, 'Nurses');
INSERT INTO Department (DepartmentCode, Name)
VALUES (4, 'Doctor');

--Data for Personnel
INSERT INTO Personnel (PersonnelID, FirstName, LastName, Phone, StreetNumber, StreetName, State, ZipCode, Gender, HireDate, Position, DepartmentCode, EmploymentType)
VALUES (0, 'John', 'Hurtado', '111-111-1116', 218, 'Margaret Street', 'GA',  55555, 'Male', '01-14-05', 'Doctor', 4, 'Full-Time');
INSERT INTO Personnel (PersonnelID, FirstName, LastName, Phone, StreetNumber, StreetName, State, ZipCode, Gender, HireDate, Position, DepartmentCode, EmploymentType)
VALUES (1, 'Dixie', 'Brown', '222-222-2222', 1460, 'Libby Street', 'GA',  55555, 'Female', '04-19-10', 'HR Manager', 1, 'Full-Time');
INSERT INTO Personnel (PersonnelID, FirstName, LastName, Phone, StreetNumber, StreetName, State, ZipCode, Gender, HireDate, Position, DepartmentCode, EmploymentType)
VALUES (2, 'Jessica', 'Lane', '333-333-3333', 1968, 'College Avenue', 'GA',  55555, 'Female', '10-14-15', 'Nurse', 3, 'Part-Time');
INSERT INTO Personnel (PersonnelID, FirstName, LastName, Phone, StreetNumber, StreetName, State, ZipCode, Gender, HireDate, Position, DepartmentCode, EmploymentType)
VALUES (3, 'Kenneth', 'Thomas', '444-444-4444', 2286, 'Capitol Avenue', 'GA',  55555, 'Male', '12-14-20', 'Director', 0, 'Full-Time');
INSERT INTO Personnel (PersonnelID, FirstName, LastName, Phone, StreetNumber, StreetName, State, ZipCode, Gender, HireDate, Position, DepartmentCode, EmploymentType)
VALUES (4, 'Antonio', 'Morgan', '555-555-5555', 786, 'Pinnickinick Street', 'GA',  55555, 'Male', '01-14-05', 'Accountant', 2, 'Full-Time');

--Data for Email
INSERT INTO Email (Email, PersonnelID)
VALUES ('jurtado@gmail.com', 0);
INSERT INTO Email (Email, PersonnelID)
VALUES ('jurtado@elijay.com', 0);
INSERT INTO Email (Email, PersonnelID) VALUES ('dbrown@elijay.com', 1);
INSERT INTO Email (Email, PersonnelID)
VALUES ('jlane@elijay.com', 2);
INSERT INTO Email (Email, PersonnelID)
VALUES ('kthomas@elijay.com', 3);
INSERT INTO Email (Email, PersonnelID)
VALUES ('amorgan@elijay.com', 4);

--Data for PatientTests
INSERT INTO PatientTests (RecordID, PersonnelID, PatientID, Date, Testcode)
VALUES (0, 0, 0, '2008-11-11 13:23:44', 3);
INSERT INTO PatientTests (RecordID, PersonnelID, PatientID, Date, Testcode)
VALUES (1, 0, 1, '2010-12-11 08:23:44', 2);
INSERT INTO PatientTests (RecordID, PersonnelID, PatientID, Date, Testcode)
VALUES (2, 2, 4, '2020-10-10 13:23:44', 0);
INSERT INTO PatientTests (RecordID, PersonnelID, PatientID, Date, Testcode)
VALUES (3, 2, 3, '2005-05-11 16:23:44', 0);
INSERT INTO PatientTests (RecordID, PersonnelID, PatientID, Date, Testcode)
VALUES (4, 2, 4, '2022-11-11 13:23:44', 1);

--Data for PatientTreatments
INSERT INTO PatientTreatments (RecordID, PersonnelID, PatientID, Date, TreatmentCode)
VALUES (0, 0, 0, '2008-08-10 13:23:44', 2);
INSERT INTO PatientTreatments (RecordID, PersonnelID, PatientID, Date, TreatmentCode)
VALUES (1, 2, 2, '2010-10-10 13:23:44', 0);
INSERT INTO PatientTreatments (RecordID, PersonnelID, PatientID, Date, TreatmentCode)
VALUES (2, 2, 3, '2022-11-11 13:23:44', 0);
INSERT INTO PatientTreatments (RecordID, PersonnelID, PatientID, Date, TreatmentCode)
VALUES (3, 2, 4, '2015-08-08 13:23:44', 0);
INSERT INTO PatientTreatments (RecordID, PersonnelID, PatientID, Date, TreatmentCode)
VALUES (4, 2, 4, '2017-09-09 13:23:44', 0);

PRINT ('DATA FROM Personnel')
SELECT * FROM Personnel;
PRINT ('DATA FROM Department')
SELECT * FROM Department;
PRINT ('DATA FROM Email')
SELECT * FROM Email;
PRINT ('DATA FROM Patient')
SELECT * FROM Patient;
PRINT ('DATA FROM Bed')
SELECT * FROM Bed;
PRINT ('DATA FROM Phone')
SELECT * FROM Phone;
PRINT ('DATA FROM Test')
SELECT * FROM Test;
PRINT ('DATA FROM Treatment')
SELECT * FROM Treatment;
PRINT ('DATA FROM PatientTests')
SELECT * FROM PatientTests;
PRINT ('DATA FROM PatientTreatments')
SELECT * FROM PatientTreatments;