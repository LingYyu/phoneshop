// 提交订单成功
myShopDirectives.directive("paySuccessTpl",function(){
  return {
    restrict:'A',
    replace:true,
    templateUrl:"pay/pay-success.html"
  }
});
//收货地址提醒
myShopDirectives.directive("addRemindTpl",function(){
  return {
    restrict:'A',
    replace:true,
    templateUrl:"pay/add-remind.html"
  }
});
