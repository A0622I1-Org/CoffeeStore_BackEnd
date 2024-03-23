package com.codegym.backend.common;

public class MyQuerySQL {

    public static final String SELECT_ALL_BILL_BILL_LIST_DTO = "select b.id,b.created_time as createdTime, t.id as tableNumber, u.name, sum(bd.quantity*s.price) as totalPrice from  bill b\n" +
            "            join `table` t on b.table_id = t.id\n" +
            "            join user u on b.user_id =u.id\n" +
            "            join bill_detail bd on bd.bill_id = b.id\n" +
            "            join service s on bd.service_id = s.id\n" +
            "            group by b.id\n" +
            "            order by b.id";
    public static final String SELECT_BILL_LIST_BY_USER_BILL_LIST_DTO  = "select b.id,b.created_time as createdTime, t.id as tableNumber, u.name, sum(bd.quantity*s.price) as totalPrice from  bill b\n" +
            "            join `table` t on b.table_id = t.id\n" +
            "            join user u on b.user_id =u.id\n" +
            "            join bill_detail bd on bd.bill_id = b.id\n" +
            "            join service s on bd.service_id = s.id\n" +
            "            where u.name like ?\n " +
            "            group by b.id\n" +
            "            order by b.id";
    public static final String UPDATE_USER_PASS = "update account set password =?1, change_password_date=?2 where user_name=?3";
    public static final String SELECT_PASSWORD_BY_USERNAME = "select password from account where user_name = ?";
    public static final String SELECT_ACCOUNT_BY_USERNAME = "SELECT * FROM account where user_name = ?1";
    public static final String SELECT_ID_BY_USERNAME = "SELECT id FROM account where user_name = ?1";
    public static final String SELECT_USERNAME_BY_USERNAME = "SELECT user_name FROM account where user_name = ?1";
    public static final String SELECT_EMAIL_BY_EMAIL = "SELECT email FROM account where email = ?1";
    public static final String SELECT_CHANGE_PASSWORD_DATE_BY_USERNAME =  "SELECT change_password_date FROM account where user_name = ?1";
    public static final String UPDATE_VERIFICATION_CODE_BY_USERNAME = "update account set verification_code= ?1 where user_name = ?2";
    public static final String SELECT_ACCOUNT_BY_VERIFICATION_CODE = "select * from account where verification_code = ?1";
    public static final String UPDATE_PASSWORD_BY_VERIFICATION_CODE = "update account set password = ?1,verification_code = null where verification_code= ?2";
    public static final String UPDATE_CHANGE_PASSWORD_DATE_BY_VERIFICATION_CODE = "update account set change_password_date = ?1 where verification_code = ?2";
    public static final String UPDATE_EMAIL_BY_USERNAME = "update account set account.email = ?1 where account.user_name = ?2";
    public static final String SELECT_ACCOUNT_LIST = "select a.id, a.email, a.user_name from a0622i1_coffee.account a ";
    public static final String SELECT_USER_ID_FROM_USERNAME = "SELECT u.id FROM user u " +
            "JOIN account a ON u.account_id = a.id " +
            "WHERE a.user_name = ?1";
    public static final String UPDATE_PAYMENT_BY_TABLE_ID = "UPDATE bill SET payment_status = 1, payment_time = ?1, user_id = ?2\n" +
            "WHERE table_id = ?3";
    public static final String INSERT_BILL_DETAIL = "insert into bill_detail(quantity,bill_id,service_id, delete_flag)" +
            "values(?1,?2,?3,0)";
    public static final String SELECT_BILL_DETAIL_LIST_BY_TABLE_ID = "select t.id as tableId, s.img_url as imgUrl, s.name as serviceName," +
            " sum(bd.quantity) quantity, s.price, t.name as tableName, sum(quantity*s.price) as sum,\n" +
            "b.payment_status as paymentStatus from bill b\n" +
            "join `table` t on b.table_id = t.id\n" +
            "join bill_detail bd on b.id = bd.bill_id\n" +
            "join service s on bd.service_id = s.id\n" +
            "where payment_status = 0 and table_id = ?\n" +
            "group by s.id\n" +
            "order by table_id asc";
    public static final String INSERT_BILL = "insert into bill (created_time,payment_status,payment_time,table_id,user_id) " +
            "values(?1,?2,?3,?4,?5)";
    public static final String SELECT_BILL_BY_TABLE_ID = "select b.id,b.created_time as createdTime,b.payment_status as paymentStatus," +
            "b.payment_time as paymentTime, b.table_id as tableId, b.user_id as userId from bill b " +
            "where table_id = ?1 and payment_status = 0 order by id desc limit 1";
    public static final String SELECT_BILL_DETAIL_BILL_DETAIL_DTO = "select s.name, s.price,bd.quantity, bd.quantity*s.price as total from service s " +
            "join bill_detail bd on bd.service_id = s.id " +
            "join bill b on b.id = bd.bill_id " +
            "where b.id =?";
    public static final String SELECT_SERVICE =
            "SELECT \n" +
                    "s.id, \n" +
                    "s.img_url AS imgUrl, \n" +
                    "s.name AS serviceName, \n" +
                    "s.price, \n" +
                    "st.name AS serviceType, \n" +
                    "s.created_date AS createdDate,\n" +
                    "IF((AVG(bd.price)) IS NULL, 0, (AVG(bd.price))) AS salePrice,\n" +
                    "IF((SUM(bd.quantity)) IS NULL, 0, (SUM(bd.quantity))) AS quantity,\n" +
                    "IF((AVG(bd.price)*SUM(bd.quantity)) IS NULL, 0, (AVG(bd.price))*SUM(bd.quantity)) AS payment,\n" +
                    "IF(s.enable_flag = 1, 'Hoạt động', 'Vô hiệu') AS statusFlag\n" +
                    "FROM service s\n" +
                    "LEFT JOIN bill_detail bd ON bd.service_id = s.id\n" +
                    "LEFT JOIN service_type st ON st.id = s.type_id\n" +
                    "LEFT JOIN bill b ON b.id = bd.bill_id\n" +
                    "WHERE (s.name LIKE CONCAT('%', ?, '%'))\n" +
                    "AND (st.name LIKE CONCAT('%', ?, '%'))\n" +
                    "AND s.created_date BETWEEN ? AND ?\n" +
                    "AND s.price BETWEEN ? AND ?\n" +
                    "AND b.payment_time BETWEEN ? AND ?\n" +
                    "GROUP BY s.id\n" +
                    "HAVING\n" +
                    "quantity BETWEEN ? AND ?\n" +
                    "AND statusFlag LIKE CONCAT('%', ?, '%')\n" +
                    "AND payment BETWEEN ? AND ?\n" +
                    "ORDER BY quantity DESC\n";
    public static final String UPDATE_SERVICE_ENABLE_FLAG =
            "UPDATE service SET enable_flag = ? WHERE id = ?";
    public static final String SELECT_SERVICE_NO_JOIN =
            "SELECT id, name, price, type_id type_id, enable_flag enableFlag, created_date createdDate, img_url imgUrl, describe describe FROM service";
    public static final String SELECT_BILL =
            "SELECT b.id,b.created_time AS createdTime, t.id AS tableNumber, u.name, sum(bd.quantity*s.price) AS totalPayment FROM  bill b\n" +
                    "JOIN `table` t ON b.table_id = t.id\n" +
                    "JOIN user u ON b.user_id =u.id\n" +
                    "JOIN bill_detail bd ON bd.bill_id = b.id\n" +
                    "JOIN service s ON bd.service_id = s.id\n" +
                    "WHERE b.id LIKE CONCAT('%', ?, '%')\n" +
                    "AND b.created_time BETWEEN ? AND ?\n" +
                    "AND u.name LIKE CONCAT('%', ?, '%')\n" +
                    "AND t.id LIKE CONCAT('%', ?, '%')\n" +
                    "GROUP BY b.id\n" +
                    "HAVING\n" +
                    "totalPayment BETWEEN ? AND ?\n" +
                    "ORDER BY b.created_time DESC";
    public static final String INSERT_SERVICE =
            "INSERT INTO service (name,price,type_id,enable_flag,img_url,created_date, `describe`) VALUES\n" +
                    "(?,?,?,?,?,SYSDATE(),?)";
    public static final String UPDATE_SERVICE =
            "UPDATE service SET name = ?, price = ?, type_id = ?, enable_flag = ?, img_url = ?, `describe` = ? WHERE id = ?";
    public static final String UPDATE_PRICE_BILL_DETAIL =
            "UPDATE bill_detail bd SET price = (SELECT price FROM service s WHERE s.id = bd.service_id) WHERE bd.price is null and delete_flag = 0";
    public static final String SELECT_RECIPE_BY_SERVICE_ID =
            "SELECT rm.id id , m.name name, m.id materialId, s.id serviceId, rm.quantity quantity, m.unit unit, rm.price price FROM recipe_master rm\n" +
                    "LEFT JOIN service s ON s.id = rm.service_id\n" +
                    "LEFT JOIN material m ON m.id = rm.material_id\n" +
                    "WHERE s.id = ?";
    public static final String SELECT_MATERIAL =
            "SELECT id, name, type_id typeId, price, unit, quantity FROM material";
    public static final String INSERT_RECIPE =
            "INSERT INTO recipe_master (service_id, material_id, quantity, price) VALUES\n" +
                    "(?,?,?,?);";
    public static final String UPDATE_RECIPE =
            "update recipe_master set quantity = ?, price = ? where id = ?";
    public static final String DELETE_RECIPE =
            "delete from recipe_master where id = ?";
    public static final String SELECT_LAST_SERVICE_ID =
            "SELECT id FROM service\n" +
                    "ORDER BY id desc\n" +
                    "LIMIT 1";
    public static final String SELECT_BILL_DETAIL =
            "SELECT t.id AS tableId, s.img_url AS imgUrl, s.name AS serviceName, \n" +
                    "               sum(bd.quantity) quantity, s.price, t.name AS tableName, sum(bd.quantity * s.price) AS sum, \n" +
                    "               b.payment_status as paymentStatus from bill b \n" +
                    "        JOIN `table` t ON b.table_id = t.id \n" +
                    "        JOIN bill_detail bd ON b.id = bd.bill_id \n" +
                    "        JOIN service s ON bd.service_id = s.id \n" +
                    "        WHERE payment_status = 0 AND table_id = ?1 and delete_flag = 0\n" +
                    "        GROUP BY s.id \n" +
                    "        ORDER BY table_id asc";
    public static final String SELECT_CHARGING_BILL =
            "SELECT b.id AS billId, b.user_id AS userId, b.table_id AS tableId,\n" +
                    " b.payment_status AS paymentStatus, b.payment_time AS paymentTime, sum(bd.quantity * s.price) AS sum from bill b \n" +
                    "JOIN bill_detail bd ON bd.bill_id = b.id \n" +
                    "JOIN service s ON s.id = bd.service_id \n" +
                    "WHERE b.payment_status = 0 AND b.table_id = ?1 AND bd.delete_flag = 0\n" +
                    "GROUP BY b.table_id ";
}
