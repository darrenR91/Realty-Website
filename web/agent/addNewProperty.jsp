<%-- 
    Document   : test
    Created on : 08-Dec-2015, 19:26:48
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
            <h2 class="pad_bot1 pad_top1">Add New Property</h2>
            <form name="frm" action="ManagePropertys" method="POST" enctype="multipart/form-data" onSubmit="return showFileSize()">
              <div>
                
                  <table width="100%" border="15" cellspacing="15" cellpadding="15">
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
    <td><input type="text" name="street" id="street" /><br><br></td>
  </tr>
  <tr>
    <td>City</td>
    <td><input type="text" name="city" id="city"/><br><br></td>
  </tr>
  <tr>
    <td>Listing Number</td>
    <td><input type="text" name="listingNum" id="listingNum"/><br><br></td>
  </tr>
  <tr>
    <td>Style Type</td>
    <td><select name="styleId" >
           <c:forEach items="${Styles}" var="aStyle">
           	<option value="${aStyle.styleId}">${aStyle.propStyle}</option></c:forEach> 
      </select><br><br></td>
  </tr>
  <tr>
    <td>Property Type</td>
    <td><select name="typeId" >
           <c:forEach items="${Propertytypes}" var="aPropertyType">
           	<option value="${aPropertyType.typeId}">${aPropertyType.propType}</option></c:forEach> 
      </select>
    
    <br><br></td>
  </tr>
  <tr>
    <td>Bedrooms</td>
    <td><input type="text" pattern="[0-9.,]+" name="bedrooms" /><br><br></td>
  </tr>
  <tr>
    <td>Bathrooms</td>
    <td><input type="text" pattern="[0-9.,]+" name="bathrooms" /><br><br></td>
  </tr>
  <tr>
    <td>Square feet</td>
    <td><input type="text" name="squarefeet" /><br><br></td>
  </tr>
  <tr>
    <td>Description</td>
    <td><textarea name="description" cols=48 rows=4></textarea><br><br></td>
  </tr>
  <tr>
    <td>Lot Size</td>
    <td><input type="text" name="lotsize" /><br><br></td>
  </tr>
  <tr>
    <td>Garage Size</td>
    <td><input type="number" name="garageSize" pattern="[0-9]+" max="127" /><br><br></td>
  </tr>
  <tr>
    <td>Garage Type</td>
    <td><select name="garageId" >
           <c:forEach items="${Garagetypes}" var="aGarageType">
           	<option value="${aGarageType.garageId}">${aGarageType.garageType}</option></c:forEach> 
      </select><br><br></td>
  </tr>
  <tr>
    <br><td>Price</td>
    <td><input type="text" name="price" pattern="[0-9.,]+" size="8"/><br><br></td>
  </tr>


</table>
                  
                  
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="button" value="Submit" />
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong class="color2">${Status}<br>
                  </div>
            </form>
          </div>

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