/*判断图片格式*/
var isIE = /msie/i.test(navigator.userAgent) && !window.opera;

function fileChange(target, id) {
	var fileSize = 0;
	var filetypes = [".jpg", ".png"];
	var filepath = target.value;
	var filemaxsize = 1024 * 10; //2M   
	if(filepath) {
		var isnext = false;
		var fileend = filepath.substring(filepath.indexOf("."));
		if(filetypes && filetypes.length > 0) {
			for(var i = 0; i < filetypes.length; i++) {
				if(filetypes[i] == fileend) {
					isnext = true;
					break;
				}
			}
		}
		if(!isnext) {
			showcheck("不接受此文件类型!",target.id);
			target.value = "";
			return false;
		}
	} else {
		return false;
	}
	if(isIE && !target.files) {
		var filePath = target.value;
		var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
		if(!fileSystem.FileExists(filePath)) {
			showcheck("附件不存在，请重新输入!",target.id);
			return false;
		}
		var file = fileSystem.GetFile(filePath);
		fileSize = file.Size;
	} else {
		fileSize = target.files[0].size;
	}

	var size = fileSize / 1024;
	if(size > filemaxsize) {
		showcheck("图片的大小不能大于10M!", target.id);
		target.value = "";
		return false;
	}
	if(size <= 0) {
		showcheck("附件大小不能为0M!", target.id);
		target.value = "";
		return false;
	}
}
/*替换提示信息框内容*/
function showcheck(content, id) { 
	$('#matching').html(content);
	$("#matching-btn").attr("onclick", "showFile('" + id + "')"); //然后又通过matching-btn这个button按钮的onclick事件传给了showFile
	//主要是这里,attr可以给input标签的onclick赋值,这里给了一个函数名要注意的就是,括号里要给字符串,所以加了单引号
	//动态给matching-btn这个按钮添加onclick事件
	$("#checkinfomation").modal("show");
}

function showFile(id) { //当你点击matching-btn这个按钮时,那个id就到了这里
	//接着就能打开相应的窗口了
	$("#" + id).click();
}

/*图片拖拽*/
function showBoxa(){
	$("#myModal").modal("show");
	$(".modal-content").draggable({
		cursor: "move"
	});
}



function loginSubmit() {
	var email = $('#email').val();
	var password = $('#password').val();
	$.ajax({
		type: "post",
		url: "http://127.0.0.1:81/web/adminlogin",
		jsonp: "callback", //服务端用于接收callback调用的function名的参数
		jsonpCallback: "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来
		dataType: "jsonp",
		data: {
			"email": email,
			/*后台需要的参数*/
			"password": password,
		},
		success: function(data) {
			if(data == "222") {
        $(".login_error").css("display","none");
				window.location.href = 'index.html'
			}
			else
			{
				$(".login_error").css("display","block");
				// window.location.href = 'login.html'
			}
		},
	});
}
/*
 * 添加商品
 *
*/
function saveSubmit() {
    obj=document.getElementsByName("color");
	color=[];
	for(k in obj){
		if(obj[k].checked)
		color.push(obj[k].value);
	}
  obj1=document.getElementsByName("type");
	type=[];
	for(n in obj1){
		if(obj1[n].checked)
		type.push(obj1[n].value);
	}


	var productname = $('#productname').val();
	var sales=$('#sales').val();

	var price=$('#price').val();
	var name=$('#name').val();
	var qty=$('#qty').val();


	$.ajaxFileUpload({
		url: "http://127.0.0.1:81/web/insertAll",
		secureuri: false,
		fileElementId: ['P1'],
		jsonp: "callback1", //服务端用于接收callback调用的function名的参数
		jsonpCallback: "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来
		dataType: "jsonp",
		data: {

			"productname": productname,
			"name":name,
			/*后台需要的参数*/
			"sales": sales,
			"price":price,
			"qty":qty,
			"color":color,
			"type":type
		},
		success: function(data) {
			// if(data == "1") {
      //
			// 	alert("成功");
			// }
			// else
			// {
			// 	alert("添加失败");
      //
			// }
      $("#success").modal("toggle");
      $("#product_add").modal("hide");
		},
	});




}
