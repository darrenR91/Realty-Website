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