<%-- 
    Document   : RegisterPage
    Created on : 06 4, 17, 4:37:00 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="css/test.css">
         <script type="text/javascript" src="/code_examples/passtest.js"></script>
         
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
                
        <div class ="content">
            <div class="create_account_container">
                <form method = "post" action ="CreateAccount">
                    <div class ="content_header">Create Account</div>
                   
                    <div>
                        <div class ="label">Email</div>
                        <div class = "field"><input type ="email" name="username" placeholder="email address"required value="${username}"></div>
                    </div>
                    <div>
                        <div class ="label">Password</div>
                        <div class = "field"><input type ="password" name="password" placeholder="password"required ></div>
                    </div>
                    <div>
                        <div class ="label">Retype Password</div>
                        <div class = "field">
                            <input type ="password" name="passwordre" placeholder="Retype password"required  >
                            <span id="confirmMessage" class="confirmMessage"></span>

                        </div>
                    
                    </div>
                    <div>
                        <div class ="label">Last name</div>
                        <div class = "field"><input type ="text" name="lastname" placeholder="Lastname"required value="${lastname}"></div>
                    </div>
                    <div>
                        <div class ="label">First name</div>
                        <div class = "field"><input type ="text" name="firstname" placeholder="Firstname"required value="${firstname}"></div>
                    </div>
                    <div>
                        <div class ="label">Address</div>
                        <div class = "field"><input type ="text" name="address" placeholder="Address"required value="${address}"></div>
                    </div>
                    <div>
                        <div class ="label">Zip code</div>
                        <div class = "field"><input type ="number" name="zipCode" placeholder="Zip code"required value="${zipCode}"></div>
                    </div>
                    <div>
                        <div class ="label">City</div>
                        <div class = "field">
                            <select name="city">
                                <c:forEach items="${map}" var="city">
                                    <option value="${city.key}">${city.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                   
                    <input type="submit" value="Register">
                    <div> 
                        ${message}
                    </div>
                </form>
            </div>
        </div>
        </div>
    </body>
   
</html>
