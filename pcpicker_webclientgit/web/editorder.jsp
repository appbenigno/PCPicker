<%-- 
    Document   : orderpage
    Created on : 06 11, 17, 12:51:19 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/test.css">
    </head>
    <body>
        <div class ="banner">
            <div class ="logo">  
                <a href="${pageContext.request.contextPath}/Homepage"><img src="img/logo.png" alt="logo" /></a>
            </div>
            <div class="login_button">
                <a href="<%=request.getContextPath()%>/Login">                   
                    ${empty sessionScope.username?'Log in or Register':sessionScope.username}                    
                </a>
            </div>
            <div class ="cartsummary">
                <a href="<%=request.getContextPath()%>/ShoppingCart">                   
                    ${cartsummary}                    
                </a>
            </div>
            <div class ="menubar_banner">
                <div class="dropdown fade">
                    <button class="dropbtn fade">Products ▽ </button>
                    <div class="dropdown-content fade">
                        <form action="SearchPage" method="doGet">
                            <input type="submit" value="CPU" name="test">
                            <input type="submit" value="GPU" name="test">
                            <input type="submit" value="Memory" name="test">
                            <input type="submit" value="Motherboard" name="test">
                            <input type="submit" value="Cooler" name="test">
                            <input type="submit" value="Storage" name="test">                         
                            <input type="submit" value="Power Supply" name="test">
                            <input type="submit" value="Monitor" name="test">
                            <input type="submit" value="Keyboard" name="test">
                            <input type="submit" value="Mouse" name="test">
                        </form>
                    </div>
                </div>
                <div class = "search_bar">
                    <input type ="input" placeholder="search">                
                </div>
                <div class ="search_button">
                    <input type="submit" value="search">
                </div>
            </div>
        </div>
        
        <div class="content">
            
            Order id : ${orderid}<br>
            Total Price: ${totalprice}<br>
            <input type="hidden" name ="numOrders" value ="${fn:length(orderslist)}">
            <c:forEach items="${orderitems}" var="order" varStatus ="loopCounter">                
                <c:forEach items="${order.value}" var="details" varStatus="loopCounter2">
                    <c:choose>
                        <c:when test="${loopCounter2.index == 0 }">
                            partid :${details.value}
                            <input type ="hidden" name ="partid" value ="${details.value}">
                        </c:when>
                        <c:when test="${loopCounter2.index == 1}">
                            quantity:    ${details.value}
                        </c:when>
                        <c:when test="${loopCounter2.index == 2}">
                            partname ${details.value}
                        </c:when>
                        <c:otherwise>
                            part price: ${details.value}
                        </c:otherwise>
                    </c:choose>
                            <br>

                </c:forEach>
                            <br>
            </c:forEach>
            
            
            
            
        </div>
    </body>
</html>
