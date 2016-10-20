<%-- 
    Document   : propertySearch
    Created on : 30-Nov-2015, 22:25:21
    Author     : Darren
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>My Favourites List</title>
<jsp:include page="includes/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/includes/datatables.jsp" />
<%@ taglib uri="http://www.servletsuite.com/servlets/cooktag" prefix="cookie" %>
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
                <c:choose>
                    <c:when test ="${not empty list}">
                <table id="Properties" class="display">
                    <thead>
                        <tr>
                            <th>Property Photo</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>WishList</th>
                        </tr>
                    </thead>
                    <c:forEach items="${list}" var="aProperty">
                <tr>
                    <td><a href="PropertySearch?propID=${aProperty.id}"><img src="/RealtyWebsite/images/properties/thumbnails/${aProperty.photo}"></a></td>
                    <td>${aProperty.description}</td>
                    <td>${aProperty.price}</td>
                    <td>
                    <button class="button" onclick="location.href='ManageFavourites?removeFavourites=&propID=${aProperty.id}'">Remove</button>
                    
                    </td>
                    
                </tr>
            </c:forEach> 
                    </tbody>
                </table>
         </div>
             </c:when>
                <c:otherwise>
                   No Properties in wish list
                    <br />
                </c:otherwise>
        </c:choose>
        </div> 
    </body>
    </div> 
        </article>
        <article class="col2">
          <form id="ContactForm" method="GET"  action="ManageFavourites">
            <div class="pad1">
              <h3>Email Favourites</h3>
              
              <div class="row">Name:<br>
                <input type="text" class="input" value="${agent.name}" id="name" name="name">
              </div>
                     <div class="row">Email Address<br>
                <input type="text" class="input" value="${agent.email}"  id="emailAddress" name="emailAddress">
              </div>
                     <div class="row_select pad_bot1">
                <br>
                <div class="cols pad_left1"> <input type="submit" class="button" value="Send Email" name="emailFavourites"/>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong class="color2">${Status}<br> </div>
              </div>
              </div>
          </form>
           
          <form id="ContactForm" method="GET"  action="ManageFavourites">
            <div class="pad1">
              <h3>Generate Favourites Link</h3>
              
              <div class="row">Enter Name of Favourites List:<br>
                <input type="text" class="input" value="${agent.name}" id="name" name="name">
              </div>
            
                     <div class="row_select pad_bot1">
                <br>
                <div class="cols pad_left1"> <input type="submit" class="button" value="Send Email" name="generateFavourites"/>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong class="color2">${Status}<br> </div>
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