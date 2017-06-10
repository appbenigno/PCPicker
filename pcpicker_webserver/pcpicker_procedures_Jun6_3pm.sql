use pcpicker;

delimiter //
create procedure add_processor
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    core_clock varchar(20),
    core_num int,
    thread_num int,
    socket_ varchar(50),
    tdp int, 
    comp_price double,
	comp_type varchar(50)
)
BEGIN
    insert into component values(comp_id,comp_type,comp_manufacturer,comp_name,comp_price);
    insert into component_processor values(comp_id,core_clock,core_num,thread_num,socket_,tdp);
END//  
Delimiter ;
  
delimiter //
create procedure get_processor(comp_name varchar(50))
BEGIN
    select * from component 
    right join component_processor 
    on component.comp_id = component_processor.comp_id 
    where component.comp_name = comp_name;
END//
Delimiter ;

delimiter //
create procedure get_processor_list()
BEGIN
    select * from component 
    right join component_processor 
    on component.comp_id = component_processor.comp_id;
END//
Delimiter ;


delimiter //
create procedure add_memory
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    mem_capacity int,
    mem_ddr varchar(8),
    mem_clock int,
    comp_price double,
    comp_type varchar(50)
)
BEGIN
    insert into component values(comp_id,comp_type,comp_manufacturer,comp_name,comp_price);
    insert into component_memory values(comp_id,mem_capacity,mem_ddr,mem_clock);
END//  
Delimiter ;
  
delimiter //
create procedure get_memory(comp_name varchar(50))
BEGIN
    select * from component 
    right join component_memory 
    on component.comp_id = component_memory.comp_id 
    where component.comp_name = comp_name;
END//
Delimiter ;

delimiter //
create procedure get_memory_list()
BEGIN
    select * from component 
    right join component_memory 
    on component.comp_id = component_memory.comp_id;
END//
Delimiter ;


delimiter //
create procedure add_powersupply
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    wattage int,
    rating varchar(20),
    form_factor varchar(50),
    comp_price double,
    comp_type varchar(50)
)
BEGIN
    insert into component values(comp_id,comp_type,comp_manufacturer,comp_name,comp_price);
    insert into component_powersupply values(comp_id,wattage,rating,form_factor);
END//  
Delimiter ;
  
delimiter //
create procedure get_powersupply(comp_name varchar(50))
BEGIN
    select * from component 
    right join component_powersupply 
    on component.comp_id = component_powersupply.comp_id 
    where component.comp_name = comp_name;
END//
Delimiter ;

delimiter //
create procedure get_powersupply_list()
BEGIN
    select * from component 
    right join component_powersupply 
    on component.comp_id = component_powersupply.comp_id;
END//
Delimiter ;


delimiter //
create procedure add_graphicscard
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    core_clock int,	
    mem_ddr varchar(8),
    mem_capacity varchar(8),
    mem_clock int,
    comp_price double,
    comp_type varchar(50)
)
BEGIN
    insert into component values(comp_id,comp_type,comp_manufacturer,comp_name,comp_price);
    insert into component_graphicscard values(comp_id,core_clock,mem_ddr,mem_capacity,mem_clock);
END//  
Delimiter ;
  
delimiter //
create procedure get_graphicscard(comp_name varchar(50))
BEGIN
    select * from component 
    right join component_graphicscard 
    on component.comp_id = component_graphicscard.comp_id 
    where component.comp_name = comp_name;
END//
Delimiter ;

delimiter //
create procedure get_graphicscard_list()
BEGIN
    select * from component 
    right join component_graphicscard 
    on component.comp_id = component_graphicscard.comp_id;
END//
Delimiter ;


delimiter //
create procedure add_cooler
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    supported_sockets varchar(300),
    liquid_cooling boolean,
    rated_tdp int,
    comp_price double,
    comp_type varchar(50)
)
BEGIN
    insert into component values(comp_id,comp_type,comp_manufacturer,comp_name,comp_price);
    insert into component_cooler values(comp_id,supported_sockets,liquid_cooling,rated_tdp);
END//  
Delimiter ;
  
delimiter //
create procedure get_cooler(comp_name varchar(50))
BEGIN
    select * from component 
    right join component_cooler 
    on component.comp_id = component_cooler.comp_id 
    where component.comp_name = comp_name;
END//
Delimiter ;

