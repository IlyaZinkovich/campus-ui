create tablespace CAMPUS_DEV_DATA datafile 'C:\data\oracle11g\campus_dev_tablespace.dbf' size 100m;
create tablespace CAMPUS_TEST_DATA datafile 'C:\data\oracle11g\campus_test_tablespace.dbf' size 100m;
create user CAMPUS_DEV identified by CAMPUS_DEV
default tablespace CAMPUS_DEV_DATA;
grant dba to CAMPUS_DEV;
create user CAMPUS_TEST identified by CAMPUS_TEST
default tablespace CAMPUS_TEST_DATA;
grant dba to CAMPUS_TEST;

CREATE TABLE "CAMPUS_DEV"."ROOMS"
(
	"ID" NUMBER(19,0),
    "CAPACITY" NUMBER(10,0),
    "FLOOR" NUMBER(10,0),
    "ROOMNUMBER" VARCHAR2(255 CHAR),
    CONSTRAINT ROOM_PK PRIMARY KEY ("ID")
);

CREATE TABLE "CAMPUS_DEV"."PROFILES"
(
    "ID" NUMBER(19,0),
	"FIRSTNAME" VARCHAR2(255 CHAR),
	"LASTNAME" VARCHAR2(255 CHAR),
	"GENDER" NUMBER(10,0),
    "BIRTHDATE" DATE,
	"FACULTY" VARCHAR2(255 CHAR),
	"SPECIALITY" VARCHAR2(255 CHAR),
	"COURSE" NUMBER(10,0),
	"GROUP_NUMBER" NUMBER(10,0),
	"ROOM_ID" NUMBER(19,0),
    CONSTRAINT PROFILE_PK PRIMARY KEY ("ID"),
    CONSTRAINT FK_ROOM FOREIGN KEY ("ROOM_ID") REFERENCES "CAMPUS_DEV".ROOMS("ID")
);

INSERT INTO "CAMPUS_DEV"."ROOMS" VALUES(1, 2, 1, '101');
INSERT INTO "CAMPUS_DEV"."ROOMS" VALUES(2, 2, 1, '101A');
INSERT INTO "CAMPUS_DEV"."ROOMS" VALUES(3, 3, 1, '102');
INSERT INTO "CAMPUS_DEV"."ROOMS" VALUES(4, 3, 1, '103');
INSERT INTO "CAMPUS_DEV"."ROOMS" VALUES(5, 3, 1, '104');
INSERT INTO "CAMPUS_DEV"."ROOMS" VALUES(6, 2, 2, '201');
INSERT INTO "CAMPUS_DEV"."ROOMS" VALUES(7, 2, 2, '201A');
INSERT INTO "CAMPUS_DEV"."ROOMS" VALUES(8, 3, 2, '202');
INSERT INTO "CAMPUS_DEV"."ROOMS" VALUES(9, 3, 2, '203');
INSERT INTO "CAMPUS_DEV"."ROOMS" VALUES(10, 3, 2, '204');

INSERT INTO "CAMPUS_DEV"."PROFILES" (ID, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID) VALUES ('1', '1', '1', '0', TO_DATE('1998-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CS', '2', '1', '1');
INSERT INTO "CAMPUS_DEV"."PROFILES" (ID, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID) VALUES ('2', '2', '2', '0', TO_DATE('1997-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CS', '5', '2', '1');
INSERT INTO "CAMPUS_DEV"."PROFILES" (ID, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID) VALUES ('3', '3', '3', '0', TO_DATE('1997-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CS', '3', '2', '2');
INSERT INTO "CAMPUS_DEV"."PROFILES" (ID, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID) VALUES ('4', '4', '4', '1', TO_DATE('1995-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'AppM', '1', '6', '3');
INSERT INTO "CAMPUS_DEV"."PROFILES" (ID, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID) VALUES ('5', '5', '5', '1', TO_DATE('1998-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CS', '2', '2', '3');
INSERT INTO "CAMPUS_DEV"."PROFILES" (ID, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID) VALUES ('6', '6', '6', '1', TO_DATE('1999-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'AppM', '3', '6', '3');
INSERT INTO "CAMPUS_DEV"."PROFILES" (ID, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID) VALUES ('7', '7', '7', '0', TO_DATE('1993-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CompS', '4', '9', '7');
INSERT INTO "CAMPUS_DEV"."PROFILES" (ID, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID) VALUES ('8', '8', '8', '0', TO_DATE('1994-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'AppM', '3', '6', '7');
INSERT INTO "CAMPUS_DEV"."PROFILES" (ID, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID) VALUES ('9', '9', '9', '0', TO_DATE('1997-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CS', '1', '2', '7');
INSERT INTO "CAMPUS_DEV"."PROFILES" (ID, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID) VALUES ('10', '10', '10', '1', TO_DATE('1996-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'AppM', '2', '5', '8');


CREATE TABLE "CAMPUS_TEST"."ROOMS"
(
	"ID" NUMBER(19,0),
    "CAPACITY" NUMBER(10,0),
    "FLOOR" NUMBER(10,0),
    "ROOMNUMBER" VARCHAR2(255 CHAR),
    CONSTRAINT ROOM_PK PRIMARY KEY ("ID")
);

CREATE TABLE "CAMPUS_TEST"."PROFILES"
(
    "ID" NUMBER(19,0),
	"BIRTHDATE" DATE,
	"COURSE" NUMBER(10,0),
	"FACULTY" VARCHAR2(255 CHAR),
	"FIRSTNAME" VARCHAR2(255 CHAR),
	"GENDER" NUMBER(10,0),
	"GROUP_NUMBER" NUMBER(10,0),
	"LASTNAME" VARCHAR2(255 CHAR),
	"SPECIALITY" VARCHAR2(255 CHAR),
	"ROOM_ID" NUMBER(19,0),
    CONSTRAINT PROFILE_PK PRIMARY KEY ("ID"),
    CONSTRAINT FK_ROOM FOREIGN KEY ("ROOM_ID") REFERENCES "CAMPUS_DEV".ROOMS("ID")
);