package com.codegym.backend.common;

public class MyQuerySQL {
    public static final String SELECT_SERVICE =
            "SELECT s.id, s.img_url AS imgUrl, s.name AS serviceName, s.price, st.name AS serviceType, s.created_date AS createdDate,\n" +
                    "IF((AVG(bd.price)) IS NULL, 0, (AVG(bd.price))) AS salePrice,\n" +
                    "IF((SUM(bd.quantity)) IS NULL, 0, (SUM(bd.quantity))) AS quantity,\n" +
                    "IF((AVG(bd.price)*SUM(bd.quantity)) IS NULL, 0, (AVG(bd.price))*SUM(bd.quantity)) AS payment,\n" +
                    "IF(s.enable_flag = 1, 'Hoạt động', 'Vô hiệu') AS statusFlag\n" +
                    "FROM service s\n" +
                    "LEFT JOIN bill_detail bd ON bd.service_id = s.id\n" +
                    "LEFT JOIN service_type st ON st.id = s.type_id\n" +
                    "WHERE (s.name LIKE CONCAT('%', ?, '%'))\n" +
                    "AND (st.name LIKE CONCAT('%', ?, '%'))\n" +
                    "AND s.created_date BETWEEN ? AND ?\n" +
                    "AND s.price BETWEEN ? AND ?\n" +
                    "GROUP BY s.id\n" +
                    "HAVING\n" +
                    "quantity BETWEEN ? AND ?\n" +
                    "AND statusFlag LIKE CONCAT('%', ?, '%')\n" +
                    "AND payment BETWEEN ? AND ?\n" +
                    "ORDER BY quantity DESC";
    public static final String UPDATE_SERVICE_ENABLE_FLAG = "UPDATE service SET enable_flag = ? WHERE id = ?";
}