delimiter //
create procedure get_cooler_list()
BEGIN
    select * from component 
    right join component_cooler 
    on component.comp_id = component_cooler.comp_id;
END//
Delimiter ;



delimiter //
create procedure add_motherboard
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    socket varchar(50),
    mem_slots int,
    form_factor varchar(50),
    comp_price double,
    comp_type varchar(50)
)
BEGIN
    insert into component values(comp_id,comp_type,comp_manufacturer,comp_name,comp_price);
    insert into component_motherboard values(comp_id,socket,mem_slots,form_factor);
END//  
Delimiter ;
  
delimiter //
create procedure get_motherboard(comp_name varchar(50))
BEGIN
    select * from component 
    right join component_motherboard 
    on component.comp_id = component_motherboard.comp_id 
    where component.comp_name = comp_name;
END//
Delimiter ;

delimiter //
create procedure get_motherboard_list()
BEGIN
    select * from component 
    right join component_motherboard 
    on component.comp_id = component_motherboard.comp_id;
END//
Delimiter ;



delimiter //
create procedure add_storage
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    type_ varchar(50),
    capacity int,
    interface varchar(50),
    comp_price double,
    comp_type varchar(50)
)
BEGIN
    insert into component values(comp_id,comp_type,comp_manufacturer,comp_name,comp_price);
    insert into component_storage values(comp_id,type_,capacity,interface);
END//  
Delimiter ;
  
delimiter //
create procedure get_storage(comp_name varchar(50))
BEGIN
    select * from component 
    right join component_storage 
    on component.comp_id = component_storage.comp_id 
    where component.comp_name = comp_name;
END//
Delimiter ;

delimiter //
create procedure get_storage_list()
BEGIN
    select * from component 
    right join component_storage 
    on component.comp_id = component_storage.comp_id;
END//
Delimiter ;



delimiter //
create procedure add_mouse
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    dpi int,
    connection_ varchar(50),
    comp_price double,
    comp_type varchar(50)
)
BEGIN
    insert into component values(comp_id,comp_type,comp_manufacturer,comp_name,comp_price);
    insert into peripheral_mouse values(comp_id,dpi,connection_);
END//  
Delimiter ;
  
delimiter //
create procedure get_mouse(comp_name varchar(50))
BEGIN
    select * from component 
    right join peripheral_mouse 
    on component.comp_id = peripheral_mouse.comp_id 
    where component.comp_name = comp_name;
END//
Delimiter ;

delimiter //
create procedure get_mouse_list()
BEGIN
    select * from component 
    right join peripheral_mouse 
    on component.comp_id = peripheral_mouse.comp_id;
END//
Delimiter ;
    


delimiter //
create procedure add_keyboard
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    backlit boolean,
    type_ varchar(50),
    comp_price double,
    comp_type varchar(50)
)
BEGIN
    insert into component values(comp_id,comp_type,comp_manufacturer,comp_name,comp_price);
    insert into peripheral_keyboard values(comp_id,backlit,type_);
END//  
Delimiter ;
  
delimiter //
create procedure get_keyboard(comp_name varchar(50))
BEGIN
    select * from component 
    right join peripheral_keyboard 
    on component.comp_id = peripheral_keyboard.comp_id 
    where component.comp_name = comp_name;
END//
Delimiter ;

delimiter //
create procedure get_keyboard_list()
BEGIN
    select * from component 
    right join peripheral_keyboard 
    on component.comp_id = peripheral_keyboard.comp_id;
END//
Delimiter ;
    



delimiter //
create procedure add_monitor
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    aspect_ratio varchar(50),
    screen_size int,
    max_resolution varchar(50),
    refresh_rate int,
    comp_price double,
    comp_type varchar(50)
)
BEGIN
    insert into component values(comp_id,comp_type,comp_manufacturer,comp_name,comp_price);
    insert into peripheral_monitor values(comp_id,aspect_ratio,screen_size,max_resolution,refresh_rate);
END//  
Delimiter ;
  
delimiter //
create procedure get_monitor(comp_name varchar(50))
BEGIN
    select * from component 
    right join peripheral_monitor 
    on component.comp_id = peripheral_monitor.comp_id 
    where component.comp_name = comp_name;
END//
Delimiter ;

delimiter //
create procedure get_monitor_list()
BEGIN
    select * from component 
    right join peripheral_monitor 
    on component.comp_id = peripheral_monitor.comp_id;
END//
Delimiter ;