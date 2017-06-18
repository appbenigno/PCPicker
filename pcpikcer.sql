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
    part_imagepath varchar(255) default null,
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
    username varchar(50) unique,
    password varchar(50),
    firstname varchar(50),
    lastname varchar(50),
    address varchar(255),
    city varchar(50),
    zip_code int,
    primary key (cust_id)
);
create table branch
(
    branch_id int auto_increment,
    city varchar(50),
    address varchar(255),
    zip_code int,
    primary key (branch_id)
);
create table order_
(
    order_id int auto_increment,
    cust_id int,
    date_created date,
    payment_type varchar(20),
    active bool default true,    
    acceptedBy int default null,
    deliveryDate date default null,
    cancel bool default false,
    cancelDate Date default null,
    primary key (order_id),
    foreign key (cust_id) references customer(cust_id),
    foreign key (acceptedBy) references branch(branch_id)
);

create table order_part
(
    order_id int,
    part_id varchar(25),
    quantity int,
    price double,
    primary key (order_id, part_id),
    foreign key (order_id) references order_(order_id),
    foreign key (part_id) references part(part_id)
);

create table deliver
(
    delivery_num int auto_increment,
    order_id int,
    date_delivery date,
    accepted_by varchar(50),
    primary key (delivery_num),
    foreign key (order_id) references order_(order_id)
);




delimiter //
create procedure add_processor
(
    part_id varchar(25),
    part_manufacturer varchar(50),
    part_name varchar(50),
    core_clock double,
    core_num int,
    thread_num int,
    socket_ varchar(50),
    tdp int, 
    part_price double,
	part_type varchar(50)
)
BEGIN
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price,null);
    insert into part_processor values(part_id,core_clock,core_num,thread_num,socket_,tdp);
END//  
Delimiter ;
  
delimiter //
create procedure get_processor(part_name varchar(50))
BEGIN
    select * from part 
    right join part_processor 
    on part.part_id = part_processor.part_id 
    where part.part_name = part_name;
END//
Delimiter ;

delimiter //
create procedure get_processor_list()
BEGIN
    select * from part 
    right join part_processor 
    on part.part_id = part_processor.part_id;
END//
Delimiter ;


delimiter //
create procedure add_memory
(
    part_id varchar(25),
    part_manufacturer varchar(50),
    part_name varchar(50),
    mem_capacity int,
    mem_ddr varchar(8),
    mem_clock int,
    part_price double,
    part_type varchar(50)
)
BEGIN
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price,null);
    insert into part_memory values(part_id,mem_capacity,mem_ddr,mem_clock);
END//  
Delimiter ;
  
delimiter //
create procedure get_memory(part_name varchar(50))
BEGIN
    select * from part 
    right join part_memory 
    on part.part_id = part_memory.part_id 
    where part.part_name = part_name;
END//
Delimiter ;

delimiter //
create procedure get_memory_list()
BEGIN
    select * from part 
    right join part_memory 
    on part.part_id = part_memory.part_id;
END//
Delimiter ;


delimiter //
create procedure add_powersupply
(
    part_id varchar(25),
    part_manufacturer varchar(50),
    part_name varchar(50),
    wattage int,
    rating varchar(20),
    form_factor varchar(50),
    part_price double,
    part_type varchar(50)
)
BEGIN
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price,null);
    insert into part_powersupply values(part_id,wattage,rating,form_factor);
END//  
Delimiter ;
  
delimiter //
create procedure get_powersupply(part_name varchar(50))
BEGIN
    select * from part 
    right join part_powersupply 
    on part.part_id = part_powersupply.part_id 
    where part.part_name = part_name;
END//
Delimiter ;

delimiter //
create procedure get_powersupply_list()
BEGIN
    select * from part 
    right join part_powersupply 
    on part.part_id = part_powersupply.part_id;
END//
Delimiter ;


delimiter //
create procedure add_graphicscard
(
    part_id varchar(25),
    part_manufacturer varchar(50),
    part_name varchar(50),
    core_clock int,	
    mem_ddr varchar(8),
    mem_capacity int,
    mem_clock int,
    part_price double,
    part_type varchar(50)
)
BEGIN
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price,null);
    insert into part_graphicscard values(part_id,core_clock,mem_ddr,mem_capacity,mem_clock);
