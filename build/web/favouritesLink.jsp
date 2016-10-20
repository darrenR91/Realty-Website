<%-- 
    Document   : favouriteLink
    Created on : 29-Jan-2016, 02:59:26
    Author     : darre
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
        <h2 class="pad_bot1 pad_top1">${name}'s favourites list</h2>
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
                  </c:when>
                <c:otherwise>
                   No Recent Properties
                    <br />
                </c:otherwise>
        </c:choose>
         </div>
        </div> 
    </body>
    </div> 
        </article>
        <article class="col2">
         
        </article>
      </div>
    </section>
  </div>
</div>
<!-- / content -->
<jsp:include page="includes/footer.jsp" />

</body>
</html>