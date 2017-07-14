myShopControllers.controller('payController',function($scope,$state,appDataSv){
  $("#account_header").hide();
  $("#index_header").show();

  $scope.payModel={
      address:{},
      queryAddress:function(){//查询收货地址
        appDataSv.query(global.server.queryAddList,{},function(data){
            if (global.status.success == data.status){
                // console.log(data);
                  $scope.payModel.address = data.data;
            }else{
              // console.log("error");
            }
        });
      },
      clickAddress:{
        address:'',
        city:'',
        name:'',
        phone:'',
      },//确认的收货地址
      checkAddress:function(address,city,name,phone){
        $scope.payModel.clickAddress.address=address;
        $scope.payModel.clickAddress.city=city;
        $scope.payModel.clickAddress.name=name;
        $scope.payModel.clickAddress.phone=phone;
        console.info($scope.payModel.clickAddress);
      },
      orderList:{},
      queryOrder:function(){//查询订单
        appDataSv.query(global.server.pay,$scope.payModel.orderList,function(data){
            if(global.status.success == data.status){
              $scope.payModel.orderList=data.data;
              console.info(data.data);
            }
        });
      },
      getSum:function(){//实付款
        var totalPrice=0;
        for(var i in $scope.payModel.orderList){
            totalPrice+=$scope.payModel.orderList[i].price* $scope.payModel.orderList[i].num;
        }
        return totalPrice;
      },
      paysuccess:function(){return $("#pay_success")},//订单提交成功
      addremind:function(){return $("#add_remind")},//提示选择收货地址
      updateOrder:function(){//提交订单
        appDataSv.save(global.server.updateOrder,{address:$scope.payModel.clickAddress.address,city:$scope.payModel.clickAddress.city},function(data){
          if(global.status.success == data.status){
              $scope.payModel.paysuccess().modal();
          }else{
            $scope.payModel.addremind().modal();
          }
        });
      },
      reload:function(){//跳转订单页
        $state.go("content.myorder",{},{reload:true});
        $('body').removeClass("modal-open");
      },
      addList:{},
      saveAddList:function(){//保存地址
          appDataSv.save(global.server.saveAddList,$scope.payModel.addList,function(data){
                if (global.status.success == data.status){
                      window.location.reload();
                  }
          });
      },
      newAddress:function(){return $("#new_address")},//添加新地址
      showNewAddress:function(){$scope.payModel.newAddress().modal();},

  };
  $scope.payModel.queryAddress();
  $scope.payModel.queryOrder();
  $('.pay_address').on('click','div',function(e) {
      if ($(this).hasClass('check_pay_address_hover')) {
          $(this).removeClass('check_pay_address_hover');

      } else {
          $(this).addClass('check_pay_address_hover').siblings().removeClass('check_pay_address_hover');
      }
  });
});
