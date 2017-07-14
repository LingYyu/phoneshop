myShopControllers.controller('categoryController',function($scope,$stateParams,appDataSv){
    $('#index_header').show();
    $('#account_header').hide();
    $scope.categoryModel={
        list:{
            productname:'',
        },//分类产品
        queryList:function(page,size,callback){//查询产品
            $scope.categoryModel.list.productname=$stateParams.productname;
            appDataSv.save(global.server.queryProduct,{productname: $scope.categoryModel.list.productname,index:page,size:size},function(data){
                if(global.status.success==data.status){
                    $scope.categoryModel.list=data.data;
                    console.info(data.data);
                }
                callback && callback(data.data[0].totalCount);
            });

        },

    };
    // $scope.categoryModel.queryList();
});
