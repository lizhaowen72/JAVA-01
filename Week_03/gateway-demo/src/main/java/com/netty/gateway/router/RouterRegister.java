package com.netty.gateway.router;

import com.google.common.collect.Maps;

import java.util.Map;

public class RouterRegister {
    private static Map<String, HttpEndpointRouter> map = Maps.newHashMap();

    static {
        HttpEndpointRouter randomRouter = new RandomHttpEndpointRouterImpl();
        HttpEndpointRouter roundRobinRouter = new RoundRobinRouterImpl();
        map.put(randomRouter.name(), randomRouter);
        map.put(roundRobinRouter.name(), roundRobinRouter);
    }

    public HttpEndpointRouter getRouter(String routerConf){
        return map.get(routerConf);
    }
}
