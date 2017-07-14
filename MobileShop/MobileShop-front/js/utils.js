/**
 * 可复用处理逻辑
 **/

(function(window, document){
    window.UTILS = {
        toLogin: function(){//转到登录页
            SGLJCache.clear();
            window.location.href = global.loginPage;
        },
        isEmpty: function (obj) {//判断当前对象是否为空
            return (obj == null || typeof obj == "undefined" || obj.length == 0)
        },
        isNotEmpty: function (obj) {//判断当前对象是否非空
            return !UTILS.isEmpty(obj);
        },
        getUrlParam: function(param){//获取地址栏参数
            var reg = new RegExp("(^|&)"+ param +"=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if(r!=null)return  unescape(r[2]); return "";
        },
        getUrlParamBydecodeURI: function(param) {//获取经过编码的地址栏参数
            var reg = new RegExp("(^|&)"+ param +"=([^&]*)(&|$)");
            var r = decodeURI(window.location.search).substr(1).match(reg);
            if(r!=null)return  unescape(r[2]); return "";
        },
        loading: function(show){//loading
            if(show == true){
                $("div[id='loading_div']").removeClass('popup');
            } else {
                $("div[id='loading_div']").toggleClass('popup');
            }
        },
        showInfo: function(info, inCallback, btCallback){//消息提示 info=消息; inCallback=显示消息时执行回调; btCallback=点击按钮时回调
            var _this = $("#promptInfoDiv");

            _this.find("span").text(info);
            _this.modal();
            inCallback && inCallback();

            _this.find(".btn-button").one("click", function(){
                _this.find("span").text('');
                btCallback && btCallback();
                _this.find(".btn-button").unbind("click");
                _this.modal('hide');
            });
        },
        openMaximizeWindow: function(url){//最大化打开子窗口
            var option = "height=2900,width=2900,left=0,top=0,resizable=yes,scrollbars=yes,location=no,menubar=no,channelmode=yes";
            var newWindow = window.open(url, "newWindow", option);
            try
            {
                newWindow.moveTo(0,0);
                newWindow.resizeTo(screen.availWidth, screen.availHeight);
            }
            catch(ex){}
        },
        openWindowWithOptions: function(url, winAttrOptions){//按照参数打开子窗口
            var clientScreen =	{
                width : window.screen.width ,
                height : window.screen.height
            };

            UTILS.windowHandle && !UTILS.windowHandle.closed &&UTILS.windowHandle.close();

            var height = winAttrOptions.height || 0;
            var width = winAttrOptions.width || 0;
            var left = winAttrOptions.left || (parseInt(clientScreen.width) - width)/2;
            var top = winAttrOptions.top || (parseInt(clientScreen.height) - height)/2;
            var resizable = winAttrOptions.resizable || "no";
            var scrollbars = winAttrOptions.scrollbars || "no";

            var option = "height=" + height + ",width=" + width + ",left=" + left + ",top=" + top + ",resizable=" + resizable + ",scrollbars=" + scrollbars;

            UTILS.windowHandle = window.open(url,"",option);
        }
    }
})(window, document);