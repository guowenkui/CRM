<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
<%@include file="common.jsp"%>
<script type="text/javascript" src="/js/views/employee.js"></script>
</head>
<body>
	<table id="employ_datagrid"></table>
	<!-- 定义数据表格按钮 -->
	
	<div id="employee_datagrid_bt">
	     <div>
	          <a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">新增</a>
	          <a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="edit">编辑</a>
	          <a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="del">离职</a>
	          <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a>
	     </div>
	     <div>
	          <form id="employee_searchForm" action="">
	                                   关键字:<input type="text" name="keyword">
	                                   日期:<input class="easyui-datebox" name="beginDate">
	              -
	              <input class="easyui-datebox" name="endDate">
	                                   状态:
	              <select name = "state">
	                 <option value="">全部</option>
	                 <option value="1">正常</option>
	                 <option value="0">离职</option>
	                 </select>
	              <a class="easyui-linkbutton" iconCls="icon-search" data-cmd="searchContent">搜索</a>
	          </form>                       
	     </div>   
	</div>
	
	<!-- 定义对话框 -->
	<div id="employee_dialog">
	   <form id="employee_dialog_form" action="" method="post">
	      <table align="center" style="margin-top: 15px">
	          <input type="hidden" name="id">
	          <tr> 
	               <td>账号</td>
	               <td><input type="text" name="username"></td>
	          </tr>
	          <tr> 
	               <td>真实姓名</td>
	               <td><input type="text" name="realname"></td>
	          </tr>
	          <tr> 
	               <td>邮箱</td>
	               <td><input type="text" name="email"></td>
	          </tr>
	          <tr> 
	               <td>电话</td>
	               <td><input type="text" name="tel"></td>
	          </tr>
	          <tr> 
	               <td>部门</td>
	               <td><input class="easyui-combobox" name="dept.id"   
    data-options="valueField:'id',textField:'name',url:'/department_queryForEmp'"></td>
	          </tr>
	      </table>
	    </form>
	</div>
	
	<!-- 定义对话框底部按钮 -->
	<div id="employee_dialog_bb">
	    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" data-cmd="save">保存</a>
	    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true"  data-cmd="cancel">取消</a>
	</div>

</body>
</html>