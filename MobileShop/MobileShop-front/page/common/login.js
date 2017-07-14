//登录相关处理
var app = angular.module("LoginApp", [
    "ngResource",
    "ipCookie"
]);

app.factory("loginSv", function($resource){
    return $resource(global.server.login, {}, {
        save: {
            method: 'POST',
            headers:{
                'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
            }
        }
    });
});

//登录页控制器
app.controller("loginCtl", function($scope, ipCookie, loginSv) {
    $scope.loginModel = {
        info: {
            email: '',
            password: '',
        },
        msg: '',
        login: function(){
            loginSv.save($.param($scope.loginModel.info), function(data){
                //登录成功
                if (data.status == global.status.success){
                    SGLJCache.set(global.token, data.data.token);
                    SGLJCache.set(global.email, data.data.email);
                    SGLJCache.set(global.auth, JSON.stringify(data.data.resource));
                    //记住密码
                    $scope.loginModel.keepPaswd();
                    window.location.href = 'index.html';
                }else {
                    $scope.loginModel.msg = data.msg;
                }
            }, function(data){
                //访问失败
                $scope.loginModel.msg = "请求失败！";
            });
        },
        keepPaswd: function(){
            if($scope.loginModel.info.keep == 1){//记住密码
                ipCookie(global.email, $scope.loginModel.info.email,{
                    path: global.path,
                    expires: 1
                });
                ipCookie('passwd', $scope.loginModel.info.password, {
                    path: global.path,
                    expires: 1
                });
            } else {//取消记住
                ipCookie.remove(global.email, {
                    path: global.path
                });
                ipCookie.remove('passwd', {
                    path: global.path
                });
            }
        },
        setUP: function(){//记住密码操作
            if (ipCookie(global.email)){
                $scope.loginModel.info.email = ipCookie(global.email);
                $scope.loginModel.info.password = ipCookie('passwd');
                $scope.loginModel.info.keep = '1';
                $scope.loginModel.info.checked = 1;
            }
        }
    };
    $scope.loginModel.setUP();
});
