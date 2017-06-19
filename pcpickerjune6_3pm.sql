use pcpicker;

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
create procedure addOrderpart(order_id int,  part_id varchar(25), quantity int)
BEGIN
    insert into order_part values(order_id, part_id, quantity);
END//

call addOrder(null,null);

use pcpicker;

call add_processor('ccpu123','Intel','Celeron G1840',2.8,2,2,'LGA 1150',53,2090,'Processor');
call add_processor('ccpu124','Intel','Pentium G4400',3.3,2,2,'LGA 1151',54,2700,'Processor');
call add_processor('ccpu125','Intel','Core i3-7100',3.9,2,2,'LGA 1151',53,5790,'Processor');
call add_processor('ccpu126','Intel','Core i5-7600',3.5,4,4,'LGA 1151',65,11200,'Processor');
call add_processor('ccpu127','Intel','Core i7-6700k',4.0,4,4,'LGA 1151',91,16940,'Processor');

call add_memory('cmem001','Kingston','HyperX Fury',8,'ddr3',1866,3190,'Memory');
call add_memory('cmem002','Gskill','RipjawsX',16,'ddr3',2400,6500,'Memory');
call add_memory('cmem003','Corsair','Vengeance',16,'ddr4',2666,6750,'Memory');
call add_memory('cmem004','Crucial','Ballistix Elite',4,'ddr4',2666,1850,'Memory');
call add_memory('cmem005','Gskill','Trident Z RGB',16,'ddr4',3000,7540,'Memory');

call add_powersupply('cpsu001','Corsair','VS450',450,'80+','Non-modular',1690,'Power Supply');
call add_powersupply('cpsu002','Aerocool','Strike-X',850,'80+ Silver','Full Modular',5200,'Power Supply');
call add_powersupply('cpsu003','Corsair','AX1200i',1200,'80+ Platinum','Full modular',14990,'Power Supply');


call add_graphicscard('cgpu001','Nvidia','MSI GT730 OC',1006,'GDDR5',2,5000,3050,'Graphics Card');
call add_graphicscard('cgpu002','Nvidia','Asus GTX1050 Expedition',1455,'GDDR5',2,7008,5860,'Graphics Card');
call add_graphicscard('cgpu003','Nvidia','Gigabyte GTX1080 Ti Founders Edition',1582,'GDDR5',11,11010,38500,'Graphics Card');

call add_cooler('cc001','Cooler Master','MasterAir Maker 8','Intel & Amd: All sockets',false,250,6450,'Heatsink');
call add_cooler('cc002','NZXT','Kraken X52','Intel & Amd: All sockets',true,520,6800,'Heatsink');

call add_motherboard('cmbo001','Asus','B150 Pro Gaming Aura','LGA 1151',4,'ATX',6450,'Motherboard');
call add_motherboard('cmbo002','MSI','H170 Gaming M3','LGA 1151',4,'ATX',6650,'Motherboard');
call add_motherboard('cmbo003','Gigabyte','GA-Z270X Gaming 9','LGA 1151',4,'ATX',27500,'Motherboard');
call add_motherboard('cmbo004','MSI','X370 Gaming Pro Carbon','LGA 1151',4,'ATX',11150,'Motherboard');

call add_storage('chd001','Seagate','Barracuda','Hard Drive','1','SATA',2490,'Storage');
call add_storage('chd002','Western Digital','Caviar Black','Hard Drive','4','SATA',10350,'Storage');
call add_storage('chd003','Samsung','850 Evo','Solid State Drive','500','SATA',8500,'Storage');

call add_mouse('pm001','Redragon','Centrophorus M601',3200,'USB 2.0',550,'Mouse');
call add_mouse('pm002','Mad Catz','R.A.T.6',8200,'USB 2.0',4000,'Mouse');

call add_keyboard('ckb001','Logitech','KD800L',true,'Membrane',900,'Keyboard');
call add_keyboard('ckb002','Razer','Ornata Chroma',true,'Mech-Membrane',4790,'Keyboard');

call add_monitor('pmon001','Acer','Predator XB1','16:9','27','2560x1440','165',38500,'Monitor');




