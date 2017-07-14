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
// global.loginPage = "login.html";

//auth
global.auth = "auth";

//path
global.path = "/page";

//服务地址列表
global.server = {};

//server 地址
global.server.address = "/web"; //web fbfweb

//登录地址
global.server.login = global.server.address + "/login";

// 退出登录
global.server.exit=global.server.address + "/exit";

// 注册
global.server.reg = global.server.address + "/zhuce";

//保存收货地址
global.server.saveAddList = global.server.address + "/address";

// 查询收货地址
global.server.queryAddList=global.server.address+"/Alladdress";

// 保存个人资料
global.server.saveNews=global.server.address+"/updateTuser";

//查询个人资料
global.server.queryNewsList =global.server.address+"/selectTuser";

// 查询商品名
global.server.queryProductName=global.server.address+"/product";

// 根据名称查询商品
global.server.queryProduct=global.server.address+"/product/product1";

// 根据id查询
global.server.queryIdList=global.server.address+"/product/product2";

// 查询特价商品
global.server.queryOnsales=global.server.address+"/productmenu/tejia";

// 查询主打商品
global.server.queryLeading=global.server.address+"/productmenu/zhuda";

// 产品明细(名称价格)
global.server.queryProductDetail=global.server.address+"/productmenu/category";

// 产品明细(内存)
global.server.queryProductType=global.server.address+"/productmenu/category1";

// 产品明细(颜色)
global.server.queryProductColor=global.server.address+"/productmenu/category2";

// 查询购物车
global.server.queryCart=global.server.address+"/selectCart";

// 插入购物车
global.server.insertCart=global.server.address+"/insertCart";

// 删除购物车
global.server.deleteCart=global.server.address+"/deleteCart";

//清空购物车
global.server.deleteAllCart=global.server.address+"/deleteAllCart";

// 立即购买
global.server.insertOrder=global.server.address+"/insertOrder";

// 购物车结算
global.server.payList=global.server.address+"/paylist";

// pay页面查询购买
global.server.pay=global.server.address+"/pay";

// 提交订单
global.server.updateOrder=global.server.address+"/updateOrder";

// 查询未支付订单
global.server.selectAllOrder=global.server.address+"/selectAllOrder";

// 查询所有手机
global.server.queryAllPhone=global.server.address+"/queryAllPhone";

// 搜索
global.server.search=global.server.address+"/productmenu/mohu";

//查询搜索
global.server.querySearch=global.server.address+"/productmenu/remohu";

// 查询订单状态
global.server.queryOrderStatus=global.server.address+"/selectOrder1";

// 订单页面继续支付
global.server.payContinue=global.server.address+"/adminorder/continuepay";

// 订单页面确认收货
global.server.checkSuccess=global.server.address+"/adminorder/sucess";

// 更新数量
global.server.updateNum=global.server.address+"/updateNum";

// 删除地址
global.server.deleteAddress=global.server.address+"/deleteaddress";

//查询图片
global.server.querypicture=global.server.address+"/productmenu/category3";
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

function onlyNum() {
    if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39)) 	
    if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
    event.returnValue=false;
}