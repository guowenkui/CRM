$(function() {
	//把需要的变量缓存起来
	var role_datagrid,roleDatagridEditBtn,roleDialog,roleDialogForm,roleSearchForm,selfPermission,allPermission;
	
	role_datagrid = $("#role_datagrid");
	roleDatagridEditBtn = $("#role_datagrid_bt a");
	roleDialog = $("#role_dialog");
	roleDialogForm = $("#role_dialog_form");
	roleSearchForm = $("#role_searchForm");
	selfPermission = $("#selfPermission");
	allPermission = $("#allPermission");
	
	role_datagrid.datagrid({
		url:"/role_list",
		fit:true,
		pagination:true,
		rownumbers:true,
		singleSelect:true,
		columns:[[
		          {title:"角色编号",field:"sn",width:1},
		          {title:"角色名称",field:"name",width:1},
		          ]],
		fitColumns:true,
		toolbar:'#role_datagrid_bt',
	});
	
	roleDialog.dialog({
		title: 'My Dialog',    
	    width: 550,    
	    height: 350,    
	    buttons:'#role_dialog_bb',
	    closed:true,
	});
	
	selfPermission.datagrid({
		title:"自身权限",
		width:250,
		height: 200,
		rownumbers:true,
		columns:[[
		          {title:"权限名称",field:"name",width:1,align:"center"},
		          ]],
		fitColumns:true,
		singleSelect:true,
		onDblClickRow:function(rowIndex,rowData){
			selfPermission.datagrid("deleteRow",rowIndex);
		}
	});
    allPermission.datagrid({
    	url:"/permission_list",
    	title:"所有权限",
		width:250,
		height: 200,
		pagination: true,
		rownumbers:true,
		columns:[[
		          {title:"权限名称",field:"name",width:1,align:"center"},
		          ]],
		fitColumns:true,
		singleSelect:true,
		onDblClickRow:function(rowIndex,rowData){
			
			//判断
			//获取selfPermission权限集合,一个个判断
			//如果出现相同的id,选中,否则新增
			var selfRows = selfPermission.datagrid("getRows");
			var flag = false;
			var index = -1;
			for (var i = 0; i < selfRows.length; i++) {
				if(selfRows[i].id == rowData.id){
					flag = true;
					index = i;
					break;
				}
			}
			
			if (flag) {
				//选中
				selfPermission.datagrid("selectRow",index);
			} else {
				selfPermission.datagrid("appendRow",rowData);
			}
		}
	});
    
    var pager = allPermission.datagrid("getPager");
    pager.pagination({
    	showPageList:false,
    	showRefresh:false,
    	displayMsg:''
    });
	
	//统一管理方法
	var cmdObj = {
			add:function() {
				//调用打开方法
				roleDialog.dialog("open");
				roleDialog.dialog("setTitle","新增");
//				roleDialogForm.form("clear");
				$("[name='id'],[name='name'],[name='sn']").val("");
				selfPermission.datagrid("loadData",{rows:[]});
			},
			edit: function () {
				//用户是否有选择记录
				var rowData = role_datagrid.datagrid("getSelected");
				if (rowData) {
					//调用打开方法
					roleDialog.dialog("open");
					roleDialog.dialog("setTitle","编辑");
					roleDialogForm.form("clear");
					
					if (rowData.dept) {
						rowData["dept.id"] = rowData.dept.id;
					}
					//回显数据
					roleDialogForm.form("load",rowData);
					
					//权限的回显
					//给selfPermission添加URL
					selfPermission.datagrid("options").url = "/permission_queryByRid";
					selfPermission.datagrid("load",{
						rid:rowData.id,
					});
						
				} else {
					$.messager.alert("温馨提示","请选择一条需要编辑的数据","warning");
				}
			},
			del: function () {
				//用户是否有选择记录
				var rowData = role_datagrid.datagrid("getSelected");
				if (rowData) {
					//询问用户确定需要离职员工
					$.messager.confirm("温馨提示","你确定需要离职该员工吗",function(yes){
						if(yes){
							$.get("/role_delete?id="+rowData.id,function(data){
								if (data.success) {
									$.messager.alert("温馨提示", data.msg, "info", function() {
										//刷新数据
										role_datagrid.datagrid("load");
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
					url = "/role_update";
				} else {
					//新增
					url = "/role_save";
				}
				
				roleDialogForm.form("submit",{
					url:url,
					onSubmit: function(param){    
				        //获取自身权限集合
						var selfRows = selfPermission.datagrid("getRows");
						for (var i = 0; i < selfRows.length; i++) {
							param["permissions["+i+"].id"] = selfRows[i].id;
						}
				    },   
					success:function (data){
						data = $.parseJSON(data);
						if (data.success) {
							$.messager.alert("温馨提示",data.msg,"info",function(){
								//关闭对话框
								roleDialog.dialog("close");
								//刷新数据
								role_datagrid.datagrid("load");
							});
						} else {
							$.messager.alert("温馨提示",data.msg,"warning");
						}
					}
				});
			},
			searchContent: function () {
				var param ={};
				var paramArr = roleSearchForm.serializeArray();
				for (var i = 0; i < paramArr.length; i++) {
					param[paramArr[i].name] = paramArr[i].value;
				}
				
				role_datagrid.datagrid("load",param);
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

