//引入angularjs所需要的模块
var app = angular.module("myShop", [
    "ngResource",
    "ui.router",
    "angularFileUpload",
    "treeControl",
    "commonServices",
    "commonDirectives",
    "myShopControllers",
    "myShopServices",
    "myShopDirectives",
    "myShopFilters",
]);

var commonServices = angular.module("commonServices", []);

var commonDirectives = angular.module("commonDirectives", []);

var myShopControllers = angular.module("myShopControllers", []);

var myShopServices = angular.module("myShopServices", []);

var myShopDirectives = angular.module("myShopDirectives", []);

var myShopFilters = angular.module("myShopFilters", []);

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    var st = $stateProvider;
    var ur = $urlRouterProvider;

    ur.otherwise('index');

    st.state('content', {
        url: '/',
        views: {
            "": {
                templateUrl: 'content.html',
                controller: function($scope) {}
            },
            "header@content": {
                templateUrl: 'header.html',
                controller: function($scope,$state,appDataSv) {
                    try {
                        $scope.loginModel = {
                            loginAddModal: function() {
                                return $("#login")
                            }, //登录信息模态窗
                            loginAddOpenModal: function() { //打开登录用户窗口
                                $scope.loginModel.loginAddModal().modal();
                            },
                            closeLoginModal: function() { //关闭注册信息窗口
                                $scope.loginModel.loginAddModal().modal('hide');
                            },
                            info: {
                                email: '',
                                password: '',
                            },
                            msg: '',
                            login: function() {
                                appDataSv.save(global.server.login, $scope.loginModel.info, function(data) {
                                    //登录成功
                                    if (data.status == global.status.success) {
                                        SGLJCache.set(global.token, data.data.token);
                                        SGLJCache.set(global.email, data.data.email);
                                        SGLJCache.set(global.auth, JSON.stringify(data.data.resource));
                                        $scope.loginModel.loginAddModal().modal('hide');
                                        sessionStorage.setItem("loginsuccess", $scope.loginModel.info.email);
                                        $("#after_login").text(sessionStorage.getItem("loginsuccess"));
                                        if (sessionStorage.getItem("loginsuccess") !== null) {
                                            $('#before_login').hide();
                                            $('#before_reg').hide();
                                            $("#after_login").show();
                                            $("#exit").removeClass('fade');
                                        }
                                        $('#login_error').css("display","none");
                                        window.location.reload();
                                    } else {
                                        $('#login_error').css("display","block");
                                    }
                                }, function(data) {
                                    //访问失败
                                    $scope.loginModel.msg = "请求失败！";
                                });
                            },
                            exitLogin:function(){//退出登录
                              appDataSv.save(global.server.exit,{},function(data){
                                    if (data.status == global.status.success) {
                                      sessionStorage.removeItem("loginsuccess");
                                      $('#before_login').show();
                                      $('#before_reg').show();
                                      $("#after_login").hide();
                                      $("#exit").addClass('fade');
                                      $state.go("content.index",{});
                                    }
                              });
                            },
                        };
                        $scope.regModel = {
                            regAddModal: function() {
                                return $("#reg")
                            }, //注册信息模态窗
                            regAddOpenModal: function() { //打开注册用户窗口
                                $scope.regModel.regAddModal().modal();
                            },
                            closeRegModal: function() { //关闭注册信息窗口
                                $scope.regModel.regAddModal().modal('hide');
                            },
                            regList: {
                                sex: '男'
                            },
                            addressSuccess :function(){return $("#success")},
                            inreg :function(){return $("#in_reg")},
                            reg: function() {//注册
                                appDataSv.save(global.server.reg,$scope.regModel.regList, function(data) {
                                    console.info($scope.regModel.regList.email);
                                    if (data.status == global.status.success) {
                                        $scope.regModel.regAddModal().modal('hide');
                                        $scope.regModel.addressSuccess().modal();
                                    }else{
                                      $scope.regModel.inreg().modal();
                                    }
                                });
                            },
                        };
                        $scope.productMenuModel = {
                            product: {}, //商品名称
                            menu: [],
                            queryName: function() { //查询商品名称
                                appDataSv.query(global.server.queryProductName, $scope.productMenuModel.product, function(data) {
                                    if (global.status.success == data.status) {
                                        $scope.productMenuModel.product = data.data;
                                        var j = 0;
                                        var length1 = (data.data.length % 3);
                                        for (var i = 0; i < data.data.length - length1; i++) {
                                            var ary = [];
                                            ary.push(data.data[i].productname);
                                            i++;
                                            ary.push(data.data[i].productname);
                                            i++;
                                            ary.push(data.data[i].productname);
                                            $scope.productMenuModel.menu[j] = ary;
                                            j++;
                                        }
                                        var ary1 = [];
                                        for (var k = data.data.length - length1; k < data.data.length; k++) {
                                            ary1.push(data.data[k].productname);
                                        }
                                        $scope.productMenuModel.menu[j] = ary1;
                                        console.info($scope.productMenuModel.menu);
                                    } else {
                                        console.info("分类名字error");
                                    }
                                });
                            },
                        };
                        $scope.cartCountModel={//购物车计数
                          cartCount:{},
                          queryCartCount: function() { //查询购物车数量
                              appDataSv.query(global.server.queryCart,{}, function(data) {
                                  if (global.status.success == data.status) {
                                      $scope.cartCountModel.cartCount = data.data;
                                      // for (var i = 0; i < data.data.length; i++) {
                                      // }
                                  }
                              });
                          },
                        };
                        $scope.searchModel={//搜索
                          searchList:{
                            name:''
                          },
                          search:function(){
                            appDataSv.save(global.server.search,{name:$scope.searchModel.searchList.name},function(data){
                              if (global.status.success == data.status) {
                                console.info($scope.searchModel.searchList.name);
                              }
                            });
                          }
                        };
                        $scope.cartCountModel.queryCartCount();
                        $scope.productMenuModel.queryName();
                        jQuery(document).ready(function($) {
                            $("#menu").sticky({
                                topSpacing: 0
                            });
                        });
                        $('#date').fdatepicker();
                        $("#after_login").text(sessionStorage.getItem("loginsuccess"));
                        if (sessionStorage.getItem("loginsuccess") !== null) {
                            $('#before_login').hide();
                            $('#before_reg').hide();
                            $("#after_login").show();
                            $("#exit").removeClass('fade');
                        }
                    } catch (e) {
                        console.log(e);
                    }
                }
            }
        }
    });
    //首页
    st.state('content.index', {
        url: 'index',
        views: {
            "body@content": {
                templateUrl: 'index/index.html',
                controller: "indexController",
                controllerAs: "indexCtl"
            }
        }
    });
    //我的账户
    st.state('content.account', {
        url: 'account',
        views: {
            "body@content": {
                templateUrl: 'account/account.html',
                controller: 'accountController',
                controllerAs: 'accountCtl'
            }
        }
    });
    //我的购物车
    st.state('content.cart', {
        url: 'cart',
        params:{
            "name":null,
        },
        views: {
            "body@content": {
                templateUrl: 'cart/cart.html',
                controller: 'cartController',
                controllerAs: 'cartCtl'
            }
        },
    });
    //我的订单
    st.state('content.myorder', {
        url: 'myorder',
        views: {
            "body@content": {
                templateUrl: 'myorder/myorder.html',
                controller: 'myorderController',
                controllerAs: 'myorderCtl'
            }
        }
    });
    //生成订单
    st.state('content.pay', {
        url: 'pay',
        views: {
            "body@content": {
                templateUrl: 'pay/pay.html',
                controller: 'payController',
                controllerAs: 'payCtl'
            }
        }
    });
    //产品分类
    st.state('content.category', {
        url: 'category',
        params: {
            "productname": null,
            "sales":null,
        },
        views: {
            "body@content": {
                templateUrl: 'category/category.html',
                controller: 'categoryController',
                controllerAs: 'categoryCtl'
            }
        }
    });
    // 收货地址
    st.state('content.myaddress', {
        url: 'myaddress',
        views: {
            "body@content": {
                templateUrl: 'myaddress/myaddress.html',
                controller: 'myaddressController',
                controllerAs: 'myaddressCtl'
            }
        }
    });
    // 个人资料
    st.state('content.mynews', {
        url: 'mynews',
        views: {
            "body@content": {
                templateUrl: 'mynews/mynews.html',
                controller: 'mynewsController',
                controllerAs: 'mynewsCtl'
            }
        }
    });
    // 产品明细
    st.state('content.product', {
        url: 'product',
        params: {
            "productname": null,
            "name":null
        },
        views: {
            "body@content": {
                templateUrl: 'product/product.html',
                controller: 'productController',
                controllerAs: 'productCtl'
            }
        }
    });

    //相似宝贝
    st.state('content.similar', {
        url: 'similar',
        params: {
            "productid":null,
        },
        views: {
            "body@content": {
                templateUrl: 'similar/similar.html',
                controller: 'similarController',
                controllerAs: 'similarCtl'
            }
        }
    });
    //特价商品
    st.state('content.sales', {
        url: 'sales',
        params: {
            "sales":null,
        },
        views: {
            "body@content": {
                templateUrl: 'sales/sales.html',
                controller: 'salesController',
                controllerAs: 'salesCtl'
            }
        }
    });
    //主打商品
    st.state('content.leading', {
        url: 'leading',
        params: {
            "sales":null,
        },
        views: {
            "body@content": {
                templateUrl: 'leading/leading.html',
                controller: 'leadingController',
                controllerAs: 'leadingCtl'
            }
        }
    });
    //手机社区
    st.state('content.allphone', {
        url: 'allphone',
        params:{
          "name":null
        },
        views: {
            "body@content": {
                templateUrl: 'allphone/allphone.html',
                controller: 'allphoneController',
                controllerAs: 'allphoneCtl'
            }
        }
    });
    //搜索
    st.state('content.search', {
        url: 'search',
        params:{
          "name":null
        },
        views: {
            "body@content": {
                templateUrl: 'search/search.html',
                controller: 'searchController',
                controllerAs: 'searchCtl'
            }
        }
    });


}]);
