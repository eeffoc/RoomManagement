``CREATE TABLE `user` (
  `ID` varchar(11),
  `first_name` varchar(20),
  `second_name` varchar(20),
  `password` varchar(20),
  `edit_authorisation` char(1),
  PRIMARY KEY (`ID`)
);

CREATE TABLE `room` (
  `ID` INT AUTO_INCREMENT,
  `type` varchar(20),
  `capacity` int(5),
  `projector` tinyint(1),
  `room_name` varchar(20),
  PRIMARY KEY (`ID`)
);

CREATE TABLE `booking` (
  `ID` INT AUTO_INCREMENT,
  `roomID` int(11),
  `userID` varchar(11),
  `date` date,
  `time` time,
  PRIMARY KEY (`ID`),
  CONSTRAINT fk_User_booking FOREIGN KEY (userID) REFERENCES user(ID),
  CONSTRAINT fk_Room_Booking FOREIGN KEY (roomID) REFERENCES room(ID)
);

INSERT INTO user (ID,first_name,second_name,password,edit_authorisation) VALUES (admin,"John","Smith","password","a"),("A8X 3B8","Guinevere","Roach","OZZ84DOV7MM","u"),("N2X 7U0","Paki","Vasquez","HDA19IKE2KT","u"),("C6T 3D5","Hamilton","Foster","WEP91GSM7HB","u"),("F4I 1V3","Ulla","Berg","URK57QTI0TY","u"),("G9D 2H9","Naomi","Watts","XQV54HND3ME","u"),("A0D 3Z0","Quinn","Mcdonald","UPI04KHG5MG","u"),("J0B 6V3","Nevada","Finch","YBP93DEC5FK","u"),("N4E 1A6","Lamar","Wooten","UNI76BBP6ZD","u"),("N5U 0C5","Adena","Justice","SYJ77ATU8DA","u"),("D1W 3K1","Aidan","Small","HCT73XKJ6QN","u"),("B2U 6A0","Maxine","Noel","MRK86PGB4XY","u"),("P4N 3N4","Fuller","Woods","RRX05CFU0CS","u"),("U6R 3V2","Luke","Moreno","ANE34RST6CY","u"),("F1L 8X6","Taylor","Buchanan","GLM10JSE1AP","u"),("U6F 6R9","Hoyt","Patterson","ACN76SNC3JD","u"),("F9N 1K3","Stacy","Sanchez","ZJL26LRT8ZD","u"),("P9P 4Y9","Lars","Sandoval","RCJ54BII3LN","u"),("J7F 5N4","Renee","Foster","XCV33AHA5XU","u"),("T0P 1K6","Bree","Lucas","UBF45URB1HP","a"),("C7A 3M2","Tad","Goodwin","JXJ48TRE6TC","u"),("A7Q 2H1","Rhona","Robbins","VWX69AZZ2QB","u"),("X1H 1E9","Sybil","Vega","CLK86KQS9IQ","u"),("R5Q 0E1","Rudyard","Moreno","APJ06TKN5OD","u"),("P5L 3X6","Alika","Haney","NBC03IWX9DC","u"),("E8C 5W6","Linda","Hess","TJS41ITD4EG","u"),("S8X 2P3","Maxwell","Morrison","MEE00ENN4AZ","u"),("L1X 6V0","Brian","Bailey","LND87SWD7PQ","u"),("C2X 9Y2","Zachery","Boyle","PSV02SLL1RG","u"),("B4U 2X9","Hayfa","Blackwell","WEW25AVU3GV","u"),("A2N 7U6","Quinlan","Hodge","XRI38YUV8OS","a"),("Z2S 1O4","Breanna","Carney","XDH58ZZM4BY","u"),("F2Y 2N3","Eden","Hyde","SXF15COL3UX","u"),("N5C 3N9","Emi","Carson","WDT40IVI8BD","a"),("J5P 7E1","Lenore","Rodriguez","IVU69UOQ4ZU","u"),("I4J 8E8","Brendan","Tyler","JAI18XVO8VW","u"),("E2Z 5Q0","Cheryl","Britt","VIT51QNI5WA","u"),("T4E 2X8","Lucian","Wise","VYS47UZR2XQ","u"),("A8I 5K8","Chase","Diaz","KPX98VLN2SF","u"),("B7I 0R8","Hedwig","Valdez","BCG01XBY9UL","u"),("S5B 0I5","Molly","Bond","GUX09MGV3EI","u"),("J0H 4P4","Ronan","Gallagher","JST31CTA5YK","u"),("Q4B 9O5","Kendall","Hobbs","ZBJ01SYF8VK","u"),("Y1Q 9B9","Aladdin","Callahan","AEK38FZH2ZA","u"),("P0Q 0Y7","Stewart","Chase","OYS14MHL1OE","u"),("G5Y 6G2","Dylan","Bell","CGA07MXL7HW","u"),("C2Z 6P9","Cullen","Sanford","GHP48PBB5ZY","u"),("K3Z 7F9","Quinlan","Christian","OGC77HPI3UH","u"),("D1H 3W0","Tucker","Neal","KBO76BLU5OO","u"),("R0V 8V3","Ima","Summers","TDV07GDV7YI","u"),("J7W 5Z3","Benjamin","Alford","ZRD87GAO7DD","u"),("P4M 7V3","Kaye","Williamson","KAW09NVY5LB","u"),("V3G 8R4","Britanney","Levine","TKF97AAJ6BB","u"),("L1W 1P9","Fatima","Lamb","CXP94ZKF4XB","u"),("B8F 3W9","Warren","Ewing","OGK80EBH7OC","u"),("R0L 3K2","Ali","Mckinney","XPE45KQP9OM","u"),("K5V 8W2","Isabella","Nunez","OIO02XTW3BC","u"),("A4B 4Z4","Lillian","Haynes","WWA69SPY2NA","u"),("A4J 2G9","Clare","Pate","NCC98KUQ6PA","a"),("P4X 8X5","Jelani","Pollard","QLW19NXF0MZ","u"),("E7M 7T9","Calvin","Burton","QJG90XWO4QN","u"),("N2U 7J5","Shay","Hardy","ABJ59WUO1ZD","u"),("K2Y 1U3","Myles","Cabrera","IZL43LJM5KB","u"),("E0Z 2W4","Solomon","Hodges","BNQ21EZE4CE","u"),("H0F 7W2","Ariel","Burgess","NEL11IYD9SV","u"),("R4W 1G6","Nigel","Bright","PYH17PVS3YF","u"),("V9V 3V1","Alan","Roth","PXS32LJV3GW","u"),("I3I 7J7","Wynne","Salas","KYC30XBR7GB","u"),("O4W 8C0","Maia","Horne","MSZ60DEB9CT","u"),("C7K 0M8","Jana","Burke","LTC92XJP6UD","u"),("Q0W 8E1","Rhea","Crosby","RCM98WHM0TB","u"),("P7R 4U1","Ian","Houston","IJE95NKO6IZ","u"),("E5K 4Z0","Bert","Battle","YEW16YAL5NY","u"),("I5Z 6D7","Xanthus","Barber","YJM81TVR5QC","u"),("X9Z 8L0","Isadora","Roth","UCL71YHZ7KG","a"),("W9D 9V4","Hannah","Jacobs","RTJ72FRE1VC","u"),("N1Q 2O3","Ursa","Shepard","ELW69SSA8JD","u"),("S2I 2M8","Paul","Rowland","ELW89CKK8DS","u"),("V6R 7A4","Jelani","Drake","UZB23GCS5DA","u"),("U3Z 2K4","Judah","Mcknight","POS38EJQ4CZ","u"),("C3L 5O3","Ulla","Pratt","SWO78JDU7IV","u"),("A2W 4W7","Mia","Lambert","OGB67GMY5UR","u"),("T1A 6Z8","Dustin","Stokes","BUE75OJV7PN","u"),("Q5I 4N9","Kirsten","Holland","TVU57RJD2QY","u"),("A1Q 3X8","Kylee","Stark","MLP01CXY0AT","u"),("H4G 8W6","Quinn","Velez","YMT60GTE2BO","u"),("U2P 4F3","Colin","Bonner","DVT25BRQ4XI","u"),("S1F 3I0","Olivia","Witt","MCX22EQG8JU","u"),("J7G 0T0","Naomi","Kirkland","JPY58OUM0PO","a"),("N0L 9A5","Yvette","Dawson","GKN54UGP1RZ","u"),("Z0L 9U0","Hammett","Elliott","NFQ24NCG5NF","u"),("U3V 0B2","Tamekah","Hess","HXP23YWL4BI","u"),("X2R 1R9","Luke","Sellers","ZEW24NRD0ZT","u"),("T5G 4U4","Kimberley","Jordan","JIE48DPV6VM","u"),("M5H 8W0","Grant","Cooley","MGE48UUH8QJ","u"),("U4S 4Q1","Caesar","Norris","JRE67TEA8GT","u"),("S3G 1Q6","Brendan","Wilson","OZP47ZLT8LL","u"),("O3X 7C6","Kevin","Rivera","JYX52ICU5PO","u"),("Z3K 1U7","Leigh","Munoz","BBD10OGY0EM","u"),("C9M 2H6","Renee","Burns","XKD20SKA5ER","u");
INSERT INTO `room` (`type`,`capacity`,`projector`,`room_name`) VALUES ("Teaching Room",159,1,"UW 3.95"),("Teaching Room",17,0,"UY 2.47"),("Teaching Room",17,1,"QO 5.72"),("Computer Lab",140,1,"YQ 0.32"),("Lecture Hall",196,1,"NZ 9.23"),("Computer Lab",197,1,"JL 2.41"),("Computer Lab",143,1,"QO 3.44"),("Teaching Room",55,0,"QR 8.67"),("Lecture Hall",83,1,"FN 2.38"),("Teaching Room",161,1,"YN 6.11"),("Teaching Room",37,0,"PX 8.26"),("Teaching Room",114,1,"BB 9.34"),("Teaching Room",182,0,"WK 0.55"),("Teaching Room",174,0,"CX 2.75"),("Teaching Room",187,1,"CA 2.88"),("Lecture Hall",200,1,"XU 1.12"),("Computer Lab",182,0,"NF 8.63"),("Teaching Room",43,1,"SU 4.30"),("Computer Lab",98,0,"CT 4.17"),("Computer Lab",23,0,"IB 9.00"),("Teaching Room",141,0,"PV 1.09"),("Teaching Room",66,1,"YO 2.57"),("Computer Lab",92,1,"XS 8.21"),("Computer Lab",57,0,"SN 3.07"),("Teaching Room",114,1,"RN 9.87"),("Teaching Room",46,1,"XR 2.38"),("Computer Lab",73,0,"KJ 4.59"),("Teaching Room",134,0,"WE 4.57"),("Computer Lab",68,1,"IU 1.76"),("Teaching Room",24,1,"BT 6.90"),("Teaching Room",92,1,"CW 4.81"),("Lecture Hall",64,1,"FV 8.85"),("Computer Lab",17,1,"HL 9.86"),("Teaching Room",13,1,"QV 6.95"),("Teaching Room",137,1,"YC 9.96"),("Lecture Hall",165,1,"BS 7.01"),("Lecture Hall",95,0,"SA 9.86"),("Computer Lab",23,1,"YN 8.65"),("Computer Lab",187,0,"TL 8.52"),("Computer Lab",125,1,"XQ 9.51"),("Lecture Hall",22,1,"WE 0.26"),("Teaching Room",105,1,"WQ 5.29"),("Lecture Hall",71,0,"PH 7.84"),("Computer Lab",121,1,"NP 0.63"),("Lecture Hall",74,1,"PE 2.54"),("Lecture Hall",140,1,"LA 7.47"),("Lecture Hall",150,1,"TN 6.17"),("Computer Lab",40,0,"TN 7.63"),("Lecture Hall",200,0,"WR 5.00"),("Lecture Hall",84,0,"RE 7.29"),("Teaching Room",199,1,"GY 3.23"),("Teaching Room",132,1,"BH 4.80"),("Lecture Hall",85,1,"WC 9.36"),("Lecture Hall",182,1,"VR 4.98"),("Lecture Hall",55,1,"KX 4.81"),("Teaching Room",143,1,"SS 2.54"),("Computer Lab",75,1,"IG 2.16"),("Teaching Room",93,1,"IH 6.34"),("Lecture Hall",131,1,"HB 1.89"),("Lecture Hall",161,1,"IL 7.06"),("Teaching Room",193,0,"BK 3.28"),("Computer Lab",192,1,"KR 5.27"),("Computer Lab",35,0,"GZ 2.83"),("Computer Lab",77,0,"SS 7.23"),("Computer Lab",72,0,"AB 1.94"),("Lecture Hall",193,1,"QR 9.26"),("Teaching Room",41,0,"UZ 8.70"),("Teaching Room",63,1,"WZ 2.73"),("Lecture Hall",157,1,"ZT 3.51"),("Computer Lab",56,1,"LT 3.86"),("Computer Lab",149,0,"DP 2.51"),("Computer Lab",173,0,"KA 5.40"),("Teaching Room",145,1,"YF 4.86"),("Lecture Hall",19,1,"YL 7.65"),("Lecture Hall",200,1,"AD 8.12"),("Computer Lab",110,1,"CN 9.66"),("Teaching Room",197,0,"PX 7.58"),("Computer Lab",132,0,"ZI 3.14"),("Teaching Room",25,0,"TS 3.92"),("Lecture Hall",20,0,"DT 8.69"),("Teaching Room",199,0,"CJ 1.99"),("Lecture Hall",95,0,"TC 9.31"),("Teaching Room",147,1,"RQ 5.02"),("Lecture Hall",164,0,"US 9.66"),("Teaching Room",116,0,"ZR 5.95"),("Teaching Room",93,1,"AU 4.30"),("Lecture Hall",168,0,"DQ 4.46"),("Computer Lab",169,1,"XU 7.65"),("Computer Lab",100,1,"EM 7.46"),("Computer Lab",45,0,"FO 5.71"),("Lecture Hall",75,1,"BX 2.68"),("Teaching Room",67,1,"TA 2.30"),("Lecture Hall",115,0,"KE 2.19"),("Lecture Hall",186,0,"YP 6.41"),("Lecture Hall",58,1,"GE 7.09"),("Teaching Room",80,1,"VW 0.99"),("Teaching Room",14,0,"KU 7.79"),("Teaching Room",16,0,"HX 3.31"),("Computer Lab",32,0,"JL 5.98"),("Lecture Hall",154,1,"SX 9.48");


