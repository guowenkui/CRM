$(function() {
	//把需要的变量缓存起来
	var employ_datagrid,employeeDatagridEditBtn,employeeDialog,employeeDialogForm,employeeSearchForm;
	
	employ_datagrid = $("#employ_datagrid");
	employeeDatagridEditBtn = $("#employee_datagrid_bt a");
	employeeDialog = $("#employee_dialog");
	employeeDialogForm = $("#employee_dialog_form");
	employeeSearchForm = $("#employee_searchForm");
	
	
	employ_datagrid.datagrid({
		url:"/employee_list",
		fit:true,
		pagination:true,
		rownumbers:true,
		singleSelect:true,
		columns:[[
		          {title:"账号",field:"username",width:1},
		          {title:"真实姓名",field:"realname",width:1},
		          {title:"联系方式",field:"tel",width:1},
		          {title:"邮箱",field:"email",width:1},
		          {title:"部门",field:"dept",width:1,formatter:deptFormatter},
		          {title:"入职时间",field:"inputTime",width:1},
		          {title:"状态",field:"state",width:1,formatter:statusFormatter},
		          ]],
		fitColumns:true,
		toolbar:'#employee_datagrid_bt',
		onClickRow: function (rowIndex, rowData) {
			if (rowData.state) {
				employeeDatagridEditBtn.eq(1).linkbutton("enable");
				employeeDatagridEditBtn.eq(2).linkbutton("enable");
			} else {
				//让按钮变灰
				employeeDatagridEditBtn.eq(1).linkbutton("disable");
				employeeDatagridEditBtn.eq(2).linkbutton("disable");
			}
		}
	});
	
	employeeDialog.dialog({
		title: 'My Dialog',    
	    width: 250,    
	    height: 250,    
	    buttons:'#employee_dialog_bb',
	    closed:true,
	});
	
	//统一管理方法
	var cmdObj = {
			add:function() {
				//调用打开方法
				employeeDialog.dialog("open");
				employeeDialog.dialog("setTitle","新增");
				employeeDialogForm.form("clear");
			},
			edit: function () {
				//用户是否有选择记录
				var rowData = employ_datagrid.datagrid("getSelected");
				if (rowData) {
					//调用打开方法
					employeeDialog.dialog("open");
					employeeDialog.dialog("setTitle","编辑");
					employeeDialogForm.form("clear");
					
					if (rowData.dept) {
						rowData["dept.id"] = rowData.dept.id;
					}
					//回显数据
					employeeDialogForm.form("load",rowData);
				} else {
					$.messager.alert("温馨提示","请选择一条需要编辑的数据","warning");
				}
			},
			del: function () {
				//用户是否有选择记录
				var rowData = employ_datagrid.datagrid("getSelected");
				if (rowData) {
					//询问用户确定需要离职员工
					$.messager.confirm("温馨提示","你确定需要离职该员工吗",function(yes){
						if(yes){
							$.get("/employee_delete?id="+rowData.id,function(data){
								if (data.success) {
									$.messager.alert("温馨提示", data.msg, "info", function() {
										//刷新数据
										employ_datagrid.datagrid("load");
									});
								} else {

									$.messager.alert("温馨提示", data.msg, "warning");
								}
							},"json");
						}
					});
				} else {
					$.messager.alert("温馨提示","请选择一条需要离职的员工","warning");
				}
			},
			
			refresh:function () {
				
			},

			save:function () {
				
				var url;
				//判断到底是新增还是编辑--->通过id来判断
				var id = $("input[name='id']").val();
				if (id) {
					//编辑
					url = "/employee_update";
				} else {
					//新增
					url = "/employee_save";
				}
				
				employeeDialogForm.form("submit",{
					url:url,
					success:function (data){
						data = $.parseJSON(data);
						if (data.success) {
							$.messager.alert("温馨提示",data.msg,"info",function(){
								//关闭对话框
								employeeDialog.dialog("close");
								//刷新数据
								employ_datagrid.datagrid("load");
							});
						} else {
							$.messager.alert("温馨提示",data.msg,"warning");
						}
					}
				});
			},
			searchContent: function () {
				var param ={};
				var paramArr = employeeSearchForm.serializeArray();
				for (var i = 0; i < paramArr.length; i++) {
					param[paramArr[i].name] = paramArr[i].value;
				}
				
				employ_datagrid.datagrid("load",param);
			},
			cancel: function () {
				
			}

	}
	
	//给按钮添加事件
	$("a[data-cmd]").on("click",function(){
		var cmd = $(this).data("cmd");
		console.log(cmd);
		
		if (cmd) {
			cmdObj[cmd]();
		}
	});
});









//value是当前字段的值，record是该行的所有数据，index是该行的索引
function deptFormatter(value,record,index) {
	if (value) {
		return value.name;
	} else {
		return value;
	}
}

function statusFormatter(value,record,index) {
	if (value) {
		return "<font color='green'>在职</font>";
	} else {
		return "<font color='red'>离职</font>";
	}
}

