<%-- 
    Document   : accountpage
    Created on : 06 5, 17, 6:29:26 PM
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
            <div>
                Hello ${sessionScope.username}!<br>
                <input type="submit" value="Logout" name="button" onclick=location.href='${pageContext.request.contextPath}/Logout;' style="border:1px solid #ccc; padding:5px">
            </div>
            <div>
                <form action ="OrderPage" method ="get">
                    <input type="hidden" name ="orderLength" value="${fn:length(orders)}">
                    <c:forEach items="${orders}" var="order" varStatus ="loopCounter">                
                        <c:forEach items="${order.value}" var="details" varStatus="loopCounter2">
                            <c:choose>
                                <c:when test="${loopCounter2.index == 0 }">
                                    orderid :${details.value}
                                    <input type ="hidden" name ="orderid" value ="${details.value}">
                                </c:when>
                                <c:when test="${loopCounter2.index == 1}">
                                    date created:    ${details.value}
                                </c:when>
                                <c:when test="${loopCounter2.index == 2}">
                                    paymenttype: ${details.value}
                                </c:when>
                                <c:when test="${loopCounter2.index == 3}">
                                    num items: ${details.value}
                                </c:when>
                                <c:when test="${loopCounter2.index == 4}">
                                    Delivery Date: ${details.value}
                                </c:when>
                                <c:otherwise>
                                    total price: ${details.value}
                                </c:otherwise>
                            </c:choose>
                                   <br>

                           

                    </c:forEach>
                    <input type="submit" value="Cancel Order" name="submit${loopCounter.index}"><br>
                    <input type="submit" value="View Order" name="submit${loopCounter.index}">
                    <br><br>
                    </c:forEach>
                </form>
            </div>
        </div>
    </body>
</html>
