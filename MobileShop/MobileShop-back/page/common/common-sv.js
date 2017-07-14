//通用服务

//请求接口服务类-restful
commonServices.factory("appDataSv", function($resource){

    //调用
    var res = function(doType, url, reqData, successCB, errorCB){
        UTILS.loading(true);//loading
        var tokenObj = {};
        tokenObj[global.token] = SGLJCache.get(global.token);
        reqData = $.extend(reqData, tokenObj);
        if(doType == 'SAVE'){//保存-表单提交
            $resource(url, {}, {
                save: {
                    method:'POST',
                    headers:{
                        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
                    }
                }
            }).save($.param(reqData), function(data){
                UTILS.loading();//close loading

                //session 失效
                if(data && data.error && data.error == global.error.SESSION_INVALID){
                    UTILS.showInfo(global.error.desc[global.error.SESSION_INVALID], '', function(){
                        UTILS.toLogin();
                    });
                    return;
                }
                //执行回调
                if (successCB){
                    successCB(data);
                } else {
                    UTILS.showInfo(global.msg.successMsg);
                }
            }, function(data){
                UTILS.loading();//close loading
                //执行回调
                if (errorCB){
                    errorCB(data);
                } else {
                    UTILS.showInfo(global.msg.errorMsg);
                }
            });
        } else if (doType == "QUERY"){//查询
            $resource(url, {}, {
                query: {
                    method:'GET',
                    isArray:false
                }
            }).query(reqData, function(data){
                UTILS.loading();//close loading

                //session 失效
                if(data && data.error && data.error == global.error.SESSION_INVALID){
                    UTILS.showInfo(global.error.desc[global.error.SESSION_INVALID], '', function(){
                        UTILS.toLogin();
                    });
                    return;
                }

                //执行回调
                if (successCB){
                    successCB(data);
                } else {
                    UTILS.showInfo(global.msg.successMsg);
                }
            }, function(data){
                UTILS.loading();//close loading
                //执行回调
                if (errorCB){
                    errorCB(data);
                } else {
                    UTILS.showInfo(global.msg.errorMsg);
                }
            });
        } else if (doType == 'SAVE-BODY') {//保存-以 JSON 方式提交
            $resource(url, {}, {
                save: {
                    method:'POST',
                    headers:{
                        'Content-Type': 'application/json;charset=UTF-8',
                        'authorization': SGLJCache.get(global.token)
                    }
                }
            }).save(JSON.stringify(reqData), function(data){
                UTILS.loading();//close loading

                //session 失效
                if(data && data.error && data.error == global.error.SESSION_INVALID){
                    UTILS.showInfo(global.error.desc[global.error.SESSION_INVALID], '', function(){
                        UTILS.toLogin();
                    });
                    return;
                }

                //执行回调
                if (successCB){
                    successCB(data);
                } else {
                    UTILS.showInfo(global.msg.successMsg);
                }
            }, function(data){
                UTILS.loading();//close loading
                //执行回调
                if (errorCB){
                    errorCB(data);
                } else {
                    UTILS.showInfo(global.msg.errorMsg);
                }
            });
        }
    };

    return {
        save: function(url, reqData, successCB, errorCB){//保存-表单提交
            res('SAVE', url, reqData, successCB, errorCB);
        },
        saveBody: function(url, reqData, successCB, errorCB){//保存-以 JSON 方式提交
            res('SAVE-BODY', url, reqData, successCB, errorCB);
        },
        query: function(url, reqData, successCB, errorCB){//查询
            res('QUERY', url, reqData, successCB, errorCB);
        }
    }
});


























