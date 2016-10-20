<%-- 
    Document   : header
    Created on : 14-Dec-2015, 13:03:27
    Author     : Darren
--%>


<meta charset="utf-8">
<link rel="stylesheet" href="/RealtyWebsite/css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="/RealtyWebsite/css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="/RealtyWebsite/css/style.css" type="text/css" media="all">
<script src="/RealtyWebsite/js/jquery-1.6.js" ></script>
<script src="/RealtyWebsite/js/cufon-yui.js"></script>
<script src="/RealtyWebsite/js/cufon-replace.js"></script>
<script src="/RealtyWebsite/js/Didact_Gothic_400.font.js"></script>
<script src="/RealtyWebsite/js/jquery.nivo.slider.pack.js"></script>
<script src="/RealtyWebsite/js/atooltip.jquery.js"></script>
<script src="/RealtyWebsite/js/jquery.jqtransform.js" ></script>
<script src="/RealtyWebsite/js/script.js"></script>
<script src="/RealtyWebsite/js/jquery.easing.1.3.js"></script>


<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<style type="text/css">.bg{behavior:url("js/PIE.htc");}</style>
<![endif]-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body id="page1">

<div class="body1">
  <div class="main">
    <!-- header -->
    <header>
      <h1><a href="Index" id="logo"></a></h1>
            
      <div class="wrapper">
        <ul id="icons">
            
          <li><a href="#" class="normaltip">
                  
              <c:choose>
            <c:when test="${not empty pageContext.request.userPrincipal.name}">  
                      <li><a href="/RealtyWebsite/Index?logout">Logout</a><br><a href="/RealtyWebsite/ManageAgents?GetAgentsProfile=View+Profile">Agent/Admin Portal</a></li>
                      <img src="/RealtyWebsite/images/agents/${pageContext.request.userPrincipal.name}.jpg" alt="">      

              </c:when>
                <c:otherwise>
                    <li><a href="/RealtyWebsite/ManageAgents?GetAgentsProfile=View+Profile">Login</a><br>
                  <a href="/RealtyWebsite/ManageFavourites">Favorites</a></li>
                  <img src="/RealtyWebsite/images/agents/placeholder.PNG" alt="">
                </c:otherwise>
        </c:choose>  
              
              </a></li>
          
          
        </ul>
      </div>
      <nav>
        <ul id="menu">
          <li id="${pageContext.request.requestURI eq '/RealtyWebsite/index.jsp' ? 'menu_active' : ''}"><a href="Index">Property for sale</a></li>
          <li id="${pageContext.request.requestURI eq '/RealtyWebsite/agentsList.jsp' ? 'menu_active' : ''}"><a href="Index?allAgents">Agents Details</a></li>
          <li id="${pageContext.request.requestURI eq '/RealtyWebsite/Index?recentlyAdded' ? 'menu_active' : ''}"><a href="Index?recentlyAdded">Recent Properties</a></li>
          <li id="${pageContext.request.requestURI eq '/RealtyWebsite/about.jsp' ? 'menu_active' : ''}"><a href="about.jsp">About</a></li>
          
        </ul>
      </nav>

    </header>
        
    <!-- / header -->
  </div>
</div>