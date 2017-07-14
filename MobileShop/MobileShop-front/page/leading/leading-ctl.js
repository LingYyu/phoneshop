myShopControllers.controller('leadingController',function($scope,$stateParams,appDataSv){
    $('#index_header').show();
    $('#account_header').hide();
    $scope.leadingModel={
      leading:{
      },//主打商品
      queryLeading:function (page,size,callback) {
        appDataSv.query(global.server.queryLeading,{index:page,size:size},function(data){
            if(global.status.success == data.status){
                $scope.leadingModel.leading=data.data;
                console.log(data.data);
            }
              callback && callback(data.data[0].totalCount);
        });
      },
    };
});
