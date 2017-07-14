//尾部
myShopDirectives.directive("footerTpl",function(){
  return {
    restrict:'A',
    replace:true,
    templateUrl:"common/footer.html"
  }
});
//添加成功
myShopDirectives.directive("successTpl",function(){
  return {
    restrict:'A',
    replace:true,
    templateUrl:"common/success-tpl.html"
  }
});
// 请先登录
myShopDirectives.directive("loginFirstTpl",function(){
  return {
    restrict:'A',
    replace:true,
    templateUrl:"common/loginfirst-tpl.html"
  }
});
// 注册用户已存在
myShopDirectives.directive("inRegTpl",function(){
  return {
    restrict:'A',
    replace:true,
    templateUrl:"common/inreg-tpl.html"
  }
});
