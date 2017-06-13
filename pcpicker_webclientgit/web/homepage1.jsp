<%-- 
    Document   : test
    Created on : 06 3, 17, 1:11:31 PM
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
            <div class="featured_item">
                <div class="featured_item_banner">
                    Featured Items
                </div>
               
                <div class="slideshow-container">       
                    <a class="prev" onclick="plusSlidesFeaturedItem(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlidesFeaturedItem(1)">&#10095;</a>
                    <div class="featured_item_slides fade">
                        <img src="img/testimage.png" >
                        <div class="slides_text">
                            <a href="itempage.jsp">Intel Core i7 7777HQ</a>                            
                        
                        </div>
                    </div>

                    <div class="featured_item_slides fade">
                        <img src="img/testimage2.png" >
                        <div class="slides_text">
                            <a href="itempage.jsp">Intel Core i5 7777k</a>   
                            
                        </div>
                    </div>

                    <div class="featured_item_slides fade">
                       <img src="img/testimage3.png" >
                        <div class="slides_text">
                            <a href="itempage.jsp">AMD Ryzen 5 1600x</a>   
                            
                        </div>
                    </div>
                    
                </div>
                <div style="text-align:center">
                    <span class="dotFeaturedItems" onclick="currentSlideFeaturedItem(1)"></span> 
                    <span class="dotFeaturedItems" onclick="currentSlideFeaturedItem(2)"></span> 
                    <span class="dotFeaturedItems" onclick="currentSlideFeaturedItem(3)"></span> 
                </div>
                

                
            </div>
          
            <div class="top_selling">
                <div class="top_selling_banner">
                    Top Sellers
                </div>
              
                
                <div class="slideshow-container">       
                    <a class="prev" onclick="plusSlidesTopSelling(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlidesTopSelling(1)">&#10095;</a>
                    <div class="top_selling_slides fade">
                        <img src="img/testimage3.png" >
                        <div class="slides_text">
                            <a href="itempage.jsp">AMD Ryzen 5 1600x</a>                            
                        
                        </div>
                    </div>

                    <div class="top_selling_slides fade">
                        <img src="img/testimage2.png" >
                        <div class="slides_text">
                            <a href="itempage.jsp">Intel Core i5 7777k</a>   
                            
                        </div>
                    </div>

                    <div class="top_selling_slides fade">
                       <img src="img/testimage.png" >
                        <div class="slides_text">
                            <a href="itempage.jsp">Intel Core i7 7777HQ</a>   
                            
                            </div>
                    </div>
                </div>
                 <div style="text-align:center">
                    <span class="dotTopSellings" onclick="currentSlideTopSelling(1)"></span> 
                    <span class="dotTopSellings" onclick="currentSlideTopSelling(2)"></span> 
                    <span class="dotTopSellings" onclick="currentSlideTopSelling(3)"></span> 
                </div>

                
            </div>
            
            
            <div class="new_item">
                
            </div>
            
            
        </div>
                
       
    </body>
    
    
    
    
 <script type="text/javascript">   
    var slideIndexFeaturedItem = 1;
    showSlidesFeaturedItem(slideIndexFeaturedItem);

    function plusSlidesFeaturedItem(n) {
      showSlidesFeaturedItem(slideIndexFeaturedItem += n);
    }

    function currentSlideFeaturedItem(n) {
      showSlidesFeaturedItem(slideIndexFeaturedItem = n);
    }

    function showSlidesFeaturedItem(n) {
      var i;
      var slides = document.getElementsByClassName("featured_item_slides");
      var dotFeaturedItemss = document.getElementsByClassName("dotFeaturedItems");
      if (n > slides.length) {slideIndexFeaturedItem = 1} 
      if (n < 1) {slideIndexFeaturedItem = slides.length}
      for (i = 0; i < slides.length; i++) {
          slides[i].style.display = "none"; 
      }
      for (i = 0; i < dotFeaturedItemss.length; i++) {
          dotFeaturedItemss[i].className = dotFeaturedItemss[i].className.replace(" active", "");
      }
      slides[slideIndexFeaturedItem-1].style.display = "block"; 
      dotFeaturedItemss[slideIndexFeaturedItem-1].className += " active";
    }
 
    var slideIndexTopSelling = 1;
    showSlidesTopSelling(slideIndexTopSelling);

    function plusSlidesTopSelling(n) {
      showSlidesTopSelling(slideIndexTopSelling += n);
    }

    function currentSlideTopSelling(n) {
      showSlidesTopSelling(slideIndexTopSelling = n);
    }

    function showSlidesTopSelling(n) {
      var i;
      var slides = document.getElementsByClassName("top_selling_slides");
      var dotTopSellingss = document.getElementsByClassName("dotTopSellings");
      if (n > slides.length) {slideIndexTopSelling = 1} 
      if (n < 1) {slideIndexTopSelling = slides.length}
      for (i = 0; i < slides.length; i++) {
          slides[i].style.display = "none"; 
      }
      for (i = 0; i < dotTopSellingss.length; i++) {
          dotTopSellingss[i].className = dotTopSellingss[i].className.replace(" active", "");
      }
      slides[slideIndexTopSelling-1].style.display = "block"; 
      dotTopSellingss[slideIndexTopSelling-1].className += " active";
    }
</script>
</html>
