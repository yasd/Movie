
var yname =   document.getElementById("yname");
var rname =   document.getElementById("rname");
var password =document.getElementById("password");
var checkpwd =document.getElementById("checkpwd");
var email =   document.getElementById("email");
var phone =   document.getElementById("phone");
var company = document.getElementById("company");
var address = document.getElementById("address");


rname.onblur=function(obj){
	alert(u.password+"++++++++++++++++++");
	var errname= document.getElementById("errname").value;
	name= obj.value;
	var reg=/^[a-z][a-zA-Z0-9]$/;
	if(!reg.test(name)){
		errname.className="e1";
		errname.innerText="用户名已存在";
	}else{
		errname.className="e2";
		errname.innerText="用户名可用";
	}
}


