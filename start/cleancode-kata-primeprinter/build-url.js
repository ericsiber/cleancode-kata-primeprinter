function checkOptionsQueryParams(options) {
    for (key in options.queryParams) {
        if (options.queryParams.hasOwnProperty(key)) {
            queryString.push(key + '=' + options.queryParams[key]);
        }
    }
}


function optionChoice(options, buildUrl) {
    if (options.path) {
        builtUrl += '/' + options.path;
    }

    if (options.queryParams) {
        checkOptionsQueryParams(options);
        builtUrl += '?' + queryString.join('&');
    }

    if (options.hash) {
        builtUrl += '#' + options.hash;
    }
}

function urlChoice(url, options) {
    if (url === null) {
        builtUrl = '';
    } else if (typeof(url) === 'object') {
        builtUrl = '';
        options = url;
    } else {
        builtUrl = url;
    }
}

function functionBuildUrl(url, options) {
    var queryString = [];
    var key;
    var builtUrl;

    urlChoice(url, options);

    if (options) {
      optionChoice(options, buildUrl);
    }

    return builtUrl;
};