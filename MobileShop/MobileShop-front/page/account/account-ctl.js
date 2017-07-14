myShopControllers.controller('accountController', function($scope, appDataSv) {
    $("#account_header").show();
    $("#index_header").hide();
    $scope.accountModel = {
        person: {}, //个人信息
        queryPerson: function() { //查询个人信息
            appDataSv.query(global.server.queryNewsList, {}, function(data) {
                if (global.status.success == data.status) {
                    $scope.accountModel.person = data.data;
                    $("#addressMaterial").attr("src",data.data[0].picture);
                    console.log(data.data);
                }
            });
        },
        clickUnpay:function(){
            $("#unpay").removeClass("hide");
            $("#pay").addClass("hide");
            $("#onroad").addClass("hide");
            $("#pingjia").addClass("hide");
        },
        clickPay:function(){
            $("#unpay").addClass("hide");
            $("#pay").removeClass("hide");
            $("#onroad").addClass("hide");
            $("#pingjia").addClass("hide");
        },
        clickOnroad:function(){
            $("#unpay").addClass("hide");
            $("#pay").addClass("hide");
            $("#onroad").removeClass("hide");
            $("#pingjia").addClass("hide");
        },
        clickPingjia:function(){
            $("#unpay").addClass("hide");
            $("#pay").addClass("hide");
            $("#onroad").addClass("hide");
            $("#pingjia").removeClass("hide");
        },
        unpay: {
          status:0,
        }, //待支付
        queryUnpay: function() {
            appDataSv.save(global.server.queryOrderStatus, {status:$scope.accountModel.unpay.status}, function(data) {
                if (global.status.success == data.status) {
                    $scope.accountModel.unpay = data.data;
                    console.log(data.data);
                }
            });
        },
        pay: {
          status:1,
        }, //待发货
        queryPay: function() {
            appDataSv.save(global.server.queryOrderStatus, {status:$scope.accountModel.pay.status}, function(data) {
                if (global.status.success == data.status) {
                    $scope.accountModel.pay = data.data;
                    console.log(data.data);
                }
            });
        },
        onroad: {
          status:2,
        }, //等待收货
        queryOnroad: function() {
            appDataSv.save(global.server.queryOrderStatus, {status:$scope.accountModel.onroad.status}, function(data) {
                if (global.status.success == data.status) {
                    $scope.accountModel.onroad = data.data;
                    console.log(data.data);
                }
            });
        },
        pingjia: {
          status:3,
        }, //等待收货
        querypPingjia: function() {
            appDataSv.save(global.server.queryOrderStatus, {status:$scope.accountModel.pingjia.status}, function(data) {
                if (global.status.success == data.status) {
                    $scope.accountModel.pingjia = data.data;
                    console.log(data.data);
                }
            });
        },

    };
    $scope.accountModel.queryPerson();
    $scope.accountModel.queryUnpay();
    $scope.accountModel.queryPay();
    $scope.accountModel.queryOnroad();
    $scope.accountModel.querypPingjia();

});
