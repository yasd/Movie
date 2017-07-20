
var yname =   document.getElementById("regpath").value;
var uname =   document.getElementById("rname");
var upwd1 =document.getElementById("rpassword");
var upwd2 =document.getElementById("rcheck");
var uemail =   document.getElementById("remail");
var uphone =   document.getElementById("rphone");
var ucompany = document.getElementById("rcompany");
var uaddress = document.getElementById("raddress");
var errinput = document.getElementById("errinput");


/*以下用来注册验证*/
//alert("应用名："+path.value)

//1.获取需要验证的文本框.
var username = uname;

//2.获取密码验证的输入框
var pwd = upwd1;

var flag1 = false;

function doRegister(param){
	//定义一个布尔类型的变量
	var flag = true;
	//验证username
	
	//username....
	username.onblur=function(){
		//alert("进入验证用户名");
		//获取文本输入框中的值
		var value = uname.value;

		//获取span对象
		var sp = document.getElementById("errname");
		
		//创建正则表达式对象
		var reg = /^[a-z][a-zA-Z0-9]{5,7}$/;
		
		//alert(value);
		if(!reg.test(value)){
			sp.innerHTML = "*用户名以小写字母开头,长度在6-8";
			sp.className="error";
			flag1 = false;
			return;
		}
		
		//1.//1.创建XMLHttpRequest对象
		var xmlHttp = new XMLHttpRequest();
		
		//2.注册一个回调函数
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				if (xmlHttp.status == 200) {
					//获取后台返回的信号量.
					var str = xmlHttp.responseText;
					
					//进行判断
					if (str != "0") {
						flag1 = true;
						sp.className="success";
						sp.innerText="√";
					}else{
						flag1 = false;
						sp.className="error";
						sp.innerText="×用户名已经存在了!";
					}
				}
			}
		}

		//3.设置请求参数
		//xmlHttp.open("get", "${path}/user/checkUser?username=" + value,
				//true);
		//alert("path："+path);
		//演示post请求,需要设置header头信息
		xmlHttp.open("post", path+"/user/checkUserName",true);
		
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 

		//4.发送请求
		xmlHttp.send("username="+value);
	}
	//username end...
	
	if(param=='p'){
		username.onblur();
	}
	
	//验证密码
	checkData(pwd,"*密码长度在6-8",function(val){
		//定义一个密码的正则表达式对象
		var reg = /^[0-9]{6,8}$/;
		
		if(reg.test(val)){
			return true;
		}else{
			flag = false;
			return false;
		}
	},param);
	
	//验证确认密码
	checkData(upwd2,"两次输入密码不一致",function(val){
		if(upwd1.value==upwd2.value){
			return true;
		}else{
			flag = false;
			return false;
		}
	},param);
	
	//验证邮箱
	checkData(uemail,"邮箱地址不合法",function(val){
		var reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if(reg.test(val)){
			return true;
		}else{
			flag = false;
			return false;
		}
	},param);
	
	//验证手机号
	checkData(uphone,"手机号不合法",function(val){
		var reg = /^[1][0-9]{10}$/;
		if(reg.test(val)){
			return true;
		}else{
			flag = false;
			return false;
		}
	},param);
	
	//alert("flag1="+flag1);
	return flag&&flag1;
}

//定义一个函数,用来检测数据
//obj代表各个需要验证的输入框
//info代表span错误时需要显示的内容.
//fun - 闭包函数
function checkData(obj,info,fun,param){
	var span = obj.parentNode.nextElementSibling.children[0];
	//各个文本输入框添加onfocus事件
	obj.onfocus = function(){
		span.className="focuss";
	}
	//添加需要验证的文本输入框的onblur事件
	obj.onblur = function(){//为了修改span样式
		//先获取文本输入框中的内容
		var text = this.value;
		//每个验证的regex是不一样的.
		if(!fun(text)){
			//不成功..
			span.innerHTML = info;
			span.className="error";
			errinput.className="errinput";
		}else{
			//成功...
			span.innerHTML="√";
			span.className="success";
			errinput.className="sucinput";
		}
	}
	//判断doRegister是否为按钮触发的
	if(param=='p'){
		obj.onblur();
	}
}

document.onkeydown = function(event){
	var e = window.event||event;
	if(e.keyCode==13){
		var btn = document.getElementById("btn");
		//alert(btn);
		btn.click();
	}
}
