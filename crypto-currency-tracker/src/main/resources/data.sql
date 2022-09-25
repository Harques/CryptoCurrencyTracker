insert into user(username,password) values('user', '$2a$10$aetzrkuOQctWTMYPoay5hOLxqRdD..9qfvf/3kNF68rBH0gZqHzLe');
insert into user(username,password) values('admin', '$2a$10$w1IqvWJIC0UgOtgkDMcEHOM5C.oHwN2tQPTL/wZy2itJsngOJAz4a');
insert into role(name) values('ADMIN');
insert into role(name) values('USER');
insert into user_roles(user_id,role_id) values(1,1);
insert into user_roles(user_id,role_id) values(2,2);