// 先选择颜色和内存
myShopDirectives.directive("choiceFirstTpl",function(){
  return {
    restrict:'A',
    replace:true,
    templateUrl:"product/product-choice.html"
  };
});
// 添加购物车成功
myShopDirectives.directive("addCartTpl",function(){
  return {
    restrict:'A',
    replace:true,
    templateUrl:"product/addcart-tpl.html"
  };
});