END//  
Delimiter ;
  
delimiter //
create procedure get_graphicscard(part_name varchar(50))
BEGIN
    select * from part 
    right join part_graphicscard 
    on part.part_id = part_graphicscard.part_id 
    where part.part_name = part_name;
END//
Delimiter ;

delimiter //
create procedure get_graphicscard_list()
BEGIN
    select * from part 
    right join part_graphicscard 
    on part.part_id = part_graphicscard.part_id;
END//
Delimiter ;


delimiter //
create procedure add_cooler
(
    part_id varchar(25),
    part_manufacturer varchar(50),
    part_name varchar(50),
    supported_sockets varchar(300),
    liquid_cooling boolean,
    rated_tdp int,
    part_price double,
    part_type varchar(50)
)
BEGIN
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price,null);
    insert into part_cooler values(part_id,supported_sockets,liquid_cooling,rated_tdp);
END//  
Delimiter ;
  
delimiter //
create procedure get_cooler(part_name varchar(50))
BEGIN
    select * from part 
    right join part_cooler 
    on part.part_id = part_cooler.part_id 
    where part.part_name = part_name;
END//
Delimiter ;

delimiter //
create procedure get_cooler_list()
BEGIN
    select * from part 
    right join part_cooler 
    on part.part_id = part_cooler.part_id;
END//
Delimiter ;



delimiter //
create procedure add_motherboard
(
    part_id varchar(25),
    part_manufacturer varchar(50),
    part_name varchar(50),
    socket varchar(50),
    mem_slots int,
    form_factor varchar(50),
    part_price double,
    part_type varchar(50)
)
BEGIN
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price,null);
    insert into part_motherboard values(part_id,socket,mem_slots,form_factor);
END//  
Delimiter ;
  
delimiter //
create procedure get_motherboard(part_name varchar(50))
BEGIN
    select * from part 
    right join part_motherboard 
    on part.part_id = part_motherboard.part_id 
    where part.part_name = part_name;
END//
Delimiter ;

delimiter //
create procedure get_motherboard_list()
BEGIN
    select * from part 
    right join part_motherboard 
    on part.part_id = part_motherboard.part_id;
END//
Delimiter ;



delimiter //
create procedure add_storage
(
    part_id varchar(25),
    part_manufacturer varchar(50),
    part_name varchar(50),
    type_ varchar(50),
    capacity int,
    interface varchar(50),
    part_price double,
    part_type varchar(50)
)
BEGIN
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price,null);
    insert into part_storage values(part_id,type_,capacity,interface);
END//  
Delimiter ;
  
delimiter //
create procedure get_storage(part_name varchar(50))
BEGIN
    select * from part 
    right join part_storage 
    on part.part_id = part_storage.part_id 
    where part.part_name = part_name;
END//
Delimiter ;

delimiter //
create procedure get_storage_list()
BEGIN
    select * from part 
    right join part_storage 
    on part.part_id = part_storage.part_id;
END//
Delimiter ;



delimiter //
create procedure add_mouse
(
    part_id varchar(25),
    part_manufacturer varchar(50),
    part_name varchar(50),
    dpi int,
    connection_ varchar(50),
    part_price double,
    part_type varchar(50)
)
BEGIN
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price,null);
    insert into part_mouse values(part_id,dpi,connection_);
END//  
Delimiter ;
  
delimiter //
create procedure get_mouse(part_name varchar(50))
BEGIN
    select * from part 
    right join part_mouse 
    on part.part_id = part_mouse.part_id 
    where part.part_name = part_name;
END//
Delimiter ;

delimiter //
create procedure get_mouse_list()
BEGIN
    select * from part 
    right join part_mouse 
    on part.part_id = part_mouse.part_id;
END//
Delimiter ;
    


delimiter //
create procedure add_keyboard
(
    part_id varchar(25),
    part_manufacturer varchar(50),
    part_name varchar(50),
    backlit boolean,
    type_ varchar(50),
    part_price double,
    part_type varchar(50)
)
BEGIN
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price,null);
    insert into part_keyboard values(part_id,backlit,type_);
END//  
Delimiter ;
  
delimiter //
create procedure get_keyboard(part_name varchar(50))
BEGIN
    select * from part 
    right join part_keyboard 
    on part.part_id = part_keyboard.part_id 
    where part.part_name = part_name;
