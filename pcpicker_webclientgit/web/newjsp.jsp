<!doctype html>
<html lang = "en">
   <head>
      <meta charset = "utf-8">
      <title>jQuery UI Slider functionality</title>
      <script>
      $(function () {
    $("#slider").slider({
        animate: "fast",
        value: 0,
        min: 0,
        max: 50,
        step: 1,
        range:true,
        value: [0, 90000],
        slide: function (event, ui) {
            if ($("#1").hasClass('res1')) {
                $("#1").toggleClass('res1 res2');
            }
        }
    });
});
</script>
   </head>
   
   <body>
                <div id="slider" align="center" style="width:50%;margin-left:20%;"></div>
             <div id="1" class="res1" style="margin:10px auto"></div>
   </body>
</html>