use a0622i1_coffee;
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO feedback (fb_id,bill_id,name,email,date,content,img_id,type_id,rate) values
('FB_001',1,'Lê Thị Hà','halt@gmail.com','01/06/2023','comment Lê Thị Hà',1,1,5),
('FB_002',2,'Trung Quân','halt@gmail.com','02/06/2023','comment Trung Quân',2,2,2),
('FB_003',3,'Lê Việt Hà','halt@gmail.com','05/06/2023','nội dung đặc biệt',3,2,3);
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO feedback_type (type) values
('Đồ ăn'),
('Đồ uống');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO account (user_name,password) values
('sysadmin','sysadmin'),
('user','sysadmin');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO role (name) values
('admin'),
('user');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO account_role (account_id,role_id) values
(1,1),
(2,2);
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO user (name,address,phone_number,birthday,gender,salary,position_id,account_id,imgUrl) values
('Lê Gia Tú','Quảng Trị','0123456789','10/05/1991',1,10000000,1,1,'url img1'),
('Lê Thị Việt Hà','Quảng Trị','0123456789','`01/01/1994',0,11000000,2,2,'url img1');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO `position` (name) values
('Chủ tiệm'),
('phó chủ tiệm');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO service (name,price,type_id,enable_flag,imgUrl) values
('Caffee 1',50000,1,1,'img 1'),
('Caffee 2',50000,1,1,'img 2'),
('cake 1',60000,2,1,'img 3'),
('cake 2',60000,2,1,'img 4'),
('cake 3',60000,2,1,'img 5');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO type (name) values
('đồ uống'),
('đồ ăn');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO `table` (name,status,enable_flag) values
('bàn vuông','tốt',1),
('bàn tròn','tốt',1),
('bàn cam','xấu',0);
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO bill (created_time,user_id,table_id,payment_status,payment_time) values
('01/06/2023 09:50:30',1,2,1,'01/06/2023 11:10:30'),
('01/06/2023 10:50:30',1,1,1,'01/06/2023 11:10:30'),
('01/06/2023 11:00:30',1,2,1,'01/06/2023 11:10:30'),
('01/06/2023 12:50:30',1,1,1,'01/06/2023 15:10:30'),
('01/06/2023 10:40:30',1,2,1,'01/06/2023 12:10:30');

SET FOREIGN_KEY_CHECKS=0;
INSERT INTO bill_detail (bill_id,service_id,quantity) values
(1,1,5),
(1,2,1),
(2,1,3),
(2,3,3);
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO feedback_img (imgUrl) values
('kjhqdkjhsqkjhd'),
('qksjdhkqhsdjqsd'),
('kqjhdqsjkhdkjhqsd'),
('qkjdshqjshdkqsd');
