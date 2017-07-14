myShopControllers.controller('similarController',function($scope,$stateParams,appDataSv){
    $('#index_header').show();
    $('#account_header').hide();
    $scope.similarModel={
        idList:{},
        queryIdList:function(page,size,callback){//相似宝贝
          $scope.similarModel.idList.productid=$stateParams.productid;
          appDataSv.save(global.server.queryIdList,{productid: $scope.similarModel.idList.productid,index:page,size:size},function(data){
              if(global.status.success==data.status){
                  $scope.similarModel.idList=data.data;
                  console.info(data.data);
              }
              callback && callback(data.data[0].totalCount);
          });
        }

    };
//  $scope.similarModel.queryIdList();


});
