INSERT INTO users(user_name, password, first_name, last_name, contact_number, reg_datetime, active,  confirmed_signup) VALUES ('huimiao@cn.ibm.com', '123456', 'Hui', 'Miao', 123456789, current_timestamp, 1,   1);


INSERT INTO roles(role) values ('ROLE_USER');
INSERT INTO roles(role) values ('ROLE_MENTOR');
INSERT INTO roles(role) values ('ROLE_ADMIN');
