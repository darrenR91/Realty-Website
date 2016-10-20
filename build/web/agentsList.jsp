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
          <c:forEach items="${list}" var="anAgent">
            <c:choose>
            <c:when test="${anAgent.name!='admin'}">  
               <div class="wrapper pad_bot3">
                <figure class="left marg_right1"><img src="images/agents/${anAgent.username}.jpg" alt=""></figure>
                <p class="pad_bot1"><strong class="color2">${anAgent.name}<br></strong>
                 Phone Number: <span class="color1">${anAgent.phone}</span>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Fax Number: <span class="color1">${anAgent.fax}</span><br>
                 Email Address: <span class="color1">${anAgent.email}</span></p>
              </div>
            </c:when>
            </c:choose>
            </c:forEach> 
            
            
            
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
