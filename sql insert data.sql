use a0622i1_coffee;
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO feedback (fb_id,bill_id,name,email,date,content,type_id,rate) values
('FB_001',1,'Lê Thị Hà','halt@gmail.com','01-06-2023','comment Lê Thị Hà',1,5),
('FB_002',2,'Trung Quân','halt@gmail.com','02-06-2023','comment Trung Quân',2,2),
('FB_003',3,'Lê Việt Hà','halt@gmail.com','05-06-2023','nội dung đặc biệt',2,3);
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO feedback_type (type) values
('Đồ ăn'),
('Đồ uống');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO account (user_name,password,verification_code,email, enable_flag) values
('sysadmin','sysadmin','dqdsqdqsdq1dw1dw1d','admin@gmail.com',1),
('user','sysadmin','sdqsdqd121d1wdw1','user@gmail.com',1);
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO role (name) values
('admin'),
('user');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO account_role (account_id,role_id) values
(1,1),
(2,2);
SET FOREIGN_KEY_CHECKS=0;
truncate table user;
update user set enable_flag = 1 where id <=2;
INSERT INTO user (name, address, phone_number, birthday, gender, salary, position_id, account_id, enable_flag, img_Url)
VALUES
  ('Lê Gia Tú', 'Quảng Trị', '0123456789', '1991-05-10', 1, 10000000, 1, 1, 0, 'url_img1'),
  ('Lê Thị Việt Hà', 'Quảng Trị', '0123456789', '1994-01-01', 0, 11000000, 2, 2, 0, 'url_img1'),
  ('Huỳnh Minh Cường', 'Đà Nẵng', '0123456789', '1985-03-15', 1, 12000000, 1, 3, 1, 'url_img2'),
  ('Lê Văn An', 'Quảng Nam', '0123456789', '1987-11-25', 0, 13000000, 1, 4, 1, 'url_img3'),
  ('Trần Sĩ Tiến', 'Huế', '0123456789', '1986-08-03', 1, 14000000, 1, 5, 0, 'url_img4'),
  ('Nguyễn Thị Hương', 'Hà Nội', '0123456789', '1984-07-12', 0, 15000000, 2, 6, 1, 'url_img5'),
  ('Phạm Văn Đức', 'Hồ Chí Minh', '0123456789', '1982-09-20', 1, 16000000, 1, 7, 0, 'url_img6'),
  ('Trần Thị Hạnh', 'Đà Nẵng', '0123456789', '1989-12-05', 0, 17000000, 2, 8, 1, 'url_img7'),
  ('Lê Văn Hùng', 'Quảng Nam', '0123456789', '1988-06-28', 1, 18000000, 1, 9, 0, 'url_img8'),
  ('Nguyễn Thị Thúy', 'Huế', '0123456789', '1983-10-18', 0, 19000000, 2, 10, 1, 'url_img9'),
  ('Trần Văn Hiệp', 'Hà Nội', '0123456789', '1981-04-08', 1, 20000000, 1, 11, 0, 'url_img10'),
  ('Lê Thị Ngọc', 'Hồ Chí Minh', '0123456789', '1980-02-16', 0, 21000000, 2, 12, 1, 'url_img11'),
  ('Nguyễn Văn Tuấn', 'Đà Nẵng', '0123456789', '1978-09-30', 1, 22000000, 1, 13, 0, 'url_img12'),
  ('Trần Thị Mai', 'Quảng Nam', '0123456789', '1976-11-09', 0, 23000000, 2, 14, 1, 'url_img13'),
  ('Lê Văn Long', 'Huế', '0123456789', '1974-08-17', 1, 24000000, 1, 15, 0, 'url_img14'),
  ('Nguyễn Thị Thanh', 'Hà Nội', '0123456789', '1973-03-25', 0, 25000000, 2, 16, 1, 'url_img15'),
  ('Trần Văn Quân', 'Hồ Chí Minh', '0123456789', '1971-12-01', 1, 26000000, 1, 17, 0, 'url_img16'),
  ('Lê Thị Lan', 'Đà Nẵng', '0123456789', '1969-07-07', 0, 27000000, 2, 18, 1, 'url_img17'),
  ('Nguyễn Văn Đại', 'Quảng Nam', '0123456789', '1967-04-13', 1, 28000000, 1, 19, 0, 'url_img18'),
  ('Trần Thị Minh', 'Huế', '0123456789', '1965-10-28', 0, 29000000, 2, 20, 1, 'url_img19'),
   ('Nguyễn Văn Tài', 'Hà Nội', '0123456789', '1963-08-09', 1, 30000000, 1, 21, 0, 'url_img20'),
  ('Trần Thị Nga', 'Hồ Chí Minh', '0123456789', '1961-02-20', 0, 31000000, 2, 22, 1, 'url_img21'),
  ('Lê Văn Dũng', 'Đà Nẵng', '0123456789', '1959-11-30', 1, 32000000, 1, 23, 0, 'url_img22'),
  ('Nguyễn Thị Quỳnh', 'Quảng Nam', '0123456789', '1957-07-05', 0, 33000000, 2, 24, 1, 'url_img23'),
  ('Trần Văn Hoàng', 'Huế', '0123456789', '1955-04-11', 1, 34000000, 1, 25, 0, 'url_img24'),
  ('Lê Thị Tuyết', 'Hà Nội', '0123456789', '1953-09-25', 0, 35000000, 2, 26, 1, 'url_img25'),
  ('Nguyễn Văn Thành', 'Hồ Chí Minh', '0123456789', '1951-06-05', 1, 36000000, 1, 27, 0, 'url_img26'),
  ('Trần Thị Phượng', 'Đà Nẵng', '0123456789', '1949-03-15', 0, 37000000, 2, 28, 1, 'url_img27'),
  ('Lê Văn Hải', 'Quảng Nam', '0123456789', '1947-10-25', 1, 38000000, 1, 29, 0, 'url_img28'),
  ('Nguyễn Thị Ánh', 'Huế', '0123456789', '1945-12-05', 0, 39000000, 2, 30, 1, 'url_img29'),
  ('Trần Văn Minh', 'Hà Nội', '0123456789', '1943-07-12', 1, 40000000, 1, 31, 0, 'url_img30'),
  ('Lê Thị Lan', 'Hồ Chí Minh', '0123456789', '1941-04-22', 0, 41000000, 2, 32, 1, 'url_img31'),
  ('Nguyễn Văn Hưng', 'Đà Nẵng', '0123456789', '1939-09-02', 1, 42000000, 1, 33, 0, 'url_img32'),
  ('Trần Thị Linh', 'Quảng Nam', '0123456789', '1937-06-14', 0, 43000000, 2, 34, 1, 'url_img33'),
  ('Lê Văn Thắng', 'Huế', '0123456789', '1935-03-27', 1, 44000000, 1, 35, 0, 'url_img34'),
  ('Nguyễn Thị Hạnh', 'Hà Nội', '0123456789', '1933-11-08', 0, 45000000, 2, 36, 1, 'url_img35'),
  ('Trần Văn Dương', 'Hồ Chí Minh', '0123456789', '1931-08-19', 1, 46000000, 1, 37, 0, 'url_img36'),
  ('Lê Thị Thu', 'Đà Nẵng', '0123456789', '1929-05-31', 0, 47000000, 2, 38, 1, 'url_img37'),
  ('Nguyễn Văn Quang', 'Quảng Nam', '0123456789', '1927-03-12', 1, 48000000, 1, 39, 0, 'url_img38'),
  ('Trần Thị Bình', 'Huế', '0123456789', '1925-10-23', 0, 49000000, 2, 40, 1, 'url_img39');
