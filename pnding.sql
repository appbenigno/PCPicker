use pcpicker;

delimiter //
create procedure getActivePendingOrders(  )
BEGIN
    select * from order_ where active = true and acceptedBy = null;
END//  

delimiter //
create procedure getOrderDetails( order_id_ int )
BEGIN
    select customer.cust_id, customer.lastname, customer.firstname, customer.address, customer.city, order_.date_created, order_.payment_type
    from order_
    left join customer on order_.cust_id = customer.cust_id
    order by order_.date_created desc;
END//  

