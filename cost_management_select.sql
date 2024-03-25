select * from material;
select * from material_cost;
select * from fixed_expenses;
select * from salary_expenses;
select * from other_expenses;
select * from material_type_master;


select '1', name, `unit`, description, quantity, unit_price, '0' as depreciation_period, date from  material_cost
union all
select '2', name, `unit`, description, quantity, unit_price, depreciation_period, date from  fixed_expenses
union all
select '3', u.name, 'tháng', 'lương nhân viên', '1', monthly_salary, '1', date from  salary_expenses se
inner join user u on u.id = se.user_id
 
 