INSERT INTO user (name,address,phone_number,birthday,gender,salary,position_id,account_id,enable_flag,imgUrl) values
('Lê Gia Tú','Quảng Trị','0123456789','1991-05-10',1,10000000,1,1,0,'url img1'),
('Lê Thị Việt Hà','Quảng Trị','0123456789','1994-01-01',0,11000000,2,2,0,'url img1'),
('Huỳnh Minh Cường','Đà Nẵng','0123456789','1994-01-01',1,11000000,1,3,0,'url img2'),
('Lê Văn An','Quảng Nam','0123456789','1994-01-01',0,11000000,1,4,0,'url img3'),
('Trần Sĩ Tiến','Huế','0123456789','1994-01-01',1,11000000,1,5,0,'url img4'),
('nobody','','','',1,1,1,5,0,'url img4');
delimiter //
create procedure sp_deleteUser(IN deleteId int)
begin
	SET FOREIGN_KEY_CHECKS=0;
	delete from user where id = deleteId;
end//
delimiter ;
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
INSERT INTO service_type (name) values
('đồ uống'),
('đồ ăn'),
('Trái cây');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO `table` (name,status,enable_flag) values
('bàn vuông','tốt',1),
('bàn tròn','tốt',1),
('bàn cam','xấu',0),
('bàn đỏ','xấu',1),
('bàn lục','tốt',1),
('bàn lam','tốt',0),
('bàn tím','xấu',1),
('bàn vàng','tốt',0),
('bàng đen','xấu',0),
('bàn nâu','tốt',1);
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO bill (created_time,user_id,table_id,payment_status,payment_time) values
('01-06-2023 09:50:30',1,2,1,'01-06-2023 11:10:30'),
('01-06-2023 10:50:30',1,1,1,'01-06-2023 11:10:30'),
('01-06-2023 11:00:30',1,2,1,'01-06-2023 11:10:30'),
('01-06-2023 12:50:30',1,1,1,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',1,2,1,'01-06-2023 12:10:30'),
('02-06-2023 10:40:30',2,10,1,'02-06-2023 11:40:30'),
('03-06-2023 10:40:30',3,2,0,'03-06-2023 11:40:30'),
('04-06-2023 10:40:30',5,4,0,'04-06-2023 11:40:30'),
('05-06-2023 10:40:30',4,5,0,'05-06-2023 11:40:30'),
('06-06-2023 10:40:30',1,3,0,'06-06-2023 15:10:30'),
('07-06-2023 10:40:30',2,2,1,'07-06-2023 15:10:30'),
('08-06-2023 10:40:30',3,5,1,'08-06-2023 15:10:30'),
('09-06-2023 10:40:30',4,5,1,'09-06-2023 15:10:30'),
('10-06-2023 10:40:30',5,2,0,'10-06-2023 15:10:30'),
('11-06-2023 10:40:30',5,7,1,'01-06-2023 15:10:30'),
('12-06-2023 10:40:30',1,8,0,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',2,4,1,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',4,9,0,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',3,3,1,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',2,6,0,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',4,7,0,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',2,1,1,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',5,4,0,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',5,2,0,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',3,7,0,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',5,8,1,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',1,9,1,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',4,10,0,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',2,5,1,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',5,3,0,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',2,6,1,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',3,8,1,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',5,5,0,'01-06-2023 15:10:30'),
('01-06-2023 10:40:30',3,3,1,'01-06-2023 15:10:30');
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO bill_detail (bill_id,service_id,quantity) values
(1,1,5),
(1,2,1),
(2,1,3),
(2,3,3),
(2,2,10),
(4,1,2),
(4,2,4),
(4,3,3),
(5,5,3),
(6,1,5),
(7,2,2),
(8,3,9),
(9,4,7),
(10,5,2),
(11,3,6),
(12,1,3),
(13,1,3),
(14,2,5),
(15,3,4),
(15,4,5),
(16,1,3),
(16,5,2),
(17,4,1),
(18,2,3),
(19,1,3),
(20,3,2),
(21,1,3),
(22,2,2),
(23,3,8),
(24,4,4),
(25,5,3),
(26,2,5),
(27,1,7),
(28,3,6),
(29,4,5),
(30,5,3),
(31,3,3),
(32,1,2),
(33,1,3),
(34,5,4),
(5,4,1),
(22,1,3),
(11,5,4),
(34,4,5),
(5,1,6),
(6,2,3),
(4,4,4),
(2,5,3),
(1,5,3),
(33,3,7),
(11,2,3),
(23,1,5),
(11,2,3),
(25,4,2),
(26,5,1),
(27,3,6),
(28,1,4);
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO feedback_img (feedback_id, imgUrl) values
(1,'kjhqdkjhsqkjhd'),
(1,'kjhqdkjhsqkjhd'),
(1,'qksjdhkqhsdjqsd'),
(1,'kqjhdqsjkhdkjhqsd'),
(1,'qkjdshqjshdkqsd');

SELECT b.id, b.created_time AS createdTime, t.id AS tableNumber, u.name takeOrderUserId , u1.name takePaymentUserId, sum(bd.quantity*s.price) AS totalPrice FROM  bill b
	JOIN `table` t ON b.table_id = t.id
	JOIN user u ON b.take_order_user_id =u.id
	JOIN user u1 ON b.take_payment_user_id =u1.id
	JOIN bill_detail bd ON bd.bill_id = b.id
	JOIN service s ON bd.service_id = s.id
	GROUP BY b.id
	ORDER BY b.id;