END//
Delimiter ;

delimiter //
create procedure get_keyboard_list()
BEGIN
    select * from part 
    right join part_keyboard 
    on part.part_id = part_keyboard.part_id;
END//
Delimiter ;
    



delimiter //
create procedure add_monitor
(
    part_id varchar(25),
    part_manufacturer varchar(50),
    part_name varchar(50),
    aspect_ratio varchar(50),
    screen_size int,
    max_resolution varchar(50),
    refresh_rate int,
    part_price double,
    part_type varchar(50)
)
BEGIN
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price,null);
    insert into part_monitor values(part_id,aspect_ratio,screen_size,max_resolution,refresh_rate);
END//  
Delimiter ;
  
delimiter //
create procedure get_monitor(part_name varchar(50))
BEGIN
    select * from part 
    right join part_monitor 
    on part.part_id = part_monitor.part_id 
    where part.part_name = part_name;
END//
Delimiter ;

delimiter //
create procedure get_monitor_list()
BEGIN
    select * from part 
    right join part_monitor 
    on part.part_id = part_monitor.part_id;
END//
Delimiter ;




delimiter //
create procedure getPart
(
    part_id_ varchar(25)
)
BEGIN
    select * from part where part.part_id = part_id_;
END//  

delimiter //
create procedure loginCustomer
(
    _username varchar(50),
    _password varchar(50)
)
BEGIN
    select customer.cust_id from customer where customer.username = _username and customer.password = _password;
END//  

delimiter //
create procedure addCustomer(
	_username varchar(50),
    _password varchar(50),
    _address varchar(255),
    _city varchar(50),
    _zip_code int,
    _firstname varchar(50),
    _lastname varchar(50)
)
BEGIN
    insert into customer(username,password,address,city,zip_code,firstname,lastname) values (_username,_password,_address,_city,_zip_code,_firstname,_lastname);
END//
call addCustomer('q','q','q','q',1)
select * from customer

delimiter //
create procedure getManufacturers(parttype_  varchar(50))
BEGIN
    select distinct part_manufacturer from part where part_type = parttype_;
END//


delimiter //
create procedure getMemoryTypes()
BEGIN
    select distinct mem_ddr 
    from part_memory;
END//


delimiter //
create procedure getGPUMemoryTypes()
BEGIN
    select distinct mem_ddr 
    from part_graphicscard;
END//

delimiter //
create procedure getMaxResolutions()
BEGIN
    select distinct max_resolution 
    from part_monitor;
END//

delimiter //
create procedure getAspectRatios()
BEGIN
    select distinct aspect_ratio 
    from peripheral_monitor;
END//



delimiter //
create procedure addOrder(cust_id_ int, payment_type varchar(20))
BEGIN
    insert into order_(cust_id,date_created,payment_type) values(cust_id_,NOW(), payment_type);
    SELECT LAST_INSERT_ID() FROM order_;
END//

delimiter //
create procedure addOrderpart(order_id int,  part_id varchar(25), quantity int, price double)
BEGIN
    insert into order_part values(order_id, part_id, quantity, price);
END//











delimiter //
create procedure getActivePendingOrders(  )
BEGIN
    select * from order_ where active = true and acceptedBy = null and cancel = false;
END//  

delimiter //
create procedure acceptOrder
(
    order_id_ varchar(25),
    branch_id int,
    deliveryDate_ varchar(25)
)
BEGIN
    update order_ set acceptedBy = branch_id where order_.order_id = order_id_;
    update order_ set order_.deliveryDate = STR_TO_DATE(deliveryDate_, '%m/%d/%Y') where order_.order_id = order_id_;
END//  

delimiter //
create procedure setOrderDeliveryDate
(
    order_id varchar(25),
    deliveryDate_ varchar(25)
)
BEGIN
	update order_ set order_.deliveryDate = STR_TO_DATE(deliveryDate_, '%m/%d/%Y') where order_.order_id = order_id_;
END//  
delimiter //
create procedure getActiveOrders(cust_id_ int)
BEGIN
    select * from order_ 
    where order_.cust_id = cust_id_ 
    and order_.active = true 
    and order_.cancel = false
    order by order_.order_id desc;
END//


