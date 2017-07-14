myShopControllers.controller('searchController', function($scope,$stateParams,appDataSv) {
  $("#account_header").hide();
  $("#index_header").show();
  $scope.searchModel={
    searchList:{
      name:''
    },
    search:function(page,size,callback){
      $scope.searchModel.searchList.name=$stateParams.name;
      appDataSv.save(global.server.search,{name:$scope.searchModel.searchList.name,index:page,size:size},function(data){
        if (global.status.success == data.status) {
          $scope.searchModel.searchList=data.data;
            console.info(data.data);
        }
        callback && callback(data.data[0].totalCount);
      });
    }
  };
//$scope.searchModel.search();
});
