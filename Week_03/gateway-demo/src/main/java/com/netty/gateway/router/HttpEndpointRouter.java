package com.netty.gateway.router;

import java.util.List;

public interface HttpEndpointRouter {
    String name();

    String route(List<String> endpoints);
}
