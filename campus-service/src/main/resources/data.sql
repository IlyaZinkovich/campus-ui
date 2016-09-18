INSERT INTO "ROOMS" VALUES(1, 2, 1, '101');
INSERT INTO "ROOMS" VALUES(2, 2, 1, '101A');
INSERT INTO "ROOMS" VALUES(3, 3, 1, '102');
INSERT INTO "ROOMS" VALUES(4, 3, 1, '103');
INSERT INTO "ROOMS" VALUES(5, 3, 1, '104');
INSERT INTO "ROOMS" VALUES(6, 2, 2, '201');
INSERT INTO "ROOMS" VALUES(7, 2, 2, '201A');
INSERT INTO "ROOMS" VALUES(8, 3, 2, '202');
INSERT INTO "ROOMS" VALUES(9, 3, 2, '203');
INSERT INTO "ROOMS" VALUES(10, 3, 2, '204');

INSERT INTO "STUDENTS" (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID, IMAGE_PATH) VALUES ('1', 'Ilya', 'Zinkovich', '0', TO_DATE('1998-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CS', '2', '1', '1', 'assets/resources/img/boy-4.svg');
INSERT INTO "STUDENTS" (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID, IMAGE_PATH) VALUES ('2', 'Stas', 'Kolodyuk', '0', TO_DATE('1997-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CS', '5', '2', '1', 'assets/resources/img/boy-3.svg');
INSERT INTO "STUDENTS" (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID, IMAGE_PATH) VALUES ('3', 'Stepan', 'Tsybulski', '0', TO_DATE('1997-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CS', '3', '2', '2', 'assets/resources/img/boy-1.svg');
INSERT INTO "STUDENTS" (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID, IMAGE_PATH) VALUES ('4', 'Marina', 'Kuzminchuk', '1', TO_DATE('1995-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'AppM', '1', '6', '3', 'assets/resources/img/girl-4.svg');
INSERT INTO "STUDENTS" (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID, IMAGE_PATH) VALUES ('5', 'Ira', 'Chehovich', '1', TO_DATE('1998-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CS', '2', '2', '3', 'assets/resources/img/girl-1.svg');
INSERT INTO "STUDENTS" (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID, IMAGE_PATH) VALUES ('6', 'Masha', 'Paulavets', '1', TO_DATE('1999-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'AppM', '3', '6', '3', 'assets/resources/img/girl-2.svg');
INSERT INTO "STUDENTS" (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID, IMAGE_PATH) VALUES ('7', 'Kolya', 'Podkovko', '0', TO_DATE('1993-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CompS', '4', '9', '7', 'assets/resources/img/boy.svg');
INSERT INTO "STUDENTS" (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID, IMAGE_PATH) VALUES ('8', 'Jenya', 'Gurkov', '0', TO_DATE('1994-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'AppM', '3', '6', '7', 'assets/resources/img/boy-2.svg');
INSERT INTO "STUDENTS" (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID, IMAGE_PATH) VALUES ('9', 'Liza', 'Zdanevich', '1', TO_DATE('1997-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'CS', '1', '2', '8', 'assets/resources/img/girl.svg');
INSERT INTO "STUDENTS" (ID, FIRST_NAME, LAST_NAME, GENDER, BIRTH_DATE, FACULTY, SPECIALITY, COURSE, GROUP_NUMBER, ROOM_ID, IMAGE_PATH) VALUES ('10', 'Kristina', 'Balashova', '1', TO_DATE('1996-08-15 14:04:13', 'YYYY-MM-DD HH24:MI:SS'), 'FAMCS', 'AppM', '2', '5', '8', 'assets/resources/img/girl-3.svg');

INSERT INTO "CAMPUS_USERS" (ID, LOGIN, PASSWORD, ROLE, STUDENT_ID) VALUES ('1', '1', '$2a$10$OFKf0NlsA2CXGFf4oSBx5uow22XGu7Ja5oi3cBTqChamA.rBlccRe', '0', '1');
INSERT INTO "CAMPUS_USERS" (ID, LOGIN, PASSWORD, ROLE, STUDENT_ID) VALUES ('2', '2', '$2a$10$OFKf0NlsA2CXGFf4oSBx5uow22XGu7Ja5oi3cBTqChamA.rBlccRe', '0', '4');
INSERT INTO "CAMPUS_USERS" (ID, LOGIN, PASSWORD, ROLE, STUDENT_ID) VALUES ('3', '3', '$2a$10$OFKf0NlsA2CXGFf4oSBx5uow22XGu7Ja5oi3cBTqChamA.rBlccRe', '0', '2');
INSERT INTO "CAMPUS_USERS" (ID, LOGIN, PASSWORD, ROLE, STUDENT_ID) VALUES ('4', '4', '$2a$10$OFKf0NlsA2CXGFf4oSBx5uow22XGu7Ja5oi3cBTqChamA.rBlccRe', '0', '3');
INSERT INTO "CAMPUS_USERS" (ID, LOGIN, PASSWORD, ROLE, STUDENT_ID) VALUES ('5', '5', '$2a$10$OFKf0NlsA2CXGFf4oSBx5uow22XGu7Ja5oi3cBTqChamA.rBlccRe', '0', '7');
INSERT INTO "CAMPUS_USERS" (ID, LOGIN, PASSWORD, ROLE, STUDENT_ID) VALUES ('6', '6', '$2a$10$OFKf0NlsA2CXGFf4oSBx5uow22XGu7Ja5oi3cBTqChamA.rBlccRe', '0', '6');
INSERT INTO "CAMPUS_USERS" (ID, LOGIN, PASSWORD, ROLE, STUDENT_ID) VALUES ('7', '7', '$2a$10$OFKf0NlsA2CXGFf4oSBx5uow22XGu7Ja5oi3cBTqChamA.rBlccRe', '0', '5');
INSERT INTO "CAMPUS_USERS" (ID, LOGIN, PASSWORD, ROLE, STUDENT_ID) VALUES ('8', '8', '$2a$10$OFKf0NlsA2CXGFf4oSBx5uow22XGu7Ja5oi3cBTqChamA.rBlccRe', '0', '9');
INSERT INTO "CAMPUS_USERS" (ID, LOGIN, PASSWORD, ROLE, STUDENT_ID) VALUES ('9', '9', '$2a$10$OFKf0NlsA2CXGFf4oSBx5uow22XGu7Ja5oi3cBTqChamA.rBlccRe', '0', '8');
INSERT INTO "CAMPUS_USERS" (ID, LOGIN, PASSWORD, ROLE, STUDENT_ID) VALUES ('10', '10', '$2a$10$OFKf0NlsA2CXGFf4oSBx5uow22XGu7Ja5oi3cBTqChamA.rBlccRe', '0', '10');

INSERT INTO "CAMPUS_GROUPS" VALUES (1, 'All Students', 'assets/resources/img/group.svg');
INSERT INTO "CAMPUS_GROUPS" VALUES (2, 'Sports', 'assets/resources/img/group.svg');
INSERT INTO "CAMPUS_GROUPS" VALUES (3, 'Music', 'assets/resources/img/group.svg');
INSERT INTO "CAMPUS_GROUPS" VALUES (4, 'Dancing', 'assets/resources/img/group.svg');
INSERT INTO "CAMPUS_GROUPS" VALUES (5, 'Games', 'assets/resources/img/group.svg');
INSERT INTO "CAMPUS_GROUPS" VALUES (6, 'Walking', 'assets/resources/img/group.svg');
INSERT INTO "CAMPUS_GROUPS" VALUES (7, 'Food', 'assets/resources/img/group.svg');
INSERT INTO "CAMPUS_GROUPS" VALUES (8, 'Fashion', 'assets/resources/img/group.svg');
INSERT INTO "CAMPUS_GROUPS" VALUES (9, 'FAMCS', 'assets/resources/img/group.svg');
INSERT INTO "CAMPUS_GROUPS" VALUES (10, 'Philological Faculty', 'assets/resources/img/group.svg');

INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (1, 1);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (1, 2);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (1, 3);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (1, 6);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (1, 7);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (1, 8);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (1, 9);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (2, 1);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (2, 3);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (2, 4);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (2, 5);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (2, 6);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (2, 8);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (2, 9);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (3, 1);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (4, 1);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (5, 1);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (6, 1);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (7, 1);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (8, 1);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (9, 1);
INSERT INTO "STUDENT_GROUPS" (STUDENT_ID, GROUP_ID) VALUES (10, 1);

INSERT INTO "GROUP_MESSAGE" VALUES (1, 'Hi and welcome to Campus, Meet people that like you too', 1, 1);
INSERT INTO "GROUP_MESSAGE" VALUES (2, 'Go to the students page and see everyone who lives in Campus', 1, 1);
INSERT INTO "GROUP_MESSAGE" VALUES (3, 'Is there anyone who likes sports?', 2, 1);