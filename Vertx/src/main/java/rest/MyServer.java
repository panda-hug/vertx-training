package rest;

import com.google.inject.Inject;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static consts.ServerMessages.SERVER_FAILED;
import static consts.ServerMessages.SERVER_LISTENING;

/**
 * @author Yael Nisanov
 * @since 10/03/2020
 */
public class MyServer extends AbstractVerticle {

    private static final Logger logger = LogManager.getLogger(MyServer.class);

    private static final int PORT = 8080;

    @Inject
    private Handlers handlers;

    private Vertx vertx = Vertx.vertx();

    private Router router = Router.router(vertx);

    @Override
    public void start() {
        HttpServer server = vertx.createHttpServer();
        router.route().handler(BodyHandler.create());
        registerRoutes();
        server.requestHandler(router).listen(PORT, result -> {
            if (result.succeeded()) {
                logger.info(SERVER_LISTENING.getMessage() + " " + PORT);
                logger.info("Yael");
            } else {
                logger.info(SERVER_FAILED);
            }
        });
    }

    private void registerRoutes() {
        router.get("/getSoldier/:id").handler(handlers::getSoldier);
        router.get("/getAllSoldiers").handler(handlers::getAllSoldiers);
        router.post("/addSoldier").handler(handlers::addSoldier);
        router.delete("/removeSoldier/:id").handler(handlers::removeSoldier);
        router.put("/updateSoldier").handler(handlers::updateSoldier);
    }

}
