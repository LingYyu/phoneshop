//引入angularjs所需要的模块
var app = angular.module("myShopBack", [
    "ngResource",
    "ui.router",
    "angularFileUpload",
    "treeControl",
    "commonServices",
    "commonDirectives",
    "myShopBackControllers",
    "myShopBackServices",
    "myShopBackDirectives",
    "myShopBackFilters"
]);

var commonServices = angular.module("commonServices", []);

var commonDirectives = angular.module("commonDirectives", []);

var myShopBackControllers = angular.module("myShopBackControllers", []);

var myShopBackServices = angular.module("myShopBackServices", []);

var myShopBackDirectives = angular.module("myShopBackDirectives", []);

var myShopBackFilters = angular.module("myShopBackFilters", []);

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    var st = $stateProvider;
    var ur = $urlRouterProvider;

    ur.otherwise('product');

    st.state('content', {
        url: '/',
        views: {
            "": {
                templateUrl: 'content.html',
                controller: function($scope) {}
            },
            "header@content": {
                templateUrl: 'header.html',
                controller: function($scope) {
                    try {

                    } catch (e) {
                        console.log(e);
                    }


                }
            }
        }
    });


    //商品管理
    st.state('content.product', {
        url: 'product',
        views: {
            "body@content": {
                templateUrl: 'product/product.html',
                controller: "productController",
                controllerAs: "productCtl"
            }
        }
    });
    //订单管理
    st.state('content.orders', {
        url: 'orders',
        views: {
            "body@content": {
                templateUrl: 'orders/orders.html',
                controller: "ordersController",
                controllerAs: "ordersCtl"
            }
        }
    });




}]);
