myShopControllers.controller('allphoneController', function($scope,appDataSv) {
  $("#account_header").hide();
  $("#index_header").show();
  $scope.allphoneModel = {
    list:{},
    queryAllPhone:function(page,size,callback){//查询所有手机
      appDataSv.save(global.server.search,{name:$scope.allphoneModel.list.name,index:page,size:size},function(data){
        if (global.status.success == data.status) {
          $scope.allphoneModel.list=data.data;
        }
        callback && callback(data.data[0].totalCount);
      });
    }
  };
  // $scope.allphoneModel.queryAllPhone();
});
