myShopBackDirectives.directive('pagination', function () {
	return {
		restrict: "A",
		templateUrl: "common/pagination-tpl.html",
		link: function (scope, ele, attrs) {
			scope.currentPage = 1;//当前页数
			scope.pageSize = 10;//分页大小
			scope.pageSizeList = [10, 20, 50];//分页，每页大小选择
			scope.totalPage = 1;//总页数
			scope.pages = [];//分页数组
			scope.totalRecords = 0;//总记录数
			scope.specifiedPage = 1;//用户自定义页码

			//显示页数选择-用于回调
			var showPages = function(totalRecords){
				//清空分页数组
				scope.pages = [];
				console.log("totalRecords: " + totalRecords);
				scope.totalRecords = totalRecords;
				scope.totalPage = Math.ceil(totalRecords / scope.pageSize);
				if(scope.totalPage <= 7){  //7页之内
					var tpLengths = new Array(scope.totalPage);
					for(var j = 0; j < tpLengths.length; j++){
						scope.pages[j] = j + 1;
					}
				}else if(scope.currentPage == 1 && scope.totalPage > 7){    //总页数>7页，并且当前页的分布状态
					scope.pages = [
						scope.currentPage,
						scope.currentPage + 1,
						scope.currentPage + 2,
						scope.currentPage + 3,
						scope.currentPage + 4,
						scope.currentPage + 5,
						scope.currentPage + 6
					];
				}else if(scope.currentPage == 2 && scope.totalPage > 7){
					scope.pages = [
						scope.currentPage - 1,
						scope.currentPage,
						scope.currentPage + 1,
						scope.currentPage + 2,
						scope.currentPage + 3,
						scope.currentPage + 4,
						scope.currentPage + 5
					];
				}else if(scope.currentPage == 3 && scope.totalPage > 7){
					scope.pages = [
						scope.currentPage - 2,
						scope.currentPage - 1,
						scope.currentPage,
						scope.currentPage + 1,
						scope.currentPage + 2,
						scope.currentPage + 3,
						scope.currentPage + 4
					];
				}else if(scope.currentPage > 3 && scope.currentPage < scope.totalPage && scope.currentPage < scope.totalPage - 2 && scope.totalPage > 7){
					scope.pages = [
						scope.currentPage - 3,
						scope.currentPage - 2,
						scope.currentPage - 1,
						scope.currentPage,
						scope.currentPage + 1,
						scope.currentPage + 2,
						scope.currentPage + 3
					];
				}else if(scope.currentPage == scope.totalPage - 2 && scope.totalPage > 7){
					scope.pages = [
						scope.currentPage - 4,
						scope.currentPage - 3,
						scope.currentPage - 2,
						scope.currentPage - 1,
						scope.currentPage,
						scope.currentPage + 1,
						scope.currentPage + 2
					];
				}else if(scope.currentPage == scope.totalPage - 1 && scope.totalPage > 7){
					scope.pages = [
						scope.currentPage - 5,
						scope.currentPage - 4,
						scope.currentPage - 3,
						scope.currentPage - 2,
						scope.currentPage - 1,
						scope.currentPage,
						scope.currentPage + 1
					];
				}else if(scope.currentPage == scope.totalPage && scope.totalPage > 7){
					scope.pages = [
						scope.currentPage - 6,
						scope.currentPage - 5,
						scope.currentPage - 4,
						scope.currentPage - 3,
						scope.currentPage - 2,
						scope.currentPage - 1,
						scope.currentPage
					];
				}
			};

			//需要定义数据供给函数
			var dataMd = attrs.model;
			var dataSv = attrs.method;
			//基于model和非model调用处理
			if (dataSv) {
				if (dataMd && !scope[dataMd][dataSv]){
					throw new Error('data service method is undefined');
				} else if (scope[dataSv]){
					throw new Error('data service method is undefined');
				}
			} else {
				throw new Error('data service method is undefined');
			}

			//监听查询操作事件
			if(attrs.querymethod){
				var querymethod = $("button[" + attrs.querymethod + "]");
				console.log("querymethod:" + querymethod );
				querymethod.bind("click", function(){
					if (dataMd){
						scope[dataMd][dataSv](scope.currentPage, scope.pageSize, showPages);
					} else {
						scope[dataSv](scope.currentPage, scope.pageSize, showPages);
					}
				});
			}

			//绑定下拉框选中函数,选择每页大小使用
			$(ele).find('.page_choice_frame').on("change", "select" , function(){
				console.log($(this).val());
				scope.pageSize = $(this).val();
				scope.currentPage = 1;
				scope.specifiedPage = 1;
				//totalRecords 总记录数
				if (dataMd){
					scope[dataMd][dataSv](scope.currentPage, scope.pageSize, showPages);
				} else {
					scope[dataSv](scope.currentPage, scope.pageSize, showPages);
				}
			});

			//下一页
			scope.next = function () {
				if (scope.currentPage < scope.totalPage) {
					scope.currentPage++;
					scope.getData();
				}
			};

			//上一页
			scope.prev = function () {
				if (scope.currentPage > 1) {
					scope.currentPage--;
					scope.getData();
				}
			};

			//调用数据获取方法
			scope.getData = function (page) {
				page && (scope.currentPage = page);
				//totalRecords 总记录数
				if (dataMd){
					scope[dataMd][dataSv](scope.currentPage, scope.pageSize, showPages);
				} else {
					scope[dataSv](scope.currentPage, scope.pageSize, showPages);
				}
			};

			//判断是否为正整数
			var isPInt = function(str) {
				var g = /^[1-9]*[1-9][0-9]*$/;
				return g.test(str);
			};

			//用户自定义跳转页
			scope.customerPage = function(){
				if(isFinite(scope.specifiedPage) && isPInt(scope.specifiedPage)){ //输入是正整数
					if(scope.specifiedPage < 1){//输入小于1
						scope.specifiedPage = 1;
					} else if(scope.specifiedPage > scope.totalPage) {//输入大于最大页
						scope.specifiedPage = scope.totalPage;
					}
				} else { //输入不是是数字
					scope.specifiedPage = 1;
				}
				scope.getData(scope.specifiedPage);
			};

			//初始加载
			scope.getData();
		}
	};
});
