create table user(
user_id int UNSIGNED,
user_name varchar(20),
real_name varchar(10),
address varchar(20),
tel varchar(20),
mail varchar(25),
profile varchar(500),
point int UNSIGNED,
 primary key(user_id),
 UNIQUE(address)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE table hardware(
hardware_id int UNSIGNED,
hardware varchar(20),
primary key(hardware_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table category(
category_id int UNSIGNED,
category varchar(20),
primary key(category_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


create table item(
item_id int unsigned PRIMARY KEY,
item_name varchar(40),
price int UNSIGNED,
item_image varchar(40),
item_explanation varchar(500),
hardware_id int UNSIGNED,
category_id int UNSIGNED,
seller_id int UNSIGNED,
buyer_address varchar(30),
term datetime,
CONSTRAINT fk_hardware_id
    FOREIGN KEY hardware_id(hardware_id) 
    REFERENCES hardware(hardware_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT fk_category_id
    FOREIGN KEY category_id(category_id) 
    REFERENCES category(category_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT fk_buyer_address
    FOREIGN KEY (buyer_address) 
    REFERENCES user(address)
    ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


create table PaymentLog(
payment_id int unsigned PRIMARY KEY,
seller_id int UNSIGNED,
buyer_id int UNSIGNED,
item_id int UNSIGNED,
price int UNSIGNED,
date DATETIME,
CONSTRAINT fk_seller_id
    FOREIGN KEY seller_id(seller_id) 
    REFERENCES user(user_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT fk_buyer_id
    FOREIGN KEY buyer_id(buyer_id) 
    REFERENCES user(user_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


create table Deal(
deal_id int unsigned PRIMARY KEY,
payment_id int UNSIGNED,
deposit_id int UNSIGNED,
item_id int UNSIGNED,
deal_state int UNSIGNED,
time_limit DATETIME,
CONSTRAINT fk_payment_id
    FOREIGN KEY payment_id(payment_id) 
    REFERENCES PaymentLog(payment_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT fk_deposit_id
    FOREIGN KEY payment_id(deposit_id) 
    REFERENCES PaymentLog(payment_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT fk_item_id
    FOREIGN KEY (item_id) 
    REFERENCES item(item_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table Notice(
notice_id int UNSIGNED,
user_id int UNSIGNED,
comment varchar(500),
 primary key(notice_id),
CONSTRAINT fk_user_id
    FOREIGN KEY (user_id) 
    REFERENCES user(user_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table chat(
chat_id int UNSIGNED,
payment_id int UNSIGNED,
buyer_id int UNSIGNED,
seller_id int UNSIGNED,
text varchar(500),
date datetime,
primary key(chat_id),
CONSTRAINT fk_chat_payment_id
    FOREIGN KEY (payment_id) 
    REFERENCES paymentlog(payment_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT fk_chat_buyer_id
    FOREIGN KEY (buyer_id) 
    REFERENCES user(user_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT fk_chat_seller_id
    FOREIGN KEY (seller_id) 
    REFERENCES user(user_id)
    ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

commit;







