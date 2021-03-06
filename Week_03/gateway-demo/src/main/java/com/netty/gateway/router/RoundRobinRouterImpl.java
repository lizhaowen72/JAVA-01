package com.netty.gateway.router;

import java.util.List;

public class RoundRobinRouterImpl implements HttpEndpointRouter{
    private static int i = 0;

    @Override
    public String name() {
        return "round_robin";
    }

    @Override
    public String route(List<String> endpoints) {
        int j = (RoundRobinRouterImpl.i + 1) % endpoints.size();
        i = j;
        return endpoints.get(j);
    }
}
