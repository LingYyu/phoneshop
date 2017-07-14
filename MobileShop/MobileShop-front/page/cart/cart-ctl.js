myShopControllers.controller('cartController', function($scope,$state, $stateParams, appDataSv) {
    $("#account_header").hide();
    $("#index_header").show();
    $scope.cartModel = {
        cartList: {
            id :'',
        },
           add: function(index,id) { //增加
           	$scope.cartModel.cartList[index].num++;
           	var qty= $scope.cartModel.cartList[index].num;
        	 appDataSv.save(global.server.updateNum,{id:id,qty:parseInt(qty)},function(data){
                if(global.status.success==data.status){
                }
            });
        },
        reduce: function(index,id) { //减少
            if ($scope.cartModel.cartList[index].num > 1) {
                $scope.cartModel.cartList[index].num--;
                var qty= $scope.cartModel.cartList[index].num;
            }
            else
            {
            	var qty=1;
            }
            appDataSv.save(global.server.updateNum,{id:id,qty:parseInt(qty)},function(data){
                if(global.status.success==data.status){
                }
            });
        },
        checkAll: function() { //全选
            for (var i in $scope.cartModel.cartList) {
                $scope.cartModel.cartList[i].check = $scope.cartModel.all;
                // console.info($scope.cartModel.cartList[i]);
            }
        },
        loginFirst: function() {
            return $("#login_first")
        }, //先登录提示框
        queryCartList: function() { //查询购物车
            appDataSv.query(global.server.queryCart, $scope.cartModel.cartList, function(data) {
                if (global.status.success == data.status) {
                    $scope.cartModel.cartList = data.data;
                    for (var i = 0; i < data.data.length; i++) {
                        // console.info(data.data);
                    }
                } else{
                    $scope.cartModel.loginFirst().modal();
                }
            }, function(data) {

            });
        },
        getAllSum: function() { //计算总价
            var allPrice = 0;
            for (var i = 0; i < $scope.cartModel.cartList.length; i++) {
                if ($scope.cartModel.cartList[i].check) {
                    allPrice += $scope.cartModel.cartList[i].price * $scope.cartModel.cartList[i].num;
                }
            }
            return allPrice;
        },
        deleteList: function() {
            return $("#delete")
        },
        deleteModal: function() {
          $scope.cartModel.deleteList().modal();
        },
        deleteCart: function(id) { //删除
            appDataSv.save(global.server.deleteCart,{id:id},function(data){
                if(global.status.success==data.status){

                }
            });
        },
        deleteAllCart:function(){//清空购物车
          appDataSv.save(global.server.deleteAllCart,{},function(data){
            if(global.status.success==data.status){
              window.location.reload();
            }
          })
        },
        reload:function(){
          window.location.reload();
        },
        getNums: function() { //获取总数量
            var allShu = 0;
            for (var i = 0; i < $scope.cartModel.cartList.length; i++) {
                if ($scope.cartModel.cartList[i].check) {
                    allShu += (($scope.cartModel.cartList[i].num)*0+1);
                }
            }
            return allShu;
        },
        change:function(content){$(".modal_body").html(content);},//修改弹框内容
        pay: function() { //结算
            obj = document.getElementsByName("payList");
            payList = [];
            for (var k in obj) {
                if (obj[k].checked)
                    payList.push(obj[k].value);
            }
            if(payList.length==0){
              $scope.cartModel.change("请选择至少一件商品");
              $scope.cartModel.deleteList().modal();
            	return;
            }
            $.ajaxFileUpload({
                url: "http://127.0.0.1:7070/web/paylist",
                fileElementId: ['P1'],
                jsonp: "callback1", //服务端用于接收callback调用的function名的参数
                jsonpCallback: "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来
                dataType: "jsonp",
                data: {
                    "payList": payList,
                },
                success: function(data) {
                    $state.go("content.pay", {});
                },
            });
        },
    };
    $scope.cartModel.queryCartList();
});
