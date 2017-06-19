use pcpicker;

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
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price);
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
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price);
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
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price);
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
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price);
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
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price);
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
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price);
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
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price);
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
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price);
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
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price);
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
    insert into part values(part_id,part_type,part_manufacturer,part_name,part_price);
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
