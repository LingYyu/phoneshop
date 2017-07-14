//用户新增
myShopBackDirectives.directive("orderSendTpl", function(){
    return {
        restrict: "A",
        replace: true,
        templateUrl: "orders/orders-send.html"
    };
});
