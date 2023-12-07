SELECT 
s.id, 
s.img_url AS imgUrl, 
s.name AS serviceName, 
s.price, 
st.name AS serviceType, 
s.created_date AS createdDate,
-- IF(b.payment_time IS NULL, '', b.payment_time) AS paymentTime,
IF((AVG(bd.price)) IS NULL, 0, (AVG(bd.price))) AS salePrice,
IF((SUM(bd.quantity)) IS NULL, 0, (SUM(bd.quantity))) AS quantity,
IF((AVG(bd.price)*SUM(bd.quantity)) IS NULL, 0, (AVG(bd.price))*SUM(bd.quantity)) AS payment,
IF(s.enable_flag = 1, 'Hoạt động', 'Vô hiệu') AS statusFlag
FROM service s
LEFT JOIN bill_detail bd ON bd.service_id = s.id
LEFT JOIN service_type st ON st.id = s.type_id
LEFT JOIN bill b ON b.id = bd.bill_id
WHERE 
-- (s.name LIKE CONCAT('%', ?, '%'))
-- AND (st.name LIKE CONCAT('%', ?, '%'))
-- AND 
-- s.created_date BETWEEN '2000-01-01' AND '2023-01-01'
-- AND s.price BETWEEN ? AND ?
-- AND 
substr(b.payment_time,1,10) BETWEEN '2000-01-01' AND '2023-01-01'
GROUP BY s.id
-- HAVING
-- quantity BETWEEN ? AND ?
-- AND statusFlag LIKE CONCAT('%', ?, '%')
-- AND payment BETWEEN ? AND ?
-- AND paymentTime BETWEEN ? AND ?
ORDER BY s.id asc, quantity DESC;


-- select substr(created_date,1,10) from service;