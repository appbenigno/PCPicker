drop database pcpicker;
create database pcpicker;
use pcpicker;

create table part
(
    part_id varchar(25),
    part_type varchar(50),
    part_manufacturer varchar(50),
    part_name varchar(50),
    part_price double,
    primary key (part_id)
);

create table part_processor
(
    part_id varchar(25),
    core_clock double,
    core_num int,
    thread_num int,
    socket_ varchar(50),
    tdp int,
    primary key (part_id),
    foreign key (part_id) references part(part_id)    
);

create table part_memory
(
    part_id varchar(25),
    mem_capacity int,
    mem_ddr varchar(8),
    mem_clock int,
    primary key (part_id),
    foreign key (part_id) references part(part_id)   
);

create table part_powersupply
(
    part_id varchar(25),
    wattage int,
    rating varchar(20),
    form_factor varchar(50),    
    primary key (part_id),
    foreign key (part_id) references part(part_id)   
);


create table part_graphicscard
(
    part_id varchar(25),
    core_clock int,
    mem_ddr varchar(8),
    mem_capacity int,
    mem_clock int,
    primary key (part_id),
    foreign key (part_id) references part(part_id)   
);


create table part_cooler
(
    part_id varchar(25),
    supported_sockets varchar(100),
    liquid_cooling boolean,
    rated_tdp int,
    primary key (part_id),
    foreign key (part_id) references part(part_id)   
);

create table part_motherboard
(
    part_id varchar(25),
    socket varchar(50),
    mem_slots int,
    form_factor varchar(50),
    primary key (part_id),
    foreign key (part_id) references part(part_id)   
);

create table part_storage
(
    part_id varchar(25),
    type_ varchar(50),
    capacity int,
    interface varchar(50),
    primary key (part_id),
    foreign key (part_id) references part(part_id)   
);

create table part_mouse
(
    part_id varchar(25),
    dpi int,
    connection_ varchar(50),
    primary key (part_id),
    foreign key (part_id) references part(part_id)   
);

create table part_keyboard
(
    part_id varchar(25),
    backlit boolean,
    type_ varchar(50),
    primary key (part_id),
    foreign key (part_id) references part(part_id)   
);

create table part_monitor
(
    part_id varchar(25),
    aspect_ratio varchar(50),
    screen_size int,
    max_resolution varchar(50),
    refresh_rate int,
    primary key (part_id),
    foreign key (part_id) references part(part_id)   
);

create table branch
(
    branch_id int,
    city varchar(50),
    address varchar(255),
    zip_code int,
    primary key (branch_id)
);

create table image
(
    part_id varchar(25),
    imageclass varchar(100),
    imagepath varchar(100),
    primary key (part_id, imageclass),
    foreign key (part_id) references part(part_id)   
);

create table inventory
(
    part_id varchar(25),
    date_acquired date,
    branch_id int,
    quantity int,
    primary key (part_id, date_acquired, branch_id),
    foreign key (part_id) references part(part_id)   
);

create table customer
(
    cust_id int auto_increment,
    username varchar(50),
    password varchar(50),
    address varchar(255),
    city varchar(50),
    zip_code int,
    primary key (cust_id)
);

create table order_
(
    order_id int auto_increment,
    cust_id int,
    date_created date,
    payment_type varchar(20),
    primary key (order_id),
    foreign key (cust_id) references customer(cust_id)
);

create table order_part
(
    order_id int,
    part_id varchar(25),
    quantity int,
    primary key (order_id, part_id)
);

create table deliver
(
    delivery_num int auto_increment,
    order_id int,
    date_delivery date,
    accepted_by varchar(50),
    primary key (delivery_num),
    foreign key (order_id) references order_(order_id)
)
