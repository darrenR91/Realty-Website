<%-- 
    Document   : admin
    Created on : 15-Dec-2015, 02:34:05
    Author     : Darren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<title>Lit Real Estate Admin</title>
<jsp:include page="/includes/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="body2">
  <div class="main">
    <section id="content">
      <div class="wrapper">
        <article class="col1">
            
                    <h2 class="pad_bot1 pad_top1">Please Select An Admin Option on the right.</h2>
       
        </article>
        <article class="col2">
          <form id="form_1" action="#" method="post">
            <div class="pad1">
                
              <h3>Administrator Profile</h3>
              <div class="row"><a href="/RealtyWebsite/ManagePropertys?GetProperties" class="button">Manage Property</a>
              </div>
              <div class="row"><a href="/RealtyWebsite/ManagePropertys?AddNewProperty" class="button">New Property</a>
            </div>
              <div class="row"><a href="/RealtyWebsite/ManageAdmin?GetPDF" class="button">Generate Report</a>
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