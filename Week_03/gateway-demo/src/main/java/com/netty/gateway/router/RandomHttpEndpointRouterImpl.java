package com.netty.gateway.router;

import java.util.List;
import java.util.Random;

public class RandomHttpEndpointRouterImpl implements HttpEndpointRouter{
    @Override
    public String name() {
        return "random";
    }

    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
