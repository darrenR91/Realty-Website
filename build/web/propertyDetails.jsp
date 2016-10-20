<%-- 
    Document   : propertyDetails
    Created on : 30-Nov-2015, 23:21:48
    Author     : Darren
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
  <head>
      <jsp:include page="includes/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.servletsuite.com/servlets/cooktag" prefix="cookie" %>
    <title>Lit Real Estate</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">

  </head>
  <div class="body2">
  <div class="main">
    <section id="content">
      <div class="wrapper">
        
        <article class="col1">
           <c:choose>
            <c:when test="${not empty propertyDetails}">  
        
                       <div class="wrapper pad_bot3">
            <figure class="left marg_right1"><img src="images/properties/large/${propertyDetails.photo}" alt="" width="409" height="307"></figure>
            <p class="pad_bot1"><strong class="color2">Price: <span class="color1">€${propertyDetails.price}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">Street: <span class="color1">${propertyDetails.street}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">City: <span class="color1">${propertyDetails.city}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">Style Type: <span class="color1">${StyleType}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">Property Type: <span class="color1">${PropType}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">Number of Bedrooms: <span class="color1">${propertyDetails.bedrooms}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">Number of Bathrooms: <span class="color1">${propertyDetails.bathrooms}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">Square Feet: <span class="color1">${propertyDetails.squarefeet}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">lot Size: <span class="color1">${propertyDetails.lotsize}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">Garage Size: <span class="color1">${propertyDetails.garagesize}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">Garage Type: <span class="color1">${GarageType}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">Agent ID: <span class="color1">${propertyDetails.agentId}</span></strong></p>
            <p class="pad_bot1"><strong class="color2">Date Added: <span class="color1">${propertyDetails.dateAdded}</span></strong></p>
  
            <strong class="color2">Description:</strong>
              <p class="pad_bot2"> ${propertyDetails.description}</p>
            
           
                    <c:choose>
                        <c:when test="${not empty favourite}">  
                            Already Added to wish list
                        </c:when>
                        <c:otherwise>
                               <button class="button" onclick="location.href='ManageFavourites?favourites=&propID=${propertyDetails.id}'">Favorite</button>

                                <br />
                        </c:otherwise>
                    </c:choose>  
                       </div>
              </c:when>
                <c:otherwise>
                   No Property Selected to view
                    <br />
                </c:otherwise>
        </c:choose>  
   </article>
        
        <article class="col2">
             
            <h7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Agents Details</h7><br><br>
            <div class="AD"> 
<!--              <div class="wrapper pad_bot3">-->
                <figure class="left marg_right1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/agents/${anAgent.username}.jpg" alt=""></figure>
                
                <p class="pad_bot1"><br><strong class="color2">${anAgent.name}<br><br><br><br></strong>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Phone Number: <span class="color1">${anAgent.phone}</span><br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Fax Number: <span class="color1">${anAgent.fax}</span><br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Email Address: <span class="color1">${anAgent.email}</span></p>
<!--              </div>-->
         </div> 
        </article>
       
    </section>
    </div>  
        
        <h5>Find This Property On Google Maps</h5>
        <div id="GoogleMap"></div><br><br>
       
 </div>    
      
     
    
    
  </div>
</div>
<div class="body">
  <input id="address" type="hidden" value="${propertyDetails.street}, ${propertyDetails.city}">

    
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBgxk75dsVuxg9dZ_2QsVsWbW1hfR6hWS4&signed_in=true&callback=initMap"
        async defer></script>
  <script>
function initMap() {
  var map = new google.maps.Map(document.getElementById('GoogleMap'), {
    zoom: 12,
    center: {lat: 53.481, lng: -7.769}
  });
  var geocoder = new google.maps.Geocoder();

  
    geocodeAddress(geocoder, map);
  
}

function geocodeAddress(geocoder, resultsMap) {
  var address = document.getElementById('address').value;
  geocoder.geocode({'address': address}, function(results, status) {
    if (status === google.maps.GeocoderStatus.OK) {
      resultsMap.setCenter(results[0].geometry.location);
      var image = "images/House.png";
      var marker = new google.maps.Marker({
        map: resultsMap,
        position: results[0].geometry.location,
        icon: image
      });
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
}
 </script>
<jsp:include page="includes/footer.jsp" />

</body>
</html>

