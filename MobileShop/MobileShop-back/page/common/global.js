var SGLJVersion = 20161117;
//全局变量配置
var global = {};

//状态常量定义 - status
global.status = {
    success: 1,//成功
    error: 0,//失败
    desc:{
        1: "成功",
        0: "失败"
    }
};
//枚举值key
global.enumKey = {
    //场景类型
    INSTANCE_TYPE: 'instanceType',
    //场景参数类型
    INSTANCE_PARAMS: 'instanceParams',
    //作业类型
    TASK_TYP: 'taskType',
    //作业注册状态
    TASK_HAD_REGISTED: "taskHadRegisted",
    //场景流程状态
    INSTANCE_AUDIT: "instanceAudit"
};

//错误编码- error
global.error = {
    SESSION_INVALID: 'SYS00000',
    desc:{
        'SYS00000': '令牌失效，请重新登录!'
    }
};

global.msg = {
    errorMsg:"系统发生错误，请联系管理员！",
    title:"提示",
    successMsg: "操作成功！"
};

//token
global.token = "authorization";

//username
global.email = "email";

//login page
global.loginPage = "login.html";

//auth
global.auth = "auth";

//path
global.path = "/page";

//服务地址列表
global.server = {};

//server 地址
global.server.address = "/web"; //web fbfweb

//登录地址
// global.server.login = global.server.address+ "/adminlogin";

// 查询在售商品
global.server.selectOnsales=global.server.address+"/admain/selectorder";

// 查询待售商品
global.server.selectUnsales=global.server.address+"/admain/selectadd";

// 下架
global.server.down=global.server.address+"/admain/downorder";

// 上架
global.server.up=global.server.address+"/admain/uporder";

// 查询全部订单
global.server.queryAllOrder=global.server.address+"/adminorder/selectorder";

// 查询状态
global.server.queryStatus=global.server.address+"/adminorder/selectorder1";

// 发货
global.server.sendTo=global.server.address+"/adminorder/fahuo";

// 订单查询
global.server.findOrder=global.server.address+"/adminorder/mohu";



//场景引擎相关接口地址
global.server.LWAMS = {};

//场景引擎基础地址
global.server.LWAMS.baseUrl = "/LWAMS";

//场景编辑页地址
global.server.LWAMS.interfaceEditor = global.server.LWAMS.baseUrl + "/job_graph_view/interfaceEditor";

//作业流程图查看地址
global.server.LWAMS.interfaceMonitor = global.server.LWAMS.baseUrl +"/job_graph_view/interfaceMonitor";

/**
 * Fixed error: "console" is undefined in IE<10 if dev tools are not open
 */
(function(window) {
    if (window.console) return;
    window.console = (function() {
        var methods = 'assert,clear,count,debug,dir,dirxml,error,exception,group,groupCollapsed,groupEnd,info' +
            ',log,markTimeline,profile,profileEnd,table,time,timeEnd,timeStamp,trace,warn';
        methods = methods.split(',');
        var noop = function() {};
        var object = {};
        var key;

        while(key = methods.pop()) {
            object[key] = noop;
        }
        return object;
    }());
}(window));

//close console
//window.console = {
//    log: function(){},
//    info: function (){}
//};
