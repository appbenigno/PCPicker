<%-- 
    Document   : loginpage
    Created on : 06 4, 17, 1:02:04 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class ="loginContainer">
                <form  action="Login" method ="post">
                    <div class ="label">
                        Email
                    </div>
                    <div>
                        <input type ="email" name="username" placeholder="email address"required >
                    </div>
                    <div class ="label">
                        Password
                    </div>
                    <div>
                        <input type="password" name="password" placeholder="password"required>
                    </div>
                    <input type="submit" value="Login" name="button">    
                    <input type="hidden" name="from" value="${from}">
                </form>
                
                <input type="submit" value="Create Account" name="button" onclick=location.href='${pageContext.request.contextPath}/CreateAccount;'>
                <div class = "message">
                    ${message}
                </div>
                
            </div>
            
            
            
            
            
            
            
            
        </div>
    </body>
</html>
