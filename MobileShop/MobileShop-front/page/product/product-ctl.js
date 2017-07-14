myShopControllers.controller('productController', function($scope, $state,$stateParams, appDataSv) {
    $('#index_header').show();
    $('#account_header').hide();
    $scope.isActive = true;
    $scope.productModel = {
        list: {},
        queryList: function() {//查询名字
            $scope.productModel.list.name = $stateParams.name;
            appDataSv.save(global.server.queryProductDetail, {
                name: $scope.productModel.list.name
            }, function(data) {
                if (global.status.success == data.status) {
                    $scope.productModel.list = data.data;
                    console.info(data.data);
                }
            });
        },
        colorList:{},
        queryColorList:function(){//查询颜色
          $scope.productModel.colorList.name = $stateParams.name;
          appDataSv.save(global.server.queryProductColor, {
              name: $scope.productModel.colorList.name
          }, function(data) {
              if (global.status.success == data.status) {
                  $scope.productModel.colorList = data.data;
                  console.info(data.data);
              }
          });
        },
        typeList: {},
        queryTypeList: function() {//查询内存
            $scope.productModel.typeList.name = $stateParams.name;
            appDataSv.save(global.server.queryProductType, {
                name: $scope.productModel.typeList.name
            }, function(data) {
                if (global.status.success == data.status) {
                    $scope.productModel.typeList = data.data;
                    console.info(data.data);
                }
            });
        },
        // picture:{},//查询图片
        // queryPicture:function(){
        //   $scope.productModel.picture.name = $stateParams.name;
        //     appDataSv.save(global.server.querypicture,{name: $scope.productModel.picture.name},function(data){
        //       if (global.status.success == data.status) {
        //           $scope.productModel.picture = data.data;
        //           console.info(data.data);
        //       }
        //     });
        // },
        add:function(){//增加
          $scope.productModel.list.qty++;
        },
        reduce:function(){//减少
          if($scope.productModel.list.qty>1){
                      $scope.productModel.list.qty--;
                }
        },
        phone:{
            color:'',
            type:'',
            qty:''
        },//插入购物车
        checkColor:function(color){//选择颜色
          $scope.productModel.phone.color=color;
          console.info(color);
        },
        checkType:function(type){//选择类型
            $scope.productModel.phone.type=type;
            console.info(type);
        },
        loginFirst:function(){return $("#login_first")},//先登录提示框
        cartAdd:function(){return $('#add_cart')},//添加购物车成功
        choiceFirst:function(){return $("#choice_first")},//选择颜色和内存
        insert:function(){//加入购物车
        	 var re = /^[1-9]+[0-9]*]*$/;
          $scope.productModel.phone.qty=$scope.productModel.list.qty;
           if (!re.test($scope.productModel.phone.qty))
    {
       alert("请输入数字");
        return false;
     }
          

          appDataSv.save(global.server.insertCart,$scope.productModel.phone,function(data){
              if (global.status.success == data.status) {
                $scope.productModel.cartAdd().modal();
              }
              else if(data.status =="3")
              {
              	 $scope.productModel.choiceFirst().modal();

              }
              else{
                $scope.productModel.loginFirst().modal();
              }
          },function(data){
                $scope.productModel.choiceFirst().modal();
          });
        },
        pay:function(){//立即购买
           var re = /^[1-9]+[0-9]*]*$/;
          $scope.productModel.phone.qty=$scope.productModel.list.qty;
           if (!re.test($scope.productModel.phone.qty))
    {
       alert("请输入数字");
        return false;
     }
          appDataSv.save(global.server.insertOrder,$scope.productModel.phone,function(data){
            if(global.status.success==data.status) {
                console.info(data.data);
                $state.go("content.pay",{});
            }
               else if(data.status =="3")
              {
              	 $scope.productModel.choiceFirst().modal();
              }
            else{
              $scope.productModel.loginFirst().modal();
            }
          },function(data){
                $scope.productModel.choiceFirst().modal();
          });
        },
        addSuccess:function(){//加入成功
            window.location.reload();
        },

    };
    // $scope.productModel.queryPicture();
    $scope.productModel.queryList();
    $scope.productModel.queryColorList();
    $scope.productModel.queryTypeList();
    $(document).ready(function() {
        $(".jqzoom").imagezoom();
        $("#thumblist li a").click(function() {
            //增加点击的li的class:tb-selected，去掉其他的tb-selecte
            $(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
            //赋值属性
            $(".jqzoom").attr('src', $(this).find("img").attr("mid"));
            $(".jqzoom").attr('rel', $(this).find("img").attr("big"));
        });
    });
    $('#product-color').on('click', 'li', function(e) {
        if ($(this).hasClass('product-color-hover')) {
            $(this).removeClass('product-color-hover');
        } else {
            $(this).addClass('product-color-hover').siblings().removeClass('product-color-hover');
        }
    });
    $('#product-ram').on('click', 'li', function(e) {
        if ($(this).hasClass('product-ram-li-hover')) {
            $(this).removeClass('product-ram-li-hover');
        } else {
            $(this).addClass('product-ram-li-hover').siblings().removeClass('product-ram-li-hover');
        }
    });
    $(function(){
      $('.product-desc ul li').click(function(){
        $(this).addClass('active').siblings().removeClass('active');
        $('.tab-pane').eq($(this).index()).addClass('in active').siblings().removeClass('in active');
      });
    });
});
