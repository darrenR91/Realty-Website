<%-- 
    Document   : managePropertyDetails
    Created on : 08-Dec-2015, 19:30:48
    Author     : Darren
--%>
<html lang="en">
<title>Lit Real Estate</title>
<jsp:include page="/includes/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="body2">
  <div class="main">
    <section id="content">
      <div class="wrapper">
           <article class="col1">
            
            <div class="pad2">
            <h2 class="pad_bot1 pad_top1">Edit Property</h2>
            <form name="frm" action="ManagePropertys" method="POST" enctype="multipart/form-data" onSubmit="return showFileSize()">
                <input type="hidden" name="id" value="${propertyDetails.id}">
                <input type="hidden" name="dateAdded" value="${propertyDetails.dateAdded}">
                <input type="hidden" name="photo" value="${propertyDetails.photo}">
              <div>
                
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="25%"> </td>
    <td width="75%"> </td>
    </tr>

  <tr>
  <td>Upload Property Image</td>
  <td><input type='file' name="uploadFile" id="fileinput"><br><br></td>
  </tr>
  <tr>
    <td>Street</td>
    <td><input type="text" name="street" id="street" value="${propertyDetails.street}" /><br><br></td>
  </tr>
  <tr>
    <td>City</td>
    <td><input type="text" name="city" id="city" value="${propertyDetails.city}"/><br><br></td>
  </tr>
  <tr>
    <td>Listing Number</td>
    <td><input type="text" name="listingNum" id="listingNum" value="${propertyDetails.listingNum}"/><br><br></td>
  </tr>
  <tr>
    <td>Style Type</td>
    <td><select name="styleId" >
           <c:forEach items="${Styles}" var="aStyle">
           	<c:choose>
            <c:when test="${propertyDetails.styleId==aStyle.styleId}">  
                
          <option selected="selected" value="${aStyle.styleId}" > ${aStyle.propStyle}</option>
          
            </c:when>
             <c:otherwise>
                   <option value="${aStyle.styleId}">${aStyle.propStyle}</option> 
                    <br />
                </c:otherwise>
        </c:choose> 
             </c:forEach> 
    </select><br><br></td>
  </tr>
  <tr>
    <td>Property Type</td>
    <td><select name="typeId" >
           <c:forEach items="${Propertytypes}" var="aPropertyType">
           	<c:choose>
            <c:when test="${propertyDetails.typeId==aPropertyType.typeId}">  
                
          <option selected="selected" value="${aPropertyType.typeId}" >${aPropertyType.propType}</option>
          
            </c:when>
             <c:otherwise>
                   <option value="${aPropertyType.typeId}">${aPropertyType.propType}</option> 
                    <br />
                </c:otherwise>
        </c:choose> 
             </c:forEach> 
    </select>
    
    <br><br></td>
  </tr>
  <tr>
    <td>Bedrooms</td>
    <td><input type="text" pattern="[0-9.,]+" name="bedrooms" value="${propertyDetails.bedrooms}" /><br><br></td>
  </tr>
  <tr>
    <td>Bathrooms</td>
    <td><input type="text" pattern="[0-9.,]+" name="bathrooms" value="${propertyDetails.bathrooms}" /><br><br></td>
  </tr>
  <tr>
    <td>Square feet</td>
    <td><input type="text" name="squarefeet" value="${propertyDetails.squarefeet}"/><br><br></td>
  </tr>
  <tr>
    <td>Description</td>
    <td><textarea name="description" cols=48 rows=4>${propertyDetails.description}</textarea><br><br></td>
  </tr>
  <tr>
    <td>Lot Size</td>
    <td><input type="text" name="lotsize" value="${propertyDetails.lotsize}"/><br><br></td>
  </tr>
  <tr>
    <td>Garage Size</td>
    <td><input type="number" name="garageSize" pattern="[0-9]+" max="127" value="${propertyDetails.garagesize}"/><br><br></td>
  </tr>
  <tr>
    <td>Garage Type</td>
    <td><select name="garageId" >
           <c:forEach items="${Garagetypes}" var="aGarageType">
           	
                
                <c:choose>
            <c:when test="${propertyDetails.garageId==aGarageType.garageId}">  
                
          <option selected="selected" value="${aGarageType.garageId}" >${aGarageType.garageType}</option>
          
            </c:when>
             <c:otherwise>
                   <option value="${aGarageType.garageId}">${aGarageType.garageType}</option> 
                    <br />
                </c:otherwise>
        </c:choose> 
             </c:forEach>   
      </select><br><br></td>
  </tr>
  <tr>
    <br><td>Price</td>
    <td><input type="text" name="price" pattern="[0-9.,]+" size="8" value="${propertyDetails.price}"/><br><br></td>
  </tr>
  <tr>
      <td>Assign Agent</td>
    <td><select name="agentId" >
           <c:forEach items="${allAgents}" var="aAgents">
           	
                
                <c:choose>
            <c:when test="${propertyDetails.agentId==aAgents.agentId && aAgents.name!='admin'}">  
                
          <option selected="selected" value="${aAgents.agentId}" >${aAgents.name}</option>
          
            </c:when>
            <c:when test="${aAgents.name!='admin'}">  
            <option value="${aAgents.agentId}">${aAgents.name}</option> 
            </c:when>
        </c:choose> 
             </c:forEach>   
      </select></td>
  </tr>


</table>
                  
                  
  <br><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="button" value="Submit" />
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong class="color2">${Status}<br>
                  </div>
            </form>
          </div>

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
<script>
function showFileSize()
{
    input = document.getElementById('fileinput');
    file = input.files[0];
        if (file.size>20971520) {
            alert("File is " + 
                 parseInt(file.size/1024/1024)
                 + " Mb"+ "\n" + "Only files under 20Mb can be uploaded");
         return false;
        }
}
</script>
<script>
function showFileSize()
{
    input = document.getElementById('fileinput');
    file = input.files[0];
        if (file.size>20971520) {
            alert("File is " + 
                 parseInt(file.size/1024/1024)
                 + " Mb"+ "\n" + "Only files under 20Mb can be uploaded");
         return false;
        }
}
</script>