myShopBackControllers.controller('productController', function($scope, appDataSv) {
    $scope.productModel = {
      productAddModal: function(){
        return $("#product_add");
      },
      productAddOpenModal: function(){//打开新增用户窗口
          $scope.productModel.productAddModal().modal();
      },
      productDel:function(){return $("#product_del")},//下架弹框
      onsales:{},//在售商品
      queryOnsales:function(){
        appDataSv.query(global.server.selectOnsales,{},function(data){
          if(global.status.success==data.status){
            $scope.productModel.onsales=data.data;
            console.info(data.data);
          }
        });
      },
      unsales:{},//待售商品
      queryUnsales:function(){
        appDataSv.query(global.server.selectUnsales,{},function(data){
          if(global.status.success==data.status){
            $scope.productModel.unsales=data.data;
            console.info(data.data);
          }
        });
      },
      down:function(id){//下架
        appDataSv.save(global.server.down,{id:id},function(data){
          if(global.status.success==data.status){
              $scope.productModel.productDel().modal();
          }
        });
      },
      change:function(content){$(".mymodal_content").html(content);},//修改弹框内容
      up:function(id){//上架
        appDataSv.save(global.server.up,{id:id},function(data){
          if(global.status.success==data.status){
              $scope.productModel.change("上架成功");
              $scope.productModel.productDel().modal();
          }
        });
      },
      downreload:function(){
        window.location.reload();
      },
      showOnsale:function(){
        $('#onsales').css("display","block");
        $('#unsales').css("display","none");
        $('.sale').css("background","#000");
        $('.unsale').css("background","#cfcfcf");
      },
      showUnsale:function(){
        $('#onsales').css("display","none");
        $('#unsales').css("display","block");
        $('.sale').css("background","#cfcfcf");
        $('.unsale').css("background","#000");
      }

    };
    $scope.productModel.queryOnsales();
    $scope.productModel.queryUnsales();
});
