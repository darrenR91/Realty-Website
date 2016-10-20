<%-- 
    Document   : editPersonalDetails
    Created on : 14-Dec-2015, 23:08:14
    Author     : Darren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<title>Lit Real Estate</title>
<jsp:include page="/includes/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="body2">
  <div class="main">
    <section id="content">
      <div class="wrapper">
        <article class="col1">
            <c:choose>
            <c:when test="${not empty agent}">  
                <div class="pad2">
            <h2 class="pad_bot1 pad_top1">Edit Personal Details</h2>
            <form id="ContactForm" method="POST" name="setAgentsProfile" action="ManageAgents">
              <div>
                <div  class="wrapper"> <span>Name:</span>
                  <input type="text" class="input" value="${agent.name}" id="name" name="name">
                </div>
                <div  class="wrapper"> <span>Phone Number:</span>
                  <input type="text" class="input" value="${agent.phone}"  id="phoneNumber" name="phoneNumber">
                </div>
                  <div  class="wrapper"> <span>Fax Number:</span>
                  <input type="text" class="input" value="${agent.fax}"  id="faxNumber" name="faxNumber">
                </div>
                  <div  class="wrapper"> <span>Email Address:</span>
                  <input type="text" class="input" value="${agent.email}"  id="emailAddress" name="emailAddress">
                </div>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="button" value="Save"/>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong class="color2">${Status}<br>
                  </div>
            </form>
          </div>
                   
              </c:when>
                <c:otherwise>
                    <c:redirect url="/ManageAgents?GetAgentsProfile=View+Profile"/>
                    </c:otherwise>
        </c:choose>
                 
        </article>
        <article class="col2">
          <form id="form_1" action="#" method="post">
            <div class="pad1">
                
              <h3>Agents Profile</h3>
              <div class="row"><a href="/RealtyWebsite/ManagePropertys?GetProperties" class="button">Manage Property</a>
              </div>
              <div class="row"><a href="/RealtyWebsite/ManagePropertys?AddNewProperty" class="button">New Property</a>
            </div>
            </div>
          </form>
        </article>
      </div>
    </section>
  </div>
</div>
<!-- / content -->
<jsp:include page="/includes/footer.jsp" />

</body>
</html>