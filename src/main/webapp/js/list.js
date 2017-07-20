/**外部js代码中不允许使用EL表达式**/
function selectType(obj){
	//1.获取图书名称输入框的参数
	var bookName = document.getElementById("bookName").value;
	
	var style = obj.value;
	
	var path = document.getElementById("path").value;
	
	window.location=path+"/book/list?bookName="+bookName+"&style="+style;
}

function checkSize(obj){
	//1.获取图书名称输入框的参数
	var bookName = document.getElementById("bookName").value;
	
	var style = document.getElementById("style").value;
	
	var pageSize = obj.value;
	
	var path = document.getElementById("path").value;
	
	window.location=path+"/book/list?bookName="+bookName+"&style="+style+"&pageSize="+pageSize;
}