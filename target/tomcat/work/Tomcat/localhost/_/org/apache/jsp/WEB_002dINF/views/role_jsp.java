/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-16 00:07:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class role_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common.jsp", Long.valueOf(1536994298493L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>角色管理</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/jquery-easyui/themes/default/easyui.css\"><!-- æ ·å¼æä»¶ -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/jquery-easyui/themes/icon.css\"> <!--å¾æ æ ·å¼  -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-easyui/jquery.min.js\"></script> <!-- jQueryæ ¸å¿åº -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-easyui/jquery.easyui.min.js\"></script>  <!-- EasyUIæ ¸å¿åº -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-easyui/base.js\"></script>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/views/role.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table id=\"role_datagrid\"></table>\r\n");
      out.write("\t<!-- 定义数据表格按钮 -->\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"role_datagrid_bt\">\r\n");
      out.write("\t     <div>\r\n");
      out.write("\t          <a class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" data-cmd=\"add\">新增</a>\r\n");
      out.write("\t          <a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" data-cmd=\"edit\">编辑</a>\r\n");
      out.write("\t          <a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" data-cmd=\"del\">离职</a>\r\n");
      out.write("\t          <a class=\"easyui-linkbutton\" iconCls=\"icon-reload\" plain=\"true\" data-cmd=\"refresh\">刷新</a>\r\n");
      out.write("\t     </div>\r\n");
      out.write("\t     <div>\r\n");
      out.write("\t          <form id=\"role_searchForm\" action=\"\">\r\n");
      out.write("\t                                   关键字:<input type=\"text\" name=\"keyword\">\r\n");
      out.write("\t                                   日期:<input class=\"easyui-datebox\" name=\"beginDate\">\r\n");
      out.write("\t              -\r\n");
      out.write("\t              <input class=\"easyui-datebox\" name=\"endDate\">\r\n");
      out.write("\t                                   状态:\r\n");
      out.write("\t              <select name = \"state\">\r\n");
      out.write("\t                 <option value=\"\">全部</option>\r\n");
      out.write("\t                 <option value=\"1\">正常</option>\r\n");
      out.write("\t                 <option value=\"0\">离职</option>\r\n");
      out.write("\t                 </select>\r\n");
      out.write("\t              <a class=\"easyui-linkbutton\" iconCls=\"icon-search\" data-cmd=\"searchContent\">搜索</a>\r\n");
      out.write("\t          </form>                       \r\n");
      out.write("\t     </div>   \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 定义对话框 -->\r\n");
      out.write("\t<div id=\"role_dialog\">\r\n");
      out.write("\t   <form id=\"role_dialog_form\" action=\"\" method=\"post\">\r\n");
      out.write("\t      <table align=\"center\" style=\"margin-top: 15px\">\r\n");
      out.write("\t          <input type=\"hidden\" name=\"id\">\r\n");
      out.write("\t          <tr> \r\n");
      out.write("\t               <td>角色编号:<input type=\"text\" name=\"username\"></td>\r\n");
      out.write("\t               <td>角色名称:<input type=\"text\" name=\"username\"></td>\r\n");
      out.write("\t          </tr>\r\n");
      out.write("\t          <tr> \r\n");
      out.write("\t               <td><table id=\"selfPermission\" ></table></td>\r\n");
      out.write("\t               <td><table id=\"allPermission\"></table></td>\r\n");
      out.write("\t          </tr>\r\n");
      out.write("\t      </table>\r\n");
      out.write("\t    </form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 定义对话框底部按钮 -->\r\n");
      out.write("\t<div id=\"role_dialog_bb\">\r\n");
      out.write("\t    <a class=\"easyui-linkbutton\" iconCls=\"icon-save\" plain=\"true\" data-cmd=\"save\">保存</a>\r\n");
      out.write("\t    <a class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" plain=\"true\"  data-cmd=\"cancel\">取消</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}