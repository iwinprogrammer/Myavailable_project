package com.cafe;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

public class Server extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(new Server());
    }

    public void start() {
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        PermittedOptions inboundPermitted1 = new PermittedOptions().setAddress("chatroom");

        SockJSHandler sockJSHandler = SockJSHandler.create(vertx);

        SockJSBridgeOptions options = new SockJSBridgeOptions().addInboundPermitted(inboundPermitted1).addOutboundPermitted(inboundPermitted1);

        router.route("/eventbus/*").subRouter(sockJSHandler.bridge(options));

        router.route().handler(StaticHandler.create());

        server.requestHandler(router).listen(8081);
    }
}