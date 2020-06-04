drop table if exists order_detail;
DROP table if EXISTS product_info;
DROP table if exists product_category;

CREATE TABLE product_category (
    category_id int NOT NULL AUTO_INCREMENT,
    category_name varchar(64) NOT NULL,
    category_type int NOT NULL,
	create_time timestamp not null default current_timestamp,
	update_time timestamp not null default current_timestamp on update current_timestamp,
    PRIMARY KEY (category_id),
	unique key uqe_category_type (category_type)
);

Insert into product_category (category_id, category_name, category_type,create_time,update_time) values 
(1,'food',1,'2020-03-28 16:40:22','2020-03-29 16:40:22'),
(2,'ticket',2,'2020-03-28 16:40:22','2020-03-28 16:40:22');


create table product_info(
	product_id varchar(32) not null,
	product_name varchar(64) not null,
	product_price decimal(8,2) not null,
	product_stock int not null,
	product_description varchar(64) not null,
	product_status tinyint(3) default 0,
	category_type int not null,
	create_time timestamp not null default current_timestamp,
	update_time timestamp not null default current_timestamp on update current_timestamp,
	primary key (product_id)
);

insert into product_info (product_id,product_name,product_price,product_stock,product_description,product_status,category_type,create_time,update_time)
values ('1','burger',5.2,100,'cheeseburger',0,1,'2020-03-28 16:40:22','2020-03-29 16:40:22'),
('2','fri',2.2,100,'fries',0,1,'2020-03-28 16:40:22','2020-03-29 16:40:22'),
('3','concert',20,20,'concert ticket',0,2,'2020-03-28 16:40:22','2020-03-29 16:40:22');


