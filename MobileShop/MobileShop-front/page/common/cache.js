/**
 * use utf-8
 * 缓存在一次session中需要用到的数据
 * Created by guanhongwei on 2016/11/17.
 */
var SGLJCache = {
    info: {},
    init: function(){
        SGLJCache.info = sessionStorage;
    },
    get: function(k){
        return SGLJCache.info.getItem(k);
    },
    set: function(k, v){
        SGLJCache.info.setItem(k, v);
    },
    update: function(k, v){
        SGLJCache.info.setItem(k, v);
    },
    del: function(k){
        SGLJCache.info.removeItem(k);
    },
    clear: function(){
        SGLJCache.info.clear();
    }
};
SGLJCache.init();