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
	    <a class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
	    <a class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>
	    <a class="easyui-linkbutton" iconCls="icon-remove" plain="true">离职</a>
	    <a class="easyui-linkbutton" iconCls="icon-reload" plain="true">刷新</a>
	</div>

</body>
</html>