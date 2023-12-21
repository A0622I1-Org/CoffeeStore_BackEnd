select * from bill_detail;
alter table bill_detail
add column delete_flag int
update bill_detail set delete_flag = 1 