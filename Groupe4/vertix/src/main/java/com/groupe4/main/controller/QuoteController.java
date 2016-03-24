package com.groupe4.main.controller;

import com.groupe4.entity.Quote;
import com.groupe4.main.QuoteService;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

/**
 * Created by Link on 23/03/2016.
 */
public class QuoteController {

    /**
     * Quote service
     */
    private QuoteService quoteService;

    /**
     * Routing context.
     */
    private RoutingContext routingContext;

    /**
     * Constructor
     * @param routingContext
     */
    public QuoteController(RoutingContext routingContext) {
        this.routingContext = routingContext;
        this.quoteService = new QuoteService();
    }

    /**
     * Return a list of Quote.
     * GET /api/users/:idUser/quotes
     */
    public void getQuotesByUser(Integer userId) {
        Integer id = Integer.parseInt(this.routingContext.request().getParam("idUser"));

        this.quoteService.getQuotesByUser(id, handler -> {
            if (handler.succeeded()) {
                List<Quote> quotes = handler.result();
                JsonObject list = new JsonObject();

                for (Quote quote : quotes) {
                    list.put(quote.getId().toString(), quote.getUserName());
                }

                if (quotes.size() > 0) {
                    JsonObject responseBody = new JsonObject();
                    responseBody.put(id.toString(), list);

                    this.routingContext.response()
                            .setStatusCode(200)
                            .end(Json.encode(responseBody));
                } else {
                    this.routingContext.response()
                            .setStatusCode(404)
                            .end(Json.encode("Quote type not found."));
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
     * Return true if succeed.
     * POST /api/users/:idUser/quotes
     */
    public void createQuote(Quote quote) {
        Integer id = Integer.parseInt(this.routingContext.request().getParam("idUser"));

        this.quoteService.createQuote(quote, handler -> {
            if (handler.succeeded()) {
                List<Quote> quotes = handler.result();
                JsonObject list = new JsonObject();

                for (Quote quote : quotes) {
                    list.put(quote.getId().toString(), quote.getUserName());
                }

                if (quotes.size() > 0) {
                    JsonObject responseBody = new JsonObject();
                    responseBody.put(id.toString(), list);

                    this.routingContext.response()
                            .setStatusCode(200)
                            .end(Json.encode(responseBody));
                } else {
                    this.routingContext.response()
                            .setStatusCode(404)
                            .end(Json.encode("Quote type not found."));
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
