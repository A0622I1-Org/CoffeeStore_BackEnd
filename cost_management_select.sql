select * from material;
select * from material_cost;
select * from fixed_expenses;
select * from salary_expenses;
select * from other_expenses;
select * from material_type_master;


select '1', m.name, m.`unit`, mc.description, mc.quantity, mc.unit_price, '0' as depreciation_period, mc.date from  material_cost mc
left join material m on m.id = mc.material_id
union all
select '2', name, `unit`, description, quantity, unit_price, depreciation_period, `date` from  fixed_expenses
union all
select '3', u.name, 'tháng', 'lương nhân viên', '1', monthly_salary, '1', se.date from  salary_expenses se
inner join user u on u.id = se.user_id;

select * from bill;
select * from bill_detail;

update bill_detail set cost = price*0.3
