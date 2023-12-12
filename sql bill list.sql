ALTER TABLE material DROP COLUMN type;
ALTER TABLE material
RENAME COLUMN type to type_id;
select * from material;
-- Tạo bảng material_type_master
CREATE TABLE material_type_master (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

-- Thêm một số dữ liệu mẫu vào bảng material_type_master
INSERT INTO material_type_master (name) VALUES ('Tiêu Hao');
INSERT INTO material_type_master (name) VALUES ('Vật dụng');

-- Tạo bảng material
CREATE TABLE material (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  type_id INT,
  price DOUBLE,
  unit VARCHAR(10),
  quantity DOUBLE,
  FOREIGN KEY (type) REFERENCES material_type_master(id)
);

-- Thêm một số dữ liệu mẫu vào bảng material
INSERT INTO material (name, type, price, unit, quantity) VALUES ('Đường', 1, 20000, 'gr', 500);
INSERT INTO material (name, type, price, unit, quantity) VALUES ('Sữa', 1, 40000, 'gr', 1000);
INSERT INTO material (name, type, price, unit, quantity) VALUES ('Cafe bột', 1, 100000, 'gr', 500);


ALTER TABLE service
ADD COLUMN `describe` VARCHAR(300);

CREATE TABLE recipe_master (
  id INT AUTO_INCREMENT PRIMARY KEY,
  service_id INT,
  material_id INT,
  quantity DOUBLE,
  price DOUBLE,
  FOREIGN KEY (service_id) REFERENCES service(id),
  FOREIGN KEY (material_id) REFERENCES material(id)
);
INSERT INTO recipe_master (service_id, material_id, quantity, price)
VALUES
(1, 1, 100, 2.5),
(1, 2, 50, 1.25),
(1, 3, 40, 0.2),
(2, 1, 100, 2.5),
(2, 2, 50, 1.25),
(2, 3, 40, 0.2);

select * from service;
select * from recipe_master;
select * from material;


select rm.id id , m.name name, rm.quantity quantity, m.unit unit, rm.price price from recipe_master rm
left join service s on s.id = rm.service_id
left join material m on m.id = rm.material_id
where s.id = 1