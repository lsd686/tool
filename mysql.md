#如何使 local 无须密码登录
```sql
Insert INTO mysql.user (Host, User) VALUES('localhost','');
FLUSH PRIVILEGES;
GRANT ALL PRIVILEGES ON *.* TO ''@'localhost';
```
