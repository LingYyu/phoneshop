myShopControllers.controller('myorderController',function($scope,$state,appDataSv){
  $("#account_header").show();
  $("#index_header").hide();
  $scope.myorderModel = {
      loginFirst:function(){return $("#login_first")},//先登录提示框
      orderList:{},
      selectAllOrder:function(){//未支付订单
        appDataSv.query(global.server.selectAllOrder,{},function(data){
            if(global.status.success==data.status){
              $scope.myorderModel.orderList=data.data;
              console.info($scope.myorderModel.orderList);
            }else{
                $scope.myorderModel.loginFirst().modal();
            }
        });
      },
      orderRemind:function(){return $("#order_remind")},//提醒发货
      change:function(content){$(".modal_body").html(content);},//修改弹框内容
      orderCheck:function(orderid,status){
        if(status=="等待发货"){
          $scope.myorderModel.orderRemind().modal();
          $("#tixing").css("display","block");
          $("#shouhuo").css("display","none");
        }else if(status=="未支付"){
          appDataSv.save(global.server.payContinue,{orderid:orderid},function(data){
              if(global.status.success==data.status){
                $state.go("content.pay",{},{reload:true});
                console.info(data.data);
              }
          });
        }else if(status=="查看物流"){
          appDataSv.save(global.server.checkSuccess,{orderid:orderid},function(data){
            if(global.status.success==data.status){
              $scope.myorderModel.change("交易成功");
              $("#tixing").css("display","none");
              $("#shouhuo").css("display","block");
              $scope.myorderModel.orderRemind().modal();
            }
          });
        }
      },
      restart:function(){
        window.location.reload();
      }
  };
  $scope.myorderModel.selectAllOrder();
});
