package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Maps_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <title>Geocoding service</title>\n");
      out.write("    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\">\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <style>\n");
      out.write("#floating-panel {\n");
      out.write("  position: absolute;\n");
      out.write("  top: 10px;\n");
      out.write("  left: 25%;\n");
      out.write("  z-index: 5;\n");
      out.write("  background-color: #fff;\n");
      out.write("  padding: 5px;\n");
      out.write("  border: 1px solid #999;\n");
      out.write("  text-align: center;\n");
      out.write("  font-family: 'Roboto','sans-serif';\n");
      out.write("  line-height: 30px;\n");
      out.write("  padding-left: 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div id=\"floating-panel\">\n");
      out.write("      <input id=\"address\" type=\"textbox\" value=\"Sydney, NSW\">\n");
      out.write("      <input id=\"submit\" type=\"button\" value=\"Geocode\">\n");
      out.write("    </div>\n");
      out.write("    <div id=\"map\"></div>\n");
      out.write("    <script>\n");
      out.write("function initMap() {\n");
      out.write("  var map = new google.maps.Map(document.getElementById('map'), {\n");
      out.write("    zoom: 8,\n");
      out.write("    center: {lat: -34.397, lng: 150.644}\n");
      out.write("  });\n");
      out.write("  var geocoder = new google.maps.Geocoder();\n");
      out.write("\n");
      out.write("  document.getElementById('submit').addEventListener('click', function() {\n");
      out.write("    geocodeAddress(geocoder, map);\n");
      out.write("  });\n");
      out.write("}\n");
      out.write("\n");
      out.write("function geocodeAddress(geocoder, resultsMap) {\n");
      out.write("  var address = document.getElementById('address').value;\n");
      out.write("  geocoder.geocode({'address': address}, function(results, status) {\n");
      out.write("    if (status === google.maps.GeocoderStatus.OK) {\n");
      out.write("      resultsMap.setCenter(results[0].geometry.location);\n");
      out.write("      var marker = new google.maps.Marker({\n");
      out.write("        map: resultsMap,\n");
      out.write("        position: results[0].geometry.location\n");
      out.write("      });\n");
      out.write("    } else {\n");
      out.write("      alert('Geocode was not successful for the following reason: ' + status);\n");
      out.write("    }\n");
      out.write("  });\n");
      out.write("}\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("    <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBgxk75dsVuxg9dZ_2QsVsWbW1hfR6hWS4&signed_in=true&callback=initMap\"\n");
      out.write("        async defer></script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
