myShopControllers.controller('mynewsController',function($scope,appDataSv){
  $('#index_header').hide();
  $('#account_header').show();
  $scope.mynewsModel={
        mynewsList:{

        },
        mynewsSuccess :function(){return $("#success")},
        saveList:function(){//更新个人资料
          var nick=$("#nick").val();
  				var truename=$("#truename").val();
  				var birthday=$("#date1").val();
  				var password=$("#password").val();
  				var repassword=$("#repassword").val();
          var email=sessionStorage.getItem("loginsuccess");
  					$.ajaxFileUpload({
  					url: "http://127.0.0.1:7070/web/updateTuser1",
  					secureuri: false,
  					fileElementId: ['P1'],
  					dataType: "jsonp",
  					jsonp: "callback",
  					jsonpCallback: "success_jsonpCallback",
  					data: {
  					"nick": nick,
  					"truename": truename,
  					"birthday": birthday,
  	        "password": password,
            "email" : email,
  					},
  					success: function(data) {
  							$scope.mynewsModel.mynewsSuccess().modal();
  					},error: function(data) {
  					}
  				});
        },
        queryList:{
          sex:'',
        },
        queryNewsList:function(){//查询个人资料
          appDataSv.query(global.server.queryNewsList,$scope.mynewsModel.queryList,function(data){
              if(global.status.success==data.status){
              	$("#addressMaterial").attr("src",data.data[0].picture);
                $("#news_nick input").val(data.data[0].nick);
                $("#news_truename input").val(data.data[0].truename);
                $("#news_birthday input").val(data.data[0].birthday);
                // $("input[name='sex'][value=data.data[0].sex]").attr("checked",true);
              }
          });
        },
  };
  $('#date1').fdatepicker();
  $scope.mynewsModel.queryNewsList();
  $(function() {
      $("input[type='file']").on("change", function() {
          var objUrl = getObjectURL(this.files[0]); //获取图片的路径，该路径不是图片在本地的路径
          if (objUrl) {
              $(this).siblings("img").attr("src", objUrl); //将图片路径存入src中，显示出图片
          }
      });
      $(".mg-rounded-disc").on("click", function() {
          $(this).siblings("input[type='file']").click();
      });
  });
  function getObjectURL(file) {
      var url = null;
      if (window.createObjectURL != undefined) { // basic
          url = window.createObjectURL(file);
      } else if (window.URL != undefined) { // mozilla(firefox)
          url = window.URL.createObjectURL(file);
      } else if (window.webkitURL != undefined) { // webkit or chrome
          url = window.webkitURL.createObjectURL(file);
      }
      return url;
  }

});
