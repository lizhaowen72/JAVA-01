package com.netty.gateway.router;

import java.util.List;

public class RouterSelector {
    private RouterRegister routerRegister = new RouterRegister();

    public String getUrl(List<String> urls){
        String name = "round_robin";//此处可作为配置
        HttpEndpointRouter router = routerRegister.getRouter(name);
        return router.route(urls);
    }
}
