<%-- 
    Document   : managePropertyList
    Created on : 11-Dec-2015, 01:16:55
    Author     : Darren
--%>
<html lang="en">
<title>Lit Real Estate</title>
<jsp:include page="/includes/header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/s/dt/jq-2.1.4,dt-1.10.10/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/s/dt/jq-2.1.4,dt-1.10.10/datatables.min.js"></script>-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Property List</title>
        <head>
        <link href="css/media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="css/media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="css/media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="css/media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
        <script src="css/scripts/jquery-1.4.4.min.js" type="text/javascript"></script>
        <script src="css/scripts/jquery.dataTables.min.js" type="text/javascript"></script>





<%@ taglib uri="http://www.servletsuite.com/servlets/cooktag" prefix="cookie"%>

<div class="body2">
  <div class="main">
    <section id="content">
      <div class="wrapper">
        <article class="col1">
            <h2 class="pad_bot1 pad_top1">Manage Properties</h2>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong class="color2">${Status}<br><br>
            <body id="dt_example">
            <div id="container">
            <div id="demo_jui">
                <table id="Properties" class="display">
                    <thead>
                        <tr>
                            <th>Property Photo</th>
                            <th>Listing No.</th>
                            <th>Date Added</th>
                            <th>Price</th>
                            <th>Options</th>
                        </tr>
                    </thead>
                    <c:forEach items="${propertyList}" var="aProperty">
                <tr>
                    <td><a href="PropertySearch?propID=${aProperty.id}"><img src="images/properties/thumbnails/${aProperty.photo}"></a></td>
                    <td>${aProperty.listingNum}</td>
                    <td>${aProperty.dateAdded}</td>
                    <td>${aProperty.price}</td>
                    <td><button class="button" onclick="location.href='ManagePropertys?agentId=${aProperty.agentId}&propID=${aProperty.id}'">Update</button>
                    <input  class="button" id="delete" type="button" value="Delete" onclick="confirmDelete(${aProperty.id});" /></td>
                    
                </tr>
            </c:forEach> 
                    </tbody>
                </table>
         </div>
        </div> 
            </body>
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
<script type="text/javascript">
        function confirmDelete(Id)
        {
        var r = confirm("Are you sure you want to delete this property?\n Properety ID: "+ Id);
        if (r == true) {
            document.location = "ManagePropertys?del="+Id;
        } else {
            return false;
        }
        document.getElementById("demo").innerHTML = txt;
        }
        $(document).ready(function () {
            $("#Properties").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            });
        });
        </script>