delimiter //
create procedure getOrderItems(order_id_ int)
BEGIN
    select * from order_part where order_part.order_id = order_id_;
END//

delimiter //
create procedure cancelOrder(order_id_ int)
BEGIN
    update order_ set cancel = true where order_.order_id = order_id_;
    update order_ set active = false where order_.order_id = order_id_;
    update order_ set cancelDate = NOW() where order_id = order_id_;
END//

delimiter //
create procedure getOrder(order_id int)
BEGIN
    select * from order_ where order_.order_id = order_id; 
END//
Delimiter ;



delimiter //
create procedure getInventory()
BEGIN
    select * from inventory;
END//
Delimiter ;




delimiter //
create procedure getOrderDetails( order_id_ int )
BEGIN
    select customer.cust_id, customer.lastname, customer.firstname, customer.address,
		   customer.city, order_.date_created, order_.payment_type
    from order_
    left join customer on order_.cust_id = customer.cust_id
    order by order_.date_created desc;
END//  




delimiter //
create procedure setDelivered
(
    order_id_ varchar(25)
)
BEGIN
    update order_ set acceptedBy = branch_id where order_.order_id = order_id_;
    update order_ set order_.deliveryDate = STR_TO_DATE(deliveryDate_, '%m/%d/%Y') where order_.order_id = order_id_;
END//  


delimiter //
create procedure getHistoryOrders(cust_id_ int)
BEGIN
    select * from order_ 
    where order_.cust_id = cust_id_ 
    and order_.active = false 
    and order_.cancel = false
    order by order_.order_id desc;
END//

delimiter //
create procedure get_Inventory_list()
begin
	select * from inventory;
end//
delimiter ;

delimiter //
create procedure addInventory(part_id varchar (25), date_acquired date, branch_id int, quantity int)
begin
	insert into inventory values(part_id, date_acquired, branch_id, quantity);
end //
delimiter ;

delimiter //
create procedure get_customer_list()
begin
	select * from customer;
end//
delimiter ;

delimiter //
create procedure addImage(
	part_id_ varchar(25),
    part_imagepath_ varchar(1000)
)
begin
	update part
    set part.part_imagepath = part_imagepath_ 
    where part.part_id = part_id_;
end//
delimiter ;

delimiter //
create procedure getMaxPrice(
    part_type_ varchar(50)    
)
begin
	select max(part.part_price) from part where part.part_type = part_type_;
end//
delimiter ;


insert into branch values(null, 'Bulacan', 'B21 L8 Francisco Homes III', 3023);


call add_processor('ccpu123','Intel','Celeron G1840',2.8,2,2,'LGA 1150',53,2090,'Processor');
call addImage('ccpu123','http://fast.ulmart.ru/p/mid/76/7619/761908.jpg');

call add_processor('ccpu124','Intel','Pentium G4400',3.3,2,2,'LGA 1151',54,2700,'Processor');
call addImage('ccpu124','http://cvprodigital.co.id/wp-content/uploads/2016/07/g4400.jpg');

call add_processor('ccpu125','Intel','Core i3-7100',3.9,2,2,'LGA 1151',53,5790,'Processor');
call addImage('ccpu125','http://ecx.images-amazon.com/images/I/71TAF2Z73uL._SY355_.jpg');

call add_processor('ccpu126','Intel','Core i5-7600',3.5,4,4,'LGA 1151',65,11200,'Processor');
call addImage('ccpu126','http://ecx.images-amazon.com/images/I/51hIU3KbC8L._SY355_.jpg');

call add_processor('ccpu127','Intel','Core i7-6700k',4.0,4,4,'LGA 1151',91,16940,'Processor');
call addImage('ccpu127','https://images-na.ssl-images-amazon.com/images/I/41xuuE5uO8L.jpg');



call add_memory('cmem001','Kingston','HyperX Fury',8,'ddr3',1866,3190,'Memory');
call addImage('','');

call add_memory('cmem002','Gskill','RipjawsX',16,'ddr3',2400,6500,'Memory');
call addImage('','');

call add_memory('cmem003','Corsair','Vengeance',16,'ddr4',2666,6750,'Memory');
call addImage('','');

call add_memory('cmem004','Crucial','Ballistix Elite',4,'ddr4',2666,1850,'Memory');
call addImage('','');

