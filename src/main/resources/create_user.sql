INSERT INTO `users` VALUES (1,1,1,'$2a$10$Mu7GLxcpArEOZLefa66XVeQV/wiAYVuZE4HERvN80JmPDWgWTTSvm','admin');
INSERT INTO `users` VALUES (3,1,1,'$2a$10$7lzFZDLLyyg9ox9wlPuy2.Hkdt0eZNQ23rNwZR1YqDVUqTy09WFpa','minhsang');

INSERT INTO `authorities` VALUES (1,'ROLE_ADMIN','admin');
INSERT INTO `authorities` VALUES (2,'ROLE_USER','minhsang');

INSERT INTO `billingaddress` VALUES (1,'','Fairfield','United States','Iowa','1000 N 4th St','52557',1);
INSERT INTO `cart` VALUES (1,0,1);
INSERT INTO `customer` VALUES (1,'ngminhsang@gmail.com','Sang Nguyen','6613022305',1,'$2a$10$7lzFZDLLyyg9ox9wlPuy2.Hkdt0eZNQ23rNwZR1YqDVUqTy09WFpa','minhsang');
INSERT INTO `shippingaddress` VALUES (1,'','Fairfield','United States','Iowa','1000 N 4th St','52557',1);