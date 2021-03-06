package com.netty.gateway.filter;

import com.google.common.collect.Lists;

import java.util.List;

public class FilterRegister {
    private static List<HttpRequestFilter> filterRequestChains = Lists.newArrayList();

    private static List<HttpResponseFilter> filterResponseChains = Lists.newArrayList();

    static{
        filterRequestChains.add(new HeaderHttpRequestFilter());
        filterResponseChains.add(new HeaderHttpResponseFilter());
    }
    public List<HttpRequestFilter> getRequestFilterChain(){
        return filterRequestChains;
    }

    public List<HttpResponseFilter> getFilterResponseChains(){
        return filterResponseChains;
    }
}
