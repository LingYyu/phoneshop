//用户新增
myShopBackDirectives.directive("productAddTpl", function(){
    return {
        restrict: "A",
        replace: true,
        templateUrl: "product/product-add.html"
    };
});
// 删除提示框
myShopBackDirectives.directive("productDelTpl", function(){
    return {
        restrict: "A",
        replace: true,
        templateUrl: "product/product-del.html"
    };
});
// 添加成功提示框
myShopBackDirectives.directive("addSuccessTpl", function(){
    return {
        restrict: "A",
        replace: true,
        templateUrl: "product/add-success.html"
    };
});
