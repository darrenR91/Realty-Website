<%-- 
    Document   : index2
    Created on : 14-Dec-2015, 13:49:23
    Author     : Darren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Lit Real Estate</title>
<jsp:include page="includes/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- content -->
<div class="body2">
  <div class="main">
    <section id="content">
      <div class="wrapper">
        <article class="col1">
          <div id="slider"> 
              <c:forEach items="${FiveOldest}" var="oldProp">
            
                  <a href="PropertySearch?propID=${oldProp.id}"><img src="images/properties/large/${oldProp.photo}" alt="" title="<strong>${oldProp.street}, ${oldProp.city}</strong><span>${oldProp.bedrooms} bedrooms, ${oldProp.bathrooms} baths &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Price: €${oldProp.price} &nbsp; &nbsp; &nbsp; <a href='PropertySearch?propID=${oldProp.id}'>Read more</a></span>"></a>
           
            </c:forEach> 
              
            
          </div>
            
        </article>
        <article class="col2">
          <form name="" id="form_1" action="PropertySearch" method="GET">
            <div class="pad1">
              <h3>Find Your Property</h3>
              <div class="row_select">
                <div class="cols">City:<br>
                    <select name="location" id="location" class="location">
                    <c:forEach items="${Locations}" var="aLocation">
                        <option>${aLocation}</option>
                     </c:forEach> 
                        <option>AllLocations</option>
                    </select>
                </div>
              </div>
              <div class="row">Price Range:<br>
                <input name="minPrice" type="number" id="minPrice" class="input" />
              </div>
                     <div class="row">To<br>
                <input name="maxPrice" type="number" id="maxPrice" class="input"/>
              </div>
                     <div class="row_select pad_bot1">
                <br>
                <div class="cols pad_left1"> <input type="submit" class="button" value="Search" name="propertySearch" /> </div>
              </div>
              </div>
          </form>
        </article>
      </div>
    </section>
  </div>
</div>
<div class="body3">
  <div class="main">
    <section id="content2">
      <div class="wrapper">
        <article class="col1">
          <div class="pad2">
            <h2>Recently Added</h2>
               <c:choose>
                    <c:when test ="${not empty FiveRecent}">
            <c:forEach items="${FiveRecent}" var="newProp">
            
               <div class="wrapper pad_bot3">
              <figure class="left marg_right1"><a href="PropertySearch?propID=${newProp.id}"><img src="images/properties/large/${newProp.photo}" alt="" width="150" height="110"></a></figure>
              <p class="pad_bot1"><strong class="color2">${newProp.street}, ${newProp.city}<br>
                Price: <span class="color1">€${newProp.price}</span></strong></p>
              <p class="pad_bot2"> ${newProp.description}</p>
              <a href="PropertySearch?propID=${newProp.id}" class="button">Read more</a> </div>
              
            </c:forEach> 
              </c:when>
                <c:otherwise>
                   No Recent Properties
                    <br />
                </c:otherwise>
        </c:choose>
            
          </div>
        </article>
      </div>
    </section>
  </div>
</div>
<!-- / content -->
<jsp:include page="includes/footer.jsp" />
<script>Cufon.now();</script>
<script>
$(window).load(function () {
    $('#slider').nivoSlider({
        effect: 'sliceUpDown', //Specify sets like: 'fold,fade,sliceDown, sliceDownLeft, sliceUp, sliceUpLeft, sliceUpDown, sliceUpDownLeft'
        slices: 17,
        animSpeed: 500,
        pauseTime: 6000,
        startSlide: 0, //Set starting Slide (0 index)
        directionNav: false, //Next & Prev
        directionNavHide: false, //Only show on hover
        controlNav: true, //1,2,3...
        controlNavThumbs: false, //Use thumbnails for Control Nav
        controlNavThumbsFromRel: false, //Use image rel for thumbs
        controlNavThumbsSearch: '.jpg', //Replace this with...
        controlNavThumbsReplace: '_thumb.jpg', //...this in thumb Image src
        keyboardNav: true, //Use left & right arrows
        pauseOnHover: true, //Stop animation while hovering
        manualAdvance: false, //Force manual transitions
        captionOpacity: 1, //Universal caption opacity
        beforeChange: function () {
            $('.nivo-caption').animate({
                bottom: '-110'
            }, 400, 'easeInBack')
        },
        afterChange: function () {
            Cufon.refresh();
            $('.nivo-caption').animate({
                bottom: '-20'
            }, 400, 'easeOutBack')
        },
        slideshowEnd: function () {} //Triggers after all slides have been shown
    });
    Cufon.refresh();
});
</script>
</body>
</html>
