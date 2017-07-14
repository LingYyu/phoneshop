myShopControllers.controller('myaddressController',function($scope,appDataSv){
  $('#index_header').hide();
  $('#account_header').show();
  $scope.myaddressModel={
      addList:{},
      queryList:{},
      addressSuccess :function(){return $("#success")},
      saveAddList:function(){//保存地址
          console.info($scope.myaddressModel.addList);
          appDataSv.save(global.server.saveAddList,$scope.myaddressModel.addList,function(data){
                if (global.status.success == data.status){
                      $scope.myaddressModel.addressSuccess().modal();
                      $scope.myaddressModel.getaddlist();
                  }
          });
      },
      getaddlist: function(){//查询地址
          appDataSv.query(global.server.queryAddList,{},function(data){
              if (global.status.success == data.status){
                    $scope.myaddressModel.queryList = data.data;
                    console.log(data.data);
                    $("#addressMaterial").attr("src",data.data[0].attr1);
              }else{
                console.log(data);
                  $("#addressMaterial").attr("src",data.data);
              }
          });
      },

      deleteAddress: function(id) { //删除地址
            appDataSv.save(global.server.deleteAddress,{id:id},function(data){
                if(global.status.success==data.status){

                	$scope.myaddressModel.getaddlist();
                }
            });
        },

  };

   $scope.myaddressModel.getaddlist();
});
