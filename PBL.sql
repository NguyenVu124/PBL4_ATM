CREATE TABLE ACCOUNT (
	ID int(6) PRIMARY KEY AUTO_INCREMENT,
    username varchar(30) NOT NULL,
    password varchar(30) NOT NULL,
    type int(1) NOT NULL
);

ALTER TABLE ACCOUNT AUTO_INCREMENT = 1000;

INSERT INTO ACCOUNT(username, password, type) VALUES
('admin', '123', 1),
('huy', '1', 0),
('vu', '1', 0),
('dat', '1', 0);

CREATE TABLE BALANCE (
	ID int(6) NOT NULL,
    balance float(15) NOT NULL
);

INSERT INTO BALANCE (ID, balance) VALUES
(1001, 2000000.0),
(1002, 3000000.0),
(1003, 5000000.0);

ALTER TABLE BALANCE
ADD CONSTRAINT FK_ACCCOUNT_BALANCE
FOREIGN KEY (ID) REFERENCES ACCOUNT(ID)
ON DELETE CASCADE;

CREATE TABLE INFORMATION (
	ID int(6) NOT NULL,
    name varchar(50) NOT NULL,
    phone varchar(11) NOT NULL,
    gender varchar(6) NOT NULL,
    birth date NOT NULL,
    email varchar(50) NOT NULL,
    identitynumber varchar(9) NOT NULL
);

INSERT INTO INFORMATION (ID, name, phone, gender, birth, email, identitynumber) VALUES
(1001, 'Nguyen Kim Huy', '0394123560', 'Male', '1999-11-01', 'nguyenkimhuy@gmail.com', '191967481'),
(1002, 'Hoang Nguyen Vu', '0123456789', 'Male', '2000-04-12', 'hoangnguyenvu@gmail.com', '191969481'),
(1003, 'Van Ngoc Dat', '0123456123', 'Male', '2000-02-10', 'vanngocdat@gmail.com', '191969480');

ALTER TABLE INFORMATION
ADD CONSTRAINT FK_ACCCOUNT_INFORMATION
FOREIGN KEY (ID) REFERENCES ACCOUNT(ID)
ON DELETE CASCADE;

CREATE TABLE MONITORING (
	IDM int(6) PRIMARY KEY AUTO_INCREMENT,
    ID int(6) NOT NULL,
    time datetime NOT NULL,
    description varchar(50) NOT NULL,
    type varchar(50)
);

ALTER TABLE MONITORING
ADD CONSTRAINT FK_ACCCOUNT_MONITORING
FOREIGN KEY (ID) REFERENCES ACCOUNT(ID);