call add_memory('cmem005','Gskill','Trident Z RGB',16,'ddr4',3000,7540,'Memory');
call addImage('','');



call add_powersupply('cpsu001','Corsair','VS450',450,'80+','Non-modular',1690,'Power Supply');
call addImage('','');

call add_powersupply('cpsu002','Aerocool','Strike-X',850,'80+ Silver','Full Modular',5200,'Power Supply');
call addImage('','');

call add_powersupply('cpsu003','Corsair','AX1200i',1200,'80+ Platinum','Full modular',14990,'Power Supply');
call addImage('','');



call add_graphicscard('cgpu001','Nvidia','MSI GT730 OC',1006,'GDDR5',2,5000,3050,'Graphics Card');
call addImage('','');

call add_graphicscard('cgpu002','Nvidia','Asus GTX1050 Expedition',1455,'GDDR5',2,7008,5860,'Graphics Card');
call addImage('','');

call add_graphicscard('cgpu003','Nvidia','Gigabyte GTX1080 Ti Founders Edition',1582,'GDDR5',11,11010,38500,'Graphics Card');
call addImage('','');


call add_cooler('cc001','Cooler Master','MasterAir Maker 8','Intel & Amd: All sockets',false,250,6450,'Heatsink');
call addImage('','');

call add_cooler('cc002','NZXT','Kraken X52','Intel & Amd: All sockets',true,520,6800,'Heatsink');
call addImage('','');


call add_motherboard('cmbo001','Asus','B150 Pro Gaming Aura','LGA 1151',4,'ATX',6450,'Motherboard');
call addImage('','');

call add_motherboard('cmbo002','MSI','H170 Gaming M3','LGA 1151',4,'ATX',6650,'Motherboard');
call addImage('','');

call add_motherboard('cmbo003','Gigabyte','GA-Z270X Gaming 9','LGA 1151',4,'ATX',27500,'Motherboard');
call addImage('','');

call add_motherboard('cmbo004','MSI','X370 Gaming Pro Carbon','LGA 1151',4,'ATX',11150,'Motherboard');
call addImage('','');


call add_storage('chd001','Seagate','Barracuda','Hard Drive','1','SATA',2490,'Storage');
call addImage('','');

call add_storage('chd002','Western Digital','Caviar Black','Hard Drive','4','SATA',10350,'Storage');
call addImage('','');

call add_storage('chd003','Samsung','850 Evo','Solid State Drive','500','SATA',8500,'Storage');
call addImage('','');


call add_mouse('pm001','Redragon','Centrophorus M601',3200,'USB 2.0',550,'Mouse');
call addImage('','');

call add_mouse('pm002','Mad Catz','R.A.T.6',8200,'USB 2.0',4000,'Mouse');
call addImage('','');


call add_keyboard('ckb001','Logitech','KD800L',true,'Membrane',900,'Keyboard');
call addImage('','');

call add_keyboard('ckb002','Razer','Ornata Chroma',true,'Mech-Membrane',4790,'Keyboard');
call addImage('','');


call add_monitor('pmon001','Acer','Predator XB1','16:9','27','2560x1440','165',38500,'Monitor');
call addImage('','');



call addInventory('ccpu125', '2016-07-01', 1,  4);
call addInventory('ccpu123', '2016-07-01', 1,  6);
call addInventory('ccpu124', '2016-07-01', 1,  6);
call addInventory('cgpu001', '2016-07-01', 1,  8);
call addInventory('cgpu003', '2016-07-01', 1,  1);
call addInventory('ckb001', '2016-07-01', 1,  7);
call addInventory('ckb002', '2016-07-01', 1,  2);
call addInventory('cmbo001', '2016-07-01', 1,  5);
call addInventory('cc001', '2016-07-01', 1,  10);

call addInventory('cmbo002', '2017-01-01', 1,  3);
call addInventory('cmbo003', '2017-01-01', 1,  6);
call addInventory('cmbo004', '2017-01-01', 1,  6);
call addInventory('cmem001', '2017-01-01', 1,  15);
call addInventory('cmem002', '2017-01-01', 1,  12);
call addInventory('cmem003', '2017-01-01', 1,  12);
call addInventory('cmem004', '2017-01-01', 1,  15);
call addInventory('cpsu001', '2017-01-01', 1,  20);



