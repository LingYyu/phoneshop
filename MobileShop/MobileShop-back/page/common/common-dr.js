//通用指令

//提示框
commonDirectives.directive("sgljMsgTpl", function(){
    return {
        restrict: 'A',
        replace: true,
        templateUrl: "common/prompt-tpl.html"
    }
});

//loading页面
commonDirectives.directive("sgljLoadingTpl", function(){
    return {
        restrict: 'A',
        replace: true,
        templateUrl: "common/loading-tpl.html"
    }
});