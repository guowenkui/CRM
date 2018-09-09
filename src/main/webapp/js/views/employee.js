$(function() {
	$("#employ_datagrid").datagrid({
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
		          {title:"状态",field:"state",width:1},
		          ]],
		fitColumns:true,
		toolbar:'#employee_datagrid_bt',
	});
	
	$("#employee_dialog").dialog({
		title: 'My Dialog',    
	    width: 250,    
	    height: 250,    
	    buttons:'#employee_dialog_bb',
	    closed:true,
	});
});


function add() {
	//调用打开方法
	$("#employee_dialog").dialog("open");
	$("#employee_dialog").dialog("setTitle","新增");
	$("#employee_dialog_form").form("clear");
}

function edit() {
	
}
function del() {
	
}
function refresh() {
	
}

function save() {
	$("#employee_dialog_form").form("submit",{
		url:"/employee_save",
		success:function (data){
			data = $.parseJSON(data);
			if (data.success) {
				$.messager.alert("温馨提示",data.msg,"info",function(){
					//关闭对话框
					$("#employee_dialog").dialog("close");
					//刷新数据
					$("#employ_datagrid").datagrid("load");
				});
			} else {
				$.messager.alert("温馨提示",data.msg,"warning");
			}
		}
	});
}
function cancel() {
	
}


function deptFormatter(value,record,index) {
	if (value) {
		return value.name;
	} else {
		return value;
	}
}