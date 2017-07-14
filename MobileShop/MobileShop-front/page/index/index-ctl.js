myShopControllers.controller('indexController', function($scope,$state,appDataSv) {
  $("#account_header").hide();
  $("#index_header").show();
    $scope.indexModel = {
      sales:{
      },//特价商品
      querySales:function(page,size,callback){//查询特价商品
        appDataSv.query(global.server.queryOnsales,{index:page,size:size},function(data){
            if(global.status.success == data.status){
              $scope.indexModel.sales=data.data;
              console.info(data.data);
              }
                callback && callback(data.data[0].totalCount);
        });
      },
      leading:{
      },//主打商品
      queryLeading:function (page,size,callback) {
        appDataSv.query(global.server.queryLeading,{index:page,size:size},function(data){
            if(global.status.success == data.status){
                $scope.indexModel.leading=data.data;
                console.log(data.data);
            }
              callback && callback(data.data[0].totalCount);
        });
      },

    };
});
