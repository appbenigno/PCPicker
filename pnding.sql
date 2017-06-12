use pcpicker;

delimiter //
create procedure getActivePendingOrders(  )
BEGIN
    select * from order_ where active = true and acceptedBy = null;
END//  

delimiter //
create procedure acceptOrder
(
    order_id_ varchar(25),
    branch_id int,
    deliveryDate_ date
)
BEGIN
    update order_ set acceptedBy = branch_id where order_.order_id = order_id_;
    update order_ set order_.deliveryDate = deliveryDate_ where order_.order_id = order_id_;
END//  

delimiter //
create procedure setOrderDeliveryDate
(
    order_id varchar(25),
    deliveryDate_ date
)
BEGIN
	update order_ set order_.deliveryDate = deliveryDate_ where order_.order_id = order_id_;
    update order_ set order_.cancelDate = NOW() where order_id = order_id_;
END//  

call setOrderDeliveryDate(1,NOW())













delimiter //
create procedure getOrderDetails( order_id_ int )
BEGIN
    select customer.cust_id, customer.lastname, customer.firstname, customer.address,
		   customer.city, order_.date_created, order_.payment_type
    from order_
    left join customer on order_.cust_id = customer.cust_id
    order by order_.date_created desc;
END//  

