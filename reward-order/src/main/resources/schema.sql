drop table if exists order_detail;
drop table if exists order_master;


create table order_master(
	order_id varchar(32) not null,
	buyer_name varchar(32) not null,
	buyer_openid varchar(64) not null,
	order_amount decimal(8,2) not null,
	order_status tinyint(3) not null default 0,
	primary key(order_id),
	key id_buyer_openid (buyer_openid)
);


create table order_detail(
	detail_id varchar(32) not null,
	order_id varchar(32) not null,
	product_id varchar(32) not null,
	product_name varchar(32) not null,
	product_price decimal(8,2) not null,
	product_quantity int not null,
	primary key(detail_id),
	key idx_order_id (order_id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;