INSERT INTO `booking` (`roomID`,`userID`,`date`,`time`) VALUES (55,"admin","2017-12-14","22:00:00"),(57,"admin","2017-06-08","00:00:00"),(30,"admin","2018-01-19","05:00:00"),(43,"admin","2018-01-26","18:00:00"),(7,"admin","2017-03-11","03:00:00"),(85,"admin","2017-07-21","16:00:00"),(48,"admin","2018-01-22","13:00:00"),(35,"admin","2017-12-04","09:00:00"),(87,"admin","2017-07-29","12:00:00"),(54,"admin","2017-10-18","12:00:00");
INSERT INTO `booking` (`roomID`,`userID`,`date`,`time`) VALUES (11,"admin","2018-01-11","07:00:00"),(25,"admin","2017-12-13","07:00:00"),(42,"admin","2017-03-10","17:00:00"),(48,"admin","2017-11-06","17:00:00"),(55,"admin","2017-03-19","12:00:00"),(89,"admin","2017-05-16","09:00:00"),(89,"admin","2017-04-20","01:00:00"),(15,"admin","2017-05-15","09:00:00"),(58,"admin","2017-09-14","22:00:00"),(92,"admin","2017-10-26","18:00:00");
INSERT INTO `booking` (`roomID`,`userID`,`date`,`time`) VALUES (34,"admin","2017-05-03","20:00:00"),(77,"admin","2017-05-05","14:00:00"),(96,"admin","2017-07-20","00:00:00"),(37,"admin","2017-06-22","22:00:00"),(6,"admin","2017-07-23","13:00:00"),(75,"admin","2017-11-24","20:00:00"),(36,"admin","2018-01-24","10:00:00"),(70,"admin","2017-05-09","17:00:00"),(8,"admin","2017-11-02","17:00:00"),(82,"admin","2017-08-08","07:00:00");
INSERT INTO `booking` (`roomID`,`userID`,`date`,`time`) VALUES (58,"admin","2017-08-28","12:00:00"),(39,"admin","2017-06-07","13:00:00"),(85,"admin","2017-07-15","14:00:00"),(79,"admin","2017-06-22","10:00:00"),(72,"admin","2018-01-14","23:00:00"),(96,"admin","2017-04-17","13:00:00"),(97,"admin","2017-03-23","19:00:00"),(87,"admin","2017-04-20","18:00:00"),(67,"admin","2017-11-21","20:00:00"),(6,"admin","2017-06-26","10:00:00");
INSERT INTO `booking` (`roomID`,`userID`,`date`,`time`) VALUES (90,"admin","2017-05-08","16:00:00"),(21,"admin","2017-07-10","08:00:00"),(28,"admin","2017-06-02","03:00:00"),(16,"admin","2017-06-11","00:00:00"),(28,"admin","2017-07-11","04:00:00"),(15,"admin","2017-03-02","20:00:00"),(73,"admin","2017-06-08","07:00:00"),(5,"admin","2017-09-06","12:00:00"),(65,"admin","2017-06-10","14:00:00"),(72,"admin","2018-01-19","18:00:00");
INSERT INTO `booking` (`roomID`,`userID`,`date`,`time`) VALUES (45,"admin","2017-07-23","03:00:00"),(73,"admin","2017-08-16","07:00:00"),(91,"admin","2017-12-30","13:00:00"),(46,"admin","2017-09-23","01:00:00"),(79,"admin","2018-01-17","12:00:00"),(95,"admin","2017-06-14","16:00:00"),(32,"admin","2017-11-21","23:00:00"),(47,"admin","2017-06-04","11:00:00"),(23,"admin","2017-04-03","23:00:00"),(63,"admin","2017-05-11","17:00:00");
INSERT INTO `booking` (`roomID`,`userID`,`date`,`time`) VALUES (67,"admin","2017-03-19","15:00:00"),(62,"admin","2017-10-24","16:00:00"),(68,"admin","2017-09-24","08:00:00"),(17,"admin","2017-03-02","10:00:00"),(17,"admin","2017-05-23","00:00:00"),(67,"admin","2017-04-17","03:00:00"),(43,"admin","2017-04-17","18:00:00"),(6,"admin","2018-01-01","12:00:00"),(48,"admin","2017-03-24","21:00:00"),(90,"admin","2017-12-22","04:00:00");
INSERT INTO `booking` (`roomID`,`userID`,`date`,`time`) VALUES (86,"admin","2017-10-27","22:00:00"),(11,"admin","2017-06-13","04:00:00"),(59,"admin","2017-05-27","00:00:00"),(66,"admin","2017-05-10","02:00:00"),(97,"admin","2017-04-21","04:00:00"),(59,"admin","2017-04-12","01:00:00"),(66,"admin","2017-11-30","23:00:00"),(31,"admin","2017-07-21","18:00:00"),(1,"admin","2017-06-14","11:00:00"),(78,"admin","2017-09-23","11:00:00");
INSERT INTO `booking` (`roomID`,`userID`,`date`,`time`) VALUES (78,"admin","2017-03-09","20:00:00"),(76,"admin","2017-07-22","08:00:00"),(37,"admin","2017-11-14","16:00:00"),(2,"admin","2017-05-04","12:00:00"),(58,"admin","2017-07-01","02:00:00"),(81,"admin","2017-05-26","18:00:00"),(97,"admin","2017-11-25","08:00:00"),(2,"admin","2018-01-07","22:00:00"),(28,"admin","2017-10-01","09:00:00"),(72,"admin","2017-08-21","10:00:00");
INSERT INTO `booking` (`roomID`,`userID`,`date`,`time`) VALUES (70,"admin","2017-03-26","23:00:00"),(73,"admin","2017-08-20","23:00:00"),(43,"admin","2017-03-02","01:00:00"),(60,"admin","2017-10-09","08:00:00"),(59,"admin","2017-11-07","22:00:00"),(86,"admin","2017-04-20","11:00:00"),(60,"admin","2018-01-30","12:00:00"),(1,"admin","2017-06-15","23:00:00"),(93,"admin","2017-07-20","11:00:00"),(83,"admin","2017-06-17","03:00:00");


UPDATE booking SET userID = (SELECT ID FROM user ORDER BY RAND() LIMIT 1);
