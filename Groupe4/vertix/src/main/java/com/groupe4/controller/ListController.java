package com.groupe4.controller;

import com.groupe4.entity.Item;
import com.groupe4.service.ItemService;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

/**
 * List controller.
 */
public class ListController {
    /**
     * Item service.
     */
    private ItemService itemService;

    /**
     * Routing context.
     */
    private RoutingContext routingContext;

    /**
     * Constructor.
     * @param routingContext
     */
    public ListController(RoutingContext routingContext) {
        this.routingContext = routingContext;
        this.itemService = new ItemService();
    }

    /**
     * Return a list of requested item.
     * GET /api/lists
     */
    public void getListsAction() {
        String type = this.routingContext.request().getParam("type");

        this.itemService.findItemListByKey(type, handler -> {
            if (handler.succeeded()) {
                List<Item> items = handler.result();
                JsonObject list = new JsonObject();

                for (Item item : items) {
                    list.put(item.getId().toString(), item.getValue());
                }

                if (items.size() > 0) {
                    JsonObject responseBody = new JsonObject();
                    responseBody.put(type, list);

                    this.routingContext.response()
                            .setStatusCode(200)
                            .end(Json.encode(responseBody));
                } else {
                    this.routingContext.response()
                            .setStatusCode(404)
                            .end(Json.encode("List type not found."));
                }
            } else {
                System.out.println("Error in ListController : " + handler.cause());
                this.routingContext.response()
                        .setStatusCode(500)
                        .end(Json.encode("It seems we encountered a problem :("));
            }
        });
    }

    /**
     * Return a list of requested item.
     * GET /api/lists/:id
     */
    public void getListsByParentId() {
        Integer id = Integer.parseInt(this.routingContext.request().getParam("id"));

        this.itemService.findItemListByParentId(id, handler -> {
            if (handler.succeeded()) {
                List<Item> items = handler.result();
                JsonObject list = new JsonObject();

                for (Item item : items) {
                    list.put(item.getId().toString(), item.getValue());
                }

                if (items.size() > 0) {
                    JsonObject responseBody = new JsonObject();
                    responseBody.put(id.toString(), list);

                    this.routingContext.response()
                            .setStatusCode(200)
                            .end(Json.encode(responseBody));
                } else {
                    this.routingContext.response()
                            .setStatusCode(404)
                            .end(Json.encode("List id not found."));
                }
            } else {
                System.out.println("Error in ListController : " + handler.cause());
                this.routingContext.response()
                        .setStatusCode(500)
                        .end(Json.encode("It seems we encountered a problem :("));
            }
        });
    }
}
