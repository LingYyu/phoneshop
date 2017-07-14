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
            // alert("ssssss");
            loginSv.save($.param($scope.loginModel.info), function(data){
                //登录成功
                  console.log(data);
                if (data.status == global.status.success){
                    SGLJCache.set(global.token, data.data.token);
                    SGLJCache.set(global.email, data.data.email);
                    SGLJCache.set(global.auth, JSON.stringify(data.data.resource));

                    window.location.href = 'index.html';
                }else {
                    $scope.loginModel.msg = data.msg;
                }
            }, function(data){
                //访问失败
                $scope.loginModel.msg = "请求失败！";
            });
        },
    };

});
