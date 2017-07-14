function pay() {

    obj=document.getElementsByName("payList");
	payList=[];
	for(k in obj){
		if(obj[k].checked)
		payList.push(obj[k].value);
	}
	alert(payList);
	
	
	$.ajaxFileUpload({
		url: "http://127.0.0.1:81/web/paylist",
		fileElementId: ['P1'],
		jsonp: "callback1", //服务端用于接收callback调用的function名的参数 
		jsonpCallback: "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来
		dataType: "jsonp",
		data: {

			
			"payList": payList
		},
		success: function(data) {
			
			alert("666");
			// window.location.href='content.pay';
		},
	});
	
}
