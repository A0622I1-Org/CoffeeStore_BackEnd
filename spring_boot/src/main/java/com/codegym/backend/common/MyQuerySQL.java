package com.codegym.backend.common;

public class MyQuerySQL {
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
            "UPDATE bill_detail bd SET price = (SELECT price FROM service s WHERE s.id = bd.service_id) WHERE bd.price is null";
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
