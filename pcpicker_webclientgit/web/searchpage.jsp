<%-- 
    Document   : searchpage
    Created on : 06 4, 17, 10:37:34 AM
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
       
       <script src = "js/jquery-1.10.2.js"></script>
       <script src = "js/jquery-ui.js"></script>
       <script>
            $(function () {        
                $("#price_slider").slider({
                    animate: "fast",
                    value: 0,
                    min: 0,
                    max: <%=(Integer)request.getAttribute("maxPrice")%>,
                    step: 500,
                    range:true,
                    values: [<%=(Integer)request.getAttribute("setMinPrice")%>, <%=(Integer)request.getAttribute("setMaxPrice")%>],
                    slide: function (event, ui) {                        
                        $( "#sminPrice" ).val( "₱"+ ui.values[ 0 ] );
                        $( "#smaxPrice" ).val( "₱"+ ui.values[ 1 ] );
                        $( "#pricerange" ).val( "₱" + $( "#price_slider" ).slider( "values", 0 ) + " - ₱" + $( "#price_slider" ).slider( "values", 1 ) );
                    }
                });
                $( "#sminPrice" ).val( "₱"+ <%=(Integer)request.getAttribute("setMinPrice")%> );
                $( "#smaxPrice" ).val( "₱"+ <%=(Integer)request.getAttribute("setMaxPrice")%> );
                $( "#pricerange" ).val( "₱" + <%=(Integer)request.getAttribute("setMinPrice")%> + " - ₱" + <%=(Integer)request.getAttribute("setMaxPrice")%>);
            });
        </script>
       <script>
            $(function () {        
                $("#DPI_slider").slider({
                    animate: "fast",
                    value: 0,
                    min: 0,
                    max: <%=(Integer)request.getAttribute("maxDPI")%>,
                    step: 50,
                    range:true,
                    values: [<%=(Integer)request.getAttribute("setMinDPI")%>, <%=(Integer)request.getAttribute("setMaxDPI")%>],
                    slide: function (event, ui) {                        
                        $( "#sminDPI" ).val(  ui.values[ 0 ] );
                        $( "#smaxDPI" ).val(  ui.values[ 1 ] );
                        $( "#DPIrange" ).val( $( "#DPI_slider" ).slider( "values", 0 ) +" - " + $( "#DPI_slider" ).slider( "values", 1 ) );
                    }
                });
                $( "#sminDPI" ).val( "₱"+ <%=(Integer)request.getAttribute("setMinDPI")%> );
                $( "#smaxDPI" ).val( "₱"+ <%=(Integer)request.getAttribute("setMaxDPI")%> );
                $( "#DPIrange" ).val(  <%=(Integer)request.getAttribute("setMinDPI")%> +" - "  + <%=(Integer)request.getAttribute("setMaxDPI")%>);
            });
        </script>
       <script>
            $(function () {        
                $("#gpu_memcap_slider").slider({
                    animate: "fast",
                    value: 0,
                    min: 0,
                    max: <%=(Integer)request.getAttribute("maxgpu_memcap")%>,
                    step: 50,
                    range:true,
                    values: [<%=(Integer)request.getAttribute("setMingpu_memcap")%>, <%=(Integer)request.getAttribute("setMaxgpu_memcap")%>],
                    slide: function (event, ui) {                        
                        $( "#smingpu_memcap" ).val(  ui.values[ 0 ] );
                        $( "#smaxgpu_memcap" ).val(  ui.values[ 1 ] );
                        $( "#gpu_memcaprange" ).val( $( "#gpu_memcap_slider" ).slider( "values", 0 ) +" - " + $( "#gpu_memcap_slider" ).slider( "values", 1 ) );
                    }
                });
                $( "#smingpu_memcap" ).val( "₱"+ <%=(Integer)request.getAttribute("setMingpu_memcap")%> );
                $( "#smaxgpu_memcap" ).val( "₱"+ <%=(Integer)request.getAttribute("setMaxgpu_memcap")%> );
                $( "#gpu_memcaprange" ).val(  <%=(Integer)request.getAttribute("setMingpu_memcap")%> +" - "  + <%=(Integer)request.getAttribute("setMaxgpu_memcap")%>);
            });
        </script>
       <script>
            $(function () {        
                $("#wattage_slider").slider({
                    animate: "fast",
                    value: 0,
                    min: 0,
                    max: <%=(Integer)request.getAttribute("maxwattage")%>,
                    step: 50,
                    range:true,
                    values: [<%=(Integer)request.getAttribute("setMinwattage")%>, <%=(Integer)request.getAttribute("setMaxwattage")%>],
                    slide: function (event, ui) {                        
                        $( "#sminwattage" ).val(  ui.values[ 0 ] );
                        $( "#smaxwattage" ).val(  ui.values[ 1 ] );
                        $( "#wattagerange" ).val( $( "#wattage_slider" ).slider( "values", 0 ) +" - " + $( "#wattage_slider" ).slider( "values", 1 ) );
                    }
                });
                $( "#sminwattage" ).val( "₱"+ <%=(Integer)request.getAttribute("setMinwattage")%> );
                $( "#smaxwattage" ).val( "₱"+ <%=(Integer)request.getAttribute("setMaxwattage")%> );
                $( "#wattagerange" ).val(  <%=(Integer)request.getAttribute("setMinwattage")%> +" - "  + <%=(Integer)request.getAttribute("setMaxwattage")%>);
            });
        </script>
       <script>
            $(function () {        
                $("#core_num_slider").slider({
                    animate: "fast",
                    value: 0,
                    min: 0,
                    max: <%=(Integer)request.getAttribute("maxcore_num")%>,
                    step: 1,
                    range:true,
                    values: [<%=(Integer)request.getAttribute("setMincore_num")%>, <%=(Integer)request.getAttribute("setMaxcore_num")%>],
                    slide: function (event, ui) {                        
                        $( "#smincore_num" ).val(  ui.values[ 0 ] );
                        $( "#smaxcore_num" ).val(  ui.values[ 1 ] );
                        $( "#core_numrange" ).val( $( "#core_num_slider" ).slider( "values", 0 ) +" - " + $( "#core_num_slider" ).slider( "values", 1 ) );
                    }
                });
                $( "#smincore_num" ).val( "₱"+ <%=(Integer)request.getAttribute("setMincore_num")%> );
                $( "#smaxcore_num" ).val( "₱"+ <%=(Integer)request.getAttribute("setMaxcore_num")%> );
                $( "#core_numrange" ).val(  <%=(Integer)request.getAttribute("setMincore_num")%> +" - "  + <%=(Integer)request.getAttribute("setMaxcore_num")%>);
            });
        </script>
       <script>
            $(function () {        
                $("#tdp_slider").slider({
                    animate: "fast",
                    value: 0,
                    min: 0,
                    max: <%=(Integer)request.getAttribute("maxtdp")%>,
                    step: 10,
                    range:true,
                    values: [<%=(Integer)request.getAttribute("setMintdp")%>, <%=(Integer)request.getAttribute("setMaxtdp")%>],
                    slide: function (event, ui) {                        
                        $( "#smintdp" ).val(  ui.values[ 0 ] );
                        $( "#smaxtdp" ).val(  ui.values[ 1 ] );
                        $( "#tdprange" ).val( $( "#tdp_slider" ).slider( "values", 0 ) +" - " + $( "#tdp_slider" ).slider( "values", 1 ) );
                    }
                });
                $( "#smintdp" ).val( "₱"+ <%=(Integer)request.getAttribute("setMintdp")%> );
                $( "#smaxtdp" ).val( "₱"+ <%=(Integer)request.getAttribute("setMaxtdp")%> );
                $( "#tdprange" ).val(  <%=(Integer)request.getAttribute("setMintdp")%> +" - "  + <%=(Integer)request.getAttribute("setMaxtdp")%>);
            });
        </script>
       <script>
            $(function () {        
                $("#storagecapacity_slider").slider({
                    animate: "fast",
                    value: 0,
                    min: 0,
                    max: <%=(Integer)request.getAttribute("maxstoragecapacity")%>,
                    step: 0.25,
                    range:true,
                    values: [<%=(Integer)request.getAttribute("setMinstoragecapacity")%>, <%=(Integer)request.getAttribute("setMaxstoragecapacity")%>],
                    slide: function (event, ui) {                        
                        $( "#sminstoragecapacity" ).val(  ui.values[ 0 ] );
                        $( "#smaxstoragecapacity" ).val(  ui.values[ 1 ] );
                        $( "#storagecapacityrange" ).val( $( "#storagecapacity_slider" ).slider( "values", 0 ) +"TB - " + $( "#storagecapacity_slider" ).slider( "values", 1 ) +"TB" );
                    }
                });
                $( "#sminstoragecapacity" ).val( "₱"+ <%=(Integer)request.getAttribute("setMinstoragecapacity")%> );
                $( "#smaxstoragecapacity" ).val( "₱"+ <%=(Integer)request.getAttribute("setMaxstoragecapacity")%> );
                $( "#storagecapacityrange" ).val(  <%=(Integer)request.getAttribute("setMinstoragecapacity")%> +"TB - "  + <%=(Integer)request.getAttribute("setMaxstoragecapacity")%> + "TB");
            });
        </script>
       <script>
            $(function () {        
                $("#screensize_slider").slider({
                    animate: "fast",
                    value: 0,
                    min: 10,
                    max: <%=(Integer)request.getAttribute("maxscreensize")%>,
                    step: 1,
                    range:true,
                    values: [<%=(Integer)request.getAttribute("setMinscreensize")%>, <%=(Integer)request.getAttribute("setMaxscreensize")%>],
                    slide: function (event, ui) {                        
                        $( "#sminscreensize" ).val(  ui.values[ 0 ] );
                        $( "#smaxscreensize" ).val(  ui.values[ 1 ] );
                        $( "#screensizerange" ).val( $( "#screensize_slider" ).slider( "values", 0 ) +"in - " + $( "#screensize_slider" ).slider( "values", 1 ) +"in" );
                    }
                });
                $( "#sminscreensize" ).val( "₱"+ <%=(Integer)request.getAttribute("setMinscreensize")%> );
                $( "#smaxscreensize" ).val( "₱"+ <%=(Integer)request.getAttribute("setMaxscreensize")%> );
                $( "#screensizerange" ).val(  <%=(Integer)request.getAttribute("setMinscreensize")%> +"in - "  + <%=(Integer)request.getAttribute("setMaxscreensize")%> + "in");
            });
        </script>
       <script>
            $(function () {        
                $("#refreshrate_slider").slider({
                    animate: "fast",
                    value: 0,
                    min: 30,
                    max: <%=(Integer)request.getAttribute("maxrefreshrate")%>,
                    step: 10,
                    range:true,
                    values: [<%=(Integer)request.getAttribute("setMinrefreshrate")%>, <%=(Integer)request.getAttribute("setMaxrefreshrate")%>],
                    slide: function (event, ui) {                        
                        $( "#sminrefreshrate" ).val(  ui.values[ 0 ] );
                        $( "#smaxrefreshrate" ).val(  ui.values[ 1 ] );
                        $( "#refreshraterange" ).val( $( "#refreshrate_slider" ).slider( "values", 0 ) +"hz - " + $( "#refreshrate_slider" ).slider( "values", 1 ) +"hz" );
                    }
                });
                $( "#sminrefreshrate" ).val( "₱"+ <%=(Integer)request.getAttribute("setMinrefreshrate")%> );
                $( "#smaxrefreshrate" ).val( "₱"+ <%=(Integer)request.getAttribute("setMaxrefreshrate")%> );
                $( "#refreshraterange" ).val(  <%=(Integer)request.getAttribute("setMinrefreshrate")%> +"hz - "  + <%=(Integer)request.getAttribute("setMaxrefreshrate")%> + "hz");
            });
        </script>
    </head>
    <body>
        <div class ="banner">
            <div class ="logo">  
                <a href="homepage1.jsp"><img src="img/logo.png" alt="logo" /></a>
            </div>
            <div class="login_button">
                <a href="<%=request.getContextPath()%>/Login">                   
                    ${empty sessionScope.userid?'Log in or Register':sessionScope.userid}                    
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
           
                <div class ="search_filter_container">
                    <form action="SearchPage" method="get">
                        <input type="hidden" name="componentType" value="${componentType}">
                        <div class ="search_filter_banner">
                            Filter
                        </div>
                        <div class ="search_filter_wrapper">
                            <div class ="search_filter_label">Manufacturer</div>
                            <div class="search_filter_checkbox_list"> 
                                <select name="manufacturer">
                                    <c:forEach items="${manufacturers}" var="manufacturers_">
                                        <option value="${manufacturers_.value}">${manufacturers_.value}</option>
                                    </c:forEach>
                                </select>  
                            </div>
                        </div>

                        <c:if test="${componentType=='CPU'||componentType=='Processor' || componentType =='Motherboard'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Socket</div>
                                <div class="search_filter_checkbox_list">
                                    <select name="socket">
                                        <c:forEach items="${sockets}" var="sockets_">
                                            <option value="${sockets_.value}">${sockets_.value}</option>
                                        </c:forEach>
                                    </select>          
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${componentType=='CPU'||componentType=='Processor' }">
                            <div class ="search_filter_wrapper"> 
                              <div class ="search_filter_label">Number of Cores</div>
                              <div class="search_slider" id="core_num_slider"></div>   
                              <div class="search_slider_label_container">
                                  <input type = "text" id = "core_numrange" name= "core_numrange" readonly="readonly"  >  
                                  <div style="display: none;">
                                      <div class="search_slider_label_min"><input type = "text" id = "smincore_num" name= "smincore_num" readonly="readonly" ></div>  
                                      <div class="search_slider_label_max"><input type = "text" id = "smaxcore_num" name= "smaxcore_num" readonly="readonly" ></div>      
                                  </div>           
                              </div>                   
                            </div>
                        </c:if> 

                    
                        
                        <c:if test="${componentType=='Memory'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Memory Type</div>
                                <div class="search_filter_checkbox_list">
                                    <select name="socket">
                                        <c:forEach items="${memoryTypes}" var="memoryType_">
                                            <option value="${memoryType_.value}">${memoryType_.value}</option>
                                        </c:forEach>
                                    </select>          
                                </div>
                            </div>
                        </c:if>

                         <c:if test="${componentType=='Memory'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Memory Capacity</div>
                                <div class="search_filter_checkbox_list">
                                    <select name="socket">
                                        <c:forEach items="${memoryCapacities}" var="memoryCapacity_">
                                            <option value="${memoryCapacity_.value}">${memoryCapacity_.value}</option>
                                        </c:forEach>
                                    </select>          
                                </div>
                            </div>
                        </c:if>   
 
                       <c:if test="${componentType=='GPU' || componentType=='GraphicsCard'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Memory Type</div>
                                <div class="search_filter_checkbox_list">
                                    <select name="socket">
                                        <c:forEach items="${gpumemoryTypes}" var="gpumemoryCapacity_">
                                            <option value="${gpumemoryCapacity_.value}">${gpumemoryCapacity_.value}</option>
                                        </c:forEach>
                                    </select>          
                                </div>
                            </div>
                        </c:if>  
                        <c:if test="${componentType=='GPU' || componentType=='GraphicsCard'}">
                            <div class ="search_filter_wrapper"> 
                              <div class ="search_filter_label">Memory Range</div>
                              <div class="search_slider" id="gpu_memcap_slider"></div>   
                              <div class="search_slider_label_container">
                                  <input type = "text" id = "gpu_memcaprange" name= "gpu_memcaprange" readonly="readonly"  >  
                                  <div style="display: none;">
                                      <div class="search_slider_label_min"><input type = "text" id = "smingpu_memcap" name= "smingpu_memcap" readonly="readonly" ></div>  
                                      <div class="search_slider_label_max"><input type = "text" id = "smaxgpu_memcap" name= "smaxgpu_memcap" readonly="readonly" ></div>      
                                  </div>           
                              </div>                   
                            </div>
                        </c:if> 

                        <c:if test="${componentType=='Motherboard'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Form Factor</div>
                                <div class="search_filter_checkbox_list">
                                    <select name="socket">
                                        <c:forEach items="${formFactor}" var="formFactor_">
                                            <option value="${formFactor_.value}">${formFactor_.value}</option>
                                        </c:forEach>
                                    </select>          
                                </div>
                            </div>
                        </c:if>  

                        <c:if test="${componentType=='Cooler'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Form Factor</div>
                                <div class="search_filter_checkbox_list">
                                    <select name="socket">
                                        <c:forEach items="${formFactor}" var="formFactor_">
                                            <option value="${formFactor_.value}">${formFactor_.value}</option>
                                        </c:forEach>
                                    </select>          
                                </div>
                            </div>
                        </c:if>  

                        <c:if test="${componentType=='Cooler'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Cooling Type</div>
                                <div class="search_filter_checkbox_list">
                                    <div>
                                        <input type="radio" id="coolingTypeAll" name="coolingType" value="all" checked>
                                        <div class="radio_button_label"> 
                                            <label for="coolingTypeAll"><i>All</i></label>                                    
                                        </div>
                                    </div>
                                    <div>
                                        <input type="radio" id="coolingTypeAir" name="coolingType" value="air" >
                                        <div class="radio_button_label">
                                            <label for="coolingTypeAir"><i>Air cooling</i></label>         
                                        </div>
                                    </div>
                                    <div>
                                        <input type="radio" id="coolingTypeLiquid" name="coolingType" value="liquid" >
                                        <div class="radio_button_label"> 
                                           <label for="coolingTypeLiquid"><i>Liquid cooling</i></label>         
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>  

                    
                        <c:if test="${componentType=='Storage'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Storage Type</div>
                                <div class="search_filter_checkbox_list">
                                    <div>
                                        <input type="radio" id="storageTypeAll" name="storageType" value="all" checked>
                                        <div class="radio_button_label"> 
                                            <label for="storageTypeAll"><i>All</i></label>                                    
                                        </div>
                                    </div>
                                    <div>
                                        <input type="radio" id="storageTypeHdd" name="storageType" value="hdd" >
                                        <div class="radio_button_label">
                                            <label for="storageTypeHdd"><i>HDD</i></label>         
                                        </div>
                                    </div>
                                    <div>
                                        <input type="radio" id="storageTypeSsd" name="storageType" value="ssd" >
                                        <div class="radio_button_label"> 
                                           <label for="storageTypeSsd"><i>SSD</i></label>         
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>  
                    
                        <c:if test="${componentType=='Storage'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Interface</div>
                                <div class="search_filter_checkbox_list">
                                    <select name="socket">
                                        <c:forEach items="${storageInterface}" var="storageInterface_">
                                            <option value="${storageInterface_.value}">${storageInterface_.value}</option>
                                        </c:forEach>
                                    </select>          
                                </div>
                            </div>
                        </c:if>  
                        <c:if test="${componentType=='Storage' }">
                            <div class ="search_filter_wrapper"> 
                              <div class ="search_filter_label">Capacity </div>
                              <div class="search_slider" id="storagecapacity_slider"></div>   
                              <div class="search_slider_label_container">
                                  <input type = "text" id = "storagecapacityrange" name= "storagecapacityrange" readonly="readonly"  >  
                                  <div style="display: none;">
                                      <div class="search_slider_label_min"><input type = "text" id = "sminstoragecapacity" name= "sminstoragecapacity" readonly="readonly" ></div>  
                                      <div class="search_slider_label_max"><input type = "text" id = "smaxstoragecapacity" name= "smaxstoragecapacity" readonly="readonly" ></div>      
                                  </div>           
                              </div>                   
                            </div>
                        </c:if> 
                    
                        <c:if test="${componentType=='Mouse'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Connection Type</div>
                                <div class="search_filter_checkbox_list">
                                    <div>
                                        <input type="radio" id="connectionTypeAll" name="connectionType" value="all" checked>
                                        <div class="radio_button_label"> 
                                            <label for="connectionTypeAll"><i>All</i></label>                                    
                                        </div>
                                    </div>
                                    <div>
                                        <input type="radio" id="connectionTypeHdd" name="connectionType" value="wired" >
                                        <div class="radio_button_label">
                                            <label for="connectionTypeHdd"><i>Wired</i></label>         
                                        </div>
                                    </div>
                                    <div>
                                        <input type="radio" id="connectionTypeSsd" name="connectionType" value="wireless" >
                                        <div class="radio_button_label"> 
                                           <label for="connectionTypeSsd"><i>Wireless</i></label>         
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>  
                    
                        <c:if test="${componentType=='Mouse'}">
                            <div class ="search_filter_wrapper"> 
                              <div class ="search_filter_label">DPI Range</div>
                              <div class="search_slider" id="DPI_slider"></div>   
                              <div class="search_slider_label_container">
                                  <input type = "text" id = "DPIrange" name= "DPIrange" readonly="readonly"  >  
                                  <div style="display: none;">
                                      <div class="search_slider_label_min"><input type = "text" id = "sminDPI" name= "sminDPI" readonly="readonly" ></div>  
                                      <div class="search_slider_label_max"><input type = "text" id = "smaxDPI" name= "smaxDPI" readonly="readonly" ></div>      
                                  </div>           
                              </div>                   
                            </div>
                        </c:if> 
                    
                        <c:if test="${componentType=='Keyboard'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Type</div>
                                <div class="search_filter_checkbox_list">
                                    <div>
                                        <input type="radio" id="keyboardTypeAll" name="keyboardType" value="all" checked>
                                        <div class="radio_button_label"> 
                                            <label for="keyboardTypeAll"><i>All</i></label>                                    
                                        </div>
                                    </div>
                                    <div>
                                        <input type="radio" id="keyboardTypeStandard" name="keyboardType" value="standard" >
                                        <div class="radio_button_label">
                                            <label for="keyboardTypeStandard"><i>Standard</i></label>         
                                        </div>
                                    </div>
                                    <div>
                                        <input type="radio" id="keyboardTypeGaming" name="keyboardType" value="gaming" >
                                        <div class="radio_button_label"> 
                                           <label for="keyboardTypeGaming"><i>Gaming</i></label>         
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>  
                    
                        <c:if test="${componentType=='Keyboard'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Backlight</div>
                                <div class="search_filter_checkbox_list">
                                    <div>
                                        <input type="radio" id="keyboardBacklitAll" name="keyboardBacklit" value="all" checked>
                                        <div class="radio_button_label"> 
                                            <label for="keyboardBacklitAll"><i>All</i></label>                                    
                                        </div>
                                    </div>
                                    <div>
                                        <input type="radio" id="keyboardBacklitFalse" name="keyboardBacklit" value="true" >
                                        <div class="radio_button_label">
                                            <label for="keyboardBacklitFalse"><i>None</i></label>         
                                        </div>
                                    </div>
                                    <div>
                                        <input type="radio" id="keyboardBacklitTrue" name="keyboardBacklit" value="true" >
                                        <div class="radio_button_label"> 
                                           <label for="keyboardBacklitTrue"><i>Yes</i></label>         
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if> 
                    
                        <c:if test="${componentType=='Power Supply'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Form Factor</div>
                                <div class="search_filter_checkbox_list">
                                    <select name="socket">
                                        <c:forEach items="${formFactor}" var="formFactor_">
                                            <option value="${formFactor_.value}">${formFactor_.value}</option>
                                        </c:forEach>
                                    </select>          
                                </div>
                            </div>
                        </c:if>  
                        <c:if test="${componentType=='Power Supply'}">
                            <div class ="search_filter_wrapper"> 
                              <div class ="search_filter_label">Wattage range</div>
                              <div class="search_slider" id="wattage_slider"></div>   
                              <div class="search_slider_label_container">
                                  <input type = "text" id = "wattagerange" name= "wattagerange" readonly="readonly"  >  
                                  <div style="display: none;">
                                      <div class="search_slider_label_min"><input type = "text" id = "sminwattage" name= "sminwattage" readonly="readonly" ></div>  
                                      <div class="search_slider_label_max"><input type = "text" id = "smaxwattage" name= "smaxwattage" readonly="readonly" ></div>      
                                  </div>           
                              </div>                   
                            </div>
                        </c:if> 
                        <c:if test="${componentType=='CPU'||componentType=='Processor' ||componentType=='Cooler' ||componentType=='GPU' }">
                            <div class ="search_filter_wrapper"> 
                              <div class ="search_filter_label">TDP</div>
                              <div class="search_slider" id="tdp_slider"></div>   
                              <div class="search_slider_label_container">
                                  <input type = "text" id = "tdprange" name= "tdprange" readonly="readonly"  >  
                                  <div style="display: none;">
                                      <div class="search_slider_label_min"><input type = "text" id = "smintdp" name= "smintdp" readonly="readonly" ></div>  
                                      <div class="search_slider_label_max"><input type = "text" id = "smaxtdp" name= "smaxtdp" readonly="readonly" ></div>      
                                  </div>           
                              </div>                   
                            </div>
                        </c:if> 
                    
                        <c:if test="${componentType=='Monitor'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Max Resolution</div>
                                <div class="search_filter_checkbox_list">
                                    <select name="socket">
                                        <c:forEach items="${maxResolutions}" var="maxResolution_">
                                            <option value="${maxResolution_.value}">${maxResolution_.value}</option>
                                        </c:forEach>
                                    </select>          
                                </div>
                            </div>
                        </c:if>  
                        <c:if test="${componentType=='Monitor'}">
                            <div class ="search_filter_wrapper">                 
                                <div class ="search_filter_label">Aspect Ratio</div>
                                <div class="search_filter_checkbox_list">
                                    <select name="socket">
                                        <c:forEach items="${aspectRatios}" var="aspectRatio_">
                                            <option value="${aspectRatio_.value}">${aspectRatio_.value}</option>
                                        </c:forEach>
                                    </select>          
                                </div>
                            </div>
                        </c:if>  
                    
                        <c:if test="${componentType=='Monitor' }">
                            <div class ="search_filter_wrapper"> 
                              <div class ="search_filter_label">Screen Size </div>
                              <div class="search_slider" id="screensize_slider"></div>   
                              <div class="search_slider_label_container">
                                  <input type = "text" id = "screensizerange" name= "screensizerange" readonly="readonly"  >  
                                  <div style="display: none;">
                                      <div class="search_slider_label_min"><input type = "text" id = "sminscreensize" name= "sminscreensize" readonly="readonly" ></div>  
                                      <div class="search_slider_label_max"><input type = "text" id = "smaxscreensize" name= "smaxscreensize" readonly="readonly" ></div>      
                                  </div>           
                              </div>                   
                            </div>
                        </c:if> 
                    
                        <c:if test="${componentType=='Monitor' }">
                            <div class ="search_filter_wrapper"> 
                              <div class ="search_filter_label">Refresh Rate </div>
                              <div class="search_slider" id="refreshrate_slider"></div>   
                              <div class="search_slider_label_container">
                                  <input type = "text" id = "refreshraterange" name= "refreshraterange" readonly="readonly"  >  
                                  <div style="display: none;">
                                      <div class="search_slider_label_min"><input type = "text" id = "sminrefreshrate" name= "sminrefreshrate" readonly="readonly" ></div>  
                                      <div class="search_slider_label_max"><input type = "text" id = "smaxrefreshrate" name= "smaxrefreshrate" readonly="readonly" ></div>      
                                  </div>           
                              </div>                   
                            </div>
                        </c:if> 
                         
                        <div class ="search_filter_wrapper"> 
                            <div class ="search_filter_label">Price Range</div>
                            <div class="search_slider" id="price_slider"></div>   
                            <div class="search_slider_label_container">
                                <input type = "text" id = "pricerange" name= "pricerange" readonly="readonly"  >  
                                <div style="display: none;">
                                    <div class="search_slider_label_min"><input type = "text" id = "sminPrice" name= "sminPrice" readonly="readonly" ></div>  
                                    <div class="search_slider_label_max"><input type = "text" id = "smaxPrice" name= "smaxPrice" readonly="readonly" ></div>      
                                </div>           
                            </div>                   
                        </div>

                        <div class ="search_filter_wrapper"> 
                            <br><input type="submit" value="Filter results">
                        </div>
                    </form>


                </div>

                <div class ="search_results_container_outer">
                    <div class ="search_filter_banner">
                        <input type = "text" value="${componentType}" name="componentType" readonly="readonly">
                    </div>
                    <div class="search_results_container_inner">                      
                      
                        <form method="post" action = "Cart">
                                <a href ="#" style="color:black;"></a>
                                
                                <input type="submit" name = "submit" value ="qwe" >                                
                               <br>
                        </form>
                                      
                        <form method="post" action = "Cart">
                            
                            <input type="hidden" name ="numListItems" value ="${fn:length(componentslist)}">
                            <c:forEach items="${componentslist}" var="components_" varStatus ="loopCounter">
                                <c:forEach items="${components_.value}" var="details" varStatus="loopCounter2">
                                    <c:choose>
                                        <c:when test="${loopCounter2.index == 0}">
                                            compid: ${details.value}
                                            <input type ="hidden" name ="partid" value ="${details.value}">
                                        </c:when>
                                        <c:when test="${loopCounter2.index == 1}">
                                            partname: ${details.value}
                                        </c:when>
                                        <c:when test="${loopCounter2.index == 2}">
                                            price: ${details.value}
                                        </c:when>
                                        <c:otherwise>
                                            ${details.value}
                                        </c:otherwise>
                                    </c:choose>
                                   
                                   
                                </c:forEach>
                                 <input type="submit" value="Add to Cart" name="submit${loopCounter.index}">
                               <br>
                            </c:forEach>
                            
                       </form>      
                                
                        
                
                                
                       
                    </div>
                    
                    
              
                    
                    
                </div>




               
        </div>
        
               
        
       
    </body>
</html>
