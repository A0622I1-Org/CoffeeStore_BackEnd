ALTER TABLE material DROP COLUMN imgUrl;
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
ADD COLUMN `describe` VARCHAR(300),
ADD COLUMN recipe_id INT,
ADD CONSTRAINT fk_service_recipe FOREIGN KEY (recipe_id) REFERENCES recipe_master(id);

CREATE TABLE recipe_master (
  id INT AUTO_INCREMENT PRIMARY KEY,
  material_id INT,
  quantity DOUBLE,
  price DOUBLE,
  FOREIGN KEY (material_id) REFERENCES material(id)
);
