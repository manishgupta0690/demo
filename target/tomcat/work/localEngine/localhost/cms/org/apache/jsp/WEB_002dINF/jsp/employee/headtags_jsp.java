package org.apache.jsp.WEB_002dINF.jsp.employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class headtags_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <!-- Meta, title, CSS, favicons, etc. -->\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("    <title>CMS</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <link href=\"/static/vendors/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Font Awesome -->\r\n");
      out.write("    <link href=\"/static/vendors/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- NProgress -->\r\n");
      out.write("    <link href=\"/static/vendors/nprogress/nprogress.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- iCheck -->\r\n");
      out.write("    <link href=\"/static/vendors/iCheck/skins/flat/green.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- bootstrap-progressbar -->\r\n");
      out.write("    <link href=\"/static/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Animate.css -->\r\n");
      out.write("    <link href=\"../vendors/animate.css/animate.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- JQVMap -->\r\n");
      out.write("    <link href=\"/static/vendors/jqvmap/dist/jqvmap.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("    <!-- bootstrap-daterangepicker -->\r\n");
      out.write("    <link href=\"/static/vendors/bootstrap-daterangepicker/daterangepicker.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom Theme Style -->\r\n");
      out.write("    <link href=\"/static/build/css/custom.min.css\" rel=\"stylesheet\">");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
