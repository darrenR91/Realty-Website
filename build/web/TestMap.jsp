
<%-- 
    Document   : propertyDetails
    Created on : 30-Nov-2015, 23:21:48
    Author     : Darren
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
  
    
<title>Lit Real Estate</title>
<jsp:include page="includes/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.servletsuite.com/servlets/cooktag" prefix="cookie" %>
<!-- content -->

<div class="body">


      <input id="address" type="hidden" value="Doneraile">

    <div id="map"></div>
    <script>
function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 8,
    center: {lat: -34.397, lng: 150.644}
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
        position: results[0].geometry.location
        icon: image
      });
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
}

    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBgxk75dsVuxg9dZ_2QsVsWbW1hfR6hWS4&signed_in=true&callback=initMap"
        async defer></script>
   
  </div>
<jsp:include page="includes/footer.jsp" />

</html>
