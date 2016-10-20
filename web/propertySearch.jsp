<%-- 
    Document   : propertySearch
    Created on : 30-Nov-2015, 22:25:21
    Author     : Darren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Lit Real Estate</title>
<jsp:include page="includes/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/includes/datatables.jsp" />
<!-- content -->
<div class="body2">
  <div class="main">
    <section id="content">
      <div class="wrapper">
        <article class="col1">
            <div>
    <body id="dt_example">
        <div id="container">
            <div id="demo_jui">
                <table id="Properties" class="display">
                    <thead>
                        <tr>
                            <th>Property Photo</th>
                            <th>Description</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <c:forEach items="${list}" var="aProperty">
                <tr>
                    <td><a href="PropertySearch?propID=${aProperty.id}"><img src="/RealtyWebsite/images/properties/thumbnails/${aProperty.photo}"></a></td>
                    <td>${aProperty.description}</td>
                    <td>${aProperty.price}</td>
             
                    
                </tr>
            </c:forEach> 
                    </tbody>
                </table>
         </div>
        </div> 
    </body>
    </div> 
        </article>
        <article class="col2">
          <form method="GET" id="form_1" action="PropertySearch" name="">
            <div class="pad1">
              <h3>Find Your Property</h3>
              <div class="row_select">
                <div class="cols">City:<br>
                    <select name="location" id="location" class="location">
                        <c:forEach items="${Locations}" var="aLocation">
                        <c:choose>
                            <c:when test="${Location==aLocation}">  
                                <option selected="selected"> ${aLocation}</option>
                            </c:when>
                            <c:otherwise>
                                <option>${aLocation}</option>
                            </c:otherwise>
                        </c:choose></c:forEach>
                                <c:choose><c:when test="${Location!='AllLocations'}">  
                                <option>AllLocations</option>
                            </c:when>
                                <c:when test="${Location=='AllLocations'}">  
                                <option selected="selected"> ${Location}</option>
                            </c:when></c:choose>
                    </select>
                </div>
              </div>
              <div class="row_select">
                <div class="cols"> Price Range:<br>
                <input name="minPrice" type="number" id="minPrice" class="inputNum" value="${minPrice}"/>
              </div>
                 <div class="cols pad_left1">To<br>
                <input name="maxPrice" type="number" id="maxPrice" class="inputNum" value="${maxPrice}"/>
              </div>
              </div>
              <div class="row_select">
                <div class="cols">Property Sq ft:<br>
                  <select name="minSquareFeet" id="minSquareFeet" class="minSquareFeet">
                    <c:choose><c:when test="${not empty minSquareFeet && maxSquareFeet!=-1}">  
                        <option selected="selected"> ${minSquareFeet}</option>
                      </c:when></c:choose>
                      <option>0</option>
                    <option>500</option>
                    <option>1000</option>
                    <option>1500</option>
                    <option>2000</option>
                    <option>2500</option>
                  </select>
                </div>
                <div class="cols pad_left1"> To:<br>
                  <select name="maxSquareFeet" id="maxSquareFeet" class="maxSquareFeet">
                      <c:choose><c:when test="${not empty maxSquareFeet && maxSquareFeet!=-1 }">  
                        <option selected="selected"> ${maxSquareFeet}</option>
                      </c:when></c:choose>
                      <option>500</option>
                        <option>1000</option>
                        <option>1500</option>
                        <option>2000</option>
                        <option>2500</option>
                   </select>
                </div>
              </div>
              <div class="row_select pad_bot1">
                <div class="cols"> Bedroom(s):<br>
                    <select name="bedrooms" value="${bedrooms}" id="bedrooms" class="bedrooms">
                        <c:forEach items="${RoomCount}" var="aBedrooms">
                           <c:choose>
                            <c:when test="${bedrooms==aBedrooms}">  
                                <option selected="selected"> ${aBedrooms}</option>
                            </c:when>
                            <c:otherwise>
                                <option>${aBedrooms}</option>
                            </c:otherwise>
                        </c:choose>
                        </c:forEach> 
                    </select>
                </div>
                <div class="cols pad_left1"><input type="submit" class="button" value="Re-Define" name="propertySearch" /> </div>
              </div>
              </div>
          </form>
        </article>
      </div>
    </section>
  </div>
</div>
<!-- / content -->
<jsp:include page="includes/footer.jsp" />

</body>
</html>