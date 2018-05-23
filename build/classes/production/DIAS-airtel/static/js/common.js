$.ajax({
    url: options.url ,
    type: options.type || "POST",
    cache: options.cache || false,
    async: (options.async === false) ? false : true,
    dataType: options.dataType || "JSON",
    data: options.data || null,
    timeout: options.timeout || 30000,
    contentType : options.contentType || "application/x-www-form-urlencoded;charset=UTF-8",
    beforeSend: function () {
        //ajaxMainObject.ajaxHandler.ajaxStart((options.parentElem || $body), (options.loader || false), (options.loadMore || false), options);
        try {
            if (options.beforeSend && typeof options.beforeSend === 'function') {
                options.beforeSend($currentEle);
            }
        } catch (error){
            console.warn('$currentEle is undefined.');
        }
    },
    success: function(data, status, jqXHR){
        //Redirecting the Page if Response Header have "ajax-redirect-url" property set with some URL.
        try{
            var requestHeaders = jqXHR.getResponseHeader('session-timeout-redirect-url');

            if (requestHeaders !== null && requestHeaders !== '') {
                window.location.href = requestHeaders;
            } else if(typeof(options.success)==="function"){
                options.success(data, status, jqXHR, $currentEle);
            }
        } catch (error){
            console.warn('$currentEle is undefined.');
        }
    },
    error : function(status, textStatus, errorThrown) {
        var requestHeaders = status.getResponseHeader('session-timeout-redirect-url');

        if (requestHeaders !== null && requestHeaders !== '') {
            window.location.href = requestHeaders;
        }else if(typeof(options.error)==="function"){
            options.error(status, textStatus, errorThrown, $currentEle);
        }else{
            ajaxMainObject.showError(status, textStatus, errorThrown);
        }
    },
    complete: function () {
        ajaxMainObject.ajaxHandler.ajaxStop($parentElem, (options.loader || false));
        if(options.complete && typeof options.complete === 'function'){
            options.complete($currentEle);
        }
    }
});
