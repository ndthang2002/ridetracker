## jdbc 

jdbc la mot framework de lam viec voi api

- jdbctemplate de lam viec voi database (crud)

- simplejdbcinert them du lieu vao database bang map

- rowmapper xử lý kết quả trả về từ resultset , nó ánh xạ từng hàng  cua resultset ;

- preparestatmentcreater : dung de insert vao databse ;

- namdJdbcTemplate dat ten cho tham so duoc truyen vao trong cau lenh sql;

```
Exeception :
@Transactional : quay tro lai neu dieu gi do xay ra;
@Exceptionhadler : bieu thi phuong thuc ben duoi xu ly ngoai le cua cac @requestmapping nem ra ;
runtimeException : xu ly cac ngoai le khi chuong trinh duoc chay 
DataAccessException : ngoai le trong runtimeException , khong bat buoc nguoi dung phai xu ly;
```