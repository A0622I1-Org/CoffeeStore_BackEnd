SELECT 
s.id, 
s.img_url AS imgUrl, 
s.name AS serviceName, 
s.price, 
st.name AS serviceType, 
s.created_date AS createdDate,
IF((AVG(bd.price)) IS NULL, 0, (AVG(bd.price))) AS salePrice,
IF((SUM(bd.quantity)) IS NULL, 0, (SUM(bd.quantity))) AS quantity,
IF((AVG(bd.price)*SUM(bd.quantity)) IS NULL, 0, (AVG(bd.price))*SUM(bd.quantity)) AS payment,
IF(s.enable_flag = 1, 'Hoạt động', 'Vô hiệu') AS statusFlag
FROM service s
LEFT JOIN bill_detail bd ON bd.service_id = s.id
LEFT JOIN service_type st ON st.id = s.type_id
LEFT JOIN bill b ON b.id = bd.bill_id 
where s.id = 19
GROUP BY s.id 
ORDER BY quantity DESC;

select s.*, bd.price FROM service s
LEFT JOIN bill_detail bd ON bd.service_id = s.id 
where s.id = 19

select * from service;


update service set created_date = SYSDATE()
SELECT SYSDATE()
