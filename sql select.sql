use a0622i1_coffee;
-- Quản lý phản hồi
select f.id, f.fb_id , f.name, f.email, ft.type, f.date from feedback f
left join feedback_type ft on f.type_id = ft.id;
-- chi tiết phản hồi
select f.id, f.rate, ft.type ,f.name, f.content, fi.imgUrl from feedback f
left join feedback_img fi on f.img_id = fi.id
left join feedback_type ft on f.type_id = ft.id;
-- order
select b.id as bill_id, t.id as table_id, s.imgUrl ,s.name, bd.quantity, s.price, t.name, bd.quantity*s.price as sum from bill b
join `table` t on b.table_id = t.id
join bill_detail bd on b.id = bd.bill_id
join service s on bd.service_id = s.id;