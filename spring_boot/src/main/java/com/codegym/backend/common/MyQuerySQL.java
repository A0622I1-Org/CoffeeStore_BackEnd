package com.codegym.backend.common;

public class MyQuerySQL {
    public static final String SELECT_SERVICE =
            "SELECT s.id, s.img_url AS imgUrl, s.name AS serviceName, s.price, st.name AS serviceType, s.created_date AS createdDate,\n" +
                    "IF(b.payment_time IS NULL, '', b.payment_time) AS paymentTime,\n" +
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
                    "GROUP BY s.id\n" +
                    "HAVING\n" +
                    "quantity BETWEEN ? AND ?\n" +
                    "AND statusFlag LIKE CONCAT('%', ?, '%')\n" +
                    "AND payment BETWEEN ? AND ?\n" +
                    "AND paymentTime BETWEEN ? AND ?\n" +
                    "ORDER BY quantity DESC";
    public static final String UPDATE_SERVICE_ENABLE_FLAG = "UPDATE service SET enable_flag = ? WHERE id = ?";
    public static final String SELECT_SERVICE_NO_JOIN = "select id, name, price, type_id type_id, enable_flag enableFlag, created_date createdDate, img_url imgUrl from service";
    public static final String SELECT_BILL = "SELECT b.id,b.created_time AS createdTime, t.id AS tableNumber, u.name, sum(bd.quantity*s.price) AS totalPayment FROM  bill b\n" +
            "JOIN `table` t ON b.table_id = t.id\n" +
            "JOIN user u ON b.user_id =u.id\n" +
            "JOIN bill_detail bd ON bd.bill_id = b.id\n" +
            "JOIN service s ON bd.service_id = s.id\n" +
            "where b.id LIKE CONCAT('%', ?, '%')\n" +
            "AND b.created_time BETWEEN ? AND ?\n" +
            "AND u.name LIKE CONCAT('%', ?, '%')\n" +
            "AND t.id LIKE CONCAT('%', ?, '%')\n" +
            "GROUP BY b.id\n" +
            "HAVING\n" +
            "totalPayment BETWEEN ? AND ?\n" +
            "ORDER BY b.created_time DESC";
    public static final String INSERT_SERVICE = "INSERT INTO service (name,price,type_id,enable_flag,img_url) values\n" +
            "(?,?,?,?,?)";
}