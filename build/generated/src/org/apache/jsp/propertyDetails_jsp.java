package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class propertyDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_cookie_ifNotCookie_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_cookie_ifCookie_value_name;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_cookie_ifNotCookie_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_cookie_ifCookie_value_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_cookie_ifNotCookie_name.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_cookie_ifCookie_value_name.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Lit Real Estate</title>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- content -->\n");
      out.write("<div class=\"body2\">\n");
      out.write("  <div class=\"main\">\n");
      out.write("    <section id=\"content\">\n");
      out.write("      <div class=\"wrapper\">\n");
      out.write("        \n");
      out.write("          ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("  \n");
      out.write("  \n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("    </section>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"body3\">\n");
      out.write("  <div class=\"main\">\n");
      out.write("    <section id=\"content2\">\n");
      out.write("      <div id=\"map\"></div>\n");
      out.write("    </section>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<!-- / content -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("<style>\n");
      out.write("      html, body {\n");
      out.write("        height: 100%;\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("      }\n");
      out.write("      #map {\n");
      out.write("        height: 100%;\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("      var map;\n");
      out.write("      function initMap() {\n");
      out.write("        map = new google.maps.Map(document.getElementById('map'), {\n");
      out.write("          center: {lat: -34.397, lng: 150.644},\n");
      out.write("          zoom: 8\n");
      out.write("        });\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("    <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBgxk75dsVuxg9dZ_2QsVsWbW1hfR6hWS4 &callback=initMap\"\n");
      out.write("    async defer></script>");
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

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty propertyDetails}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("  \n");
        out.write("        \n");
        out.write("                            \n");
        out.write("                        \n");
        out.write("            \n");
        out.write("        <IMG SRC=\"images/properties/large/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.photo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" ALIGN=\"LEFT\">\n");
        out.write("\n");
        out.write("  \n");
        out.write("         \n");
        out.write("        Description: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" <br><br>\n");
        out.write("            Street: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.street}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            City: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.city}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            Style Type: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${StyleType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            Property Type: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${PropType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            Number of Bedrooms: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.bedrooms}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            Square Feet: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.squarefeet}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            lot Size: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.lotsize}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            Garage Size: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.garagesize}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            Garage Type: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${GarageType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            Agent ID: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.agentId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            Date Added ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.dateAdded}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("            Price € ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("<br>\n");
        out.write("        \n");
        out.write("            \n");
        out.write("           \n");
        out.write("            \n");
        out.write("                    ");
        if (_jspx_meth_cookie_ifCookie_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                    \n");
        out.write("                    \n");
        out.write("                    ");
        if (_jspx_meth_cookie_ifNotCookie_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("              ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_cookie_ifCookie_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  cookie:ifCookie
    com.cj.cookie.IfCookie _jspx_th_cookie_ifCookie_0 = (com.cj.cookie.IfCookie) _jspx_tagPool_cookie_ifCookie_value_name.get(com.cj.cookie.IfCookie.class);
    _jspx_th_cookie_ifCookie_0.setPageContext(_jspx_page_context);
    _jspx_th_cookie_ifCookie_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_cookie_ifCookie_0.setName((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("PropertyID${propertyDetails.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_cookie_ifCookie_0.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_cookie_ifCookie_0 = _jspx_th_cookie_ifCookie_0.doStartTag();
    if (_jspx_eval_cookie_ifCookie_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \n");
        out.write("                    Already Added to wish list\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_cookie_ifCookie_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_cookie_ifCookie_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_cookie_ifCookie_value_name.reuse(_jspx_th_cookie_ifCookie_0);
      return true;
    }
    _jspx_tagPool_cookie_ifCookie_value_name.reuse(_jspx_th_cookie_ifCookie_0);
    return false;
  }

  private boolean _jspx_meth_cookie_ifNotCookie_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  cookie:ifNotCookie
    com.cj.cookie.IfNotCookie _jspx_th_cookie_ifNotCookie_0 = (com.cj.cookie.IfNotCookie) _jspx_tagPool_cookie_ifNotCookie_name.get(com.cj.cookie.IfNotCookie.class);
    _jspx_th_cookie_ifNotCookie_0.setPageContext(_jspx_page_context);
    _jspx_th_cookie_ifNotCookie_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_cookie_ifNotCookie_0.setName((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("PropertyID${propertyDetails.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_cookie_ifNotCookie_0 = _jspx_th_cookie_ifNotCookie_0.doStartTag();
    if (_jspx_eval_cookie_ifNotCookie_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" \n");
        out.write("                    <button class=\"button\" onclick=\"location.href='ManageFavourites?favourites=&propID=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${propertyDetails.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("'\">Favorite</button>\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_cookie_ifNotCookie_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_cookie_ifNotCookie_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_cookie_ifNotCookie_name.reuse(_jspx_th_cookie_ifNotCookie_0);
      return true;
    }
    _jspx_tagPool_cookie_ifNotCookie_name.reuse(_jspx_th_cookie_ifNotCookie_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                   No Property Selected to view\n");
        out.write("                    <br />\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }
}
