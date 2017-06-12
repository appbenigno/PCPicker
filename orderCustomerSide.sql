use pcpicker;
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
    
END//



call getOrderItems(1);
