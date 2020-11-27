@echo off
mysql -u root -p humie < MySQLDrop.sql
mysql -u root -p < dropuser.sql


pause