myShopControllers.controller('salesController',function($scope,$stateParams,appDataSv){
    $('#index_header').show();
    $('#account_header').hide();
    $scope.salesModel={
      sales:{
      },//特价商品
      querySales:function(page,size,callback){//查询特价商品
        appDataSv.query(global.server.queryOnsales,{index:page,size:size},function(data){
            if(global.status.success == data.status){
              $scope.salesModel.sales=data.data;
              console.info(data.data);
              }
                callback && callback(data.data[0].totalCount);
        });
      },

    };
});
