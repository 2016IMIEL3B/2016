package com.groupe4.controller;

import com.groupe4.entity.Quote;
import com.groupe4.service.QuoteService;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

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
    public void getQuotesByUser() {
        Integer id = Integer.parseInt(this.routingContext.request().getParam("idUser"));

        this.quoteService.getQuotesByUser(id, handler -> {
            if (handler.succeeded()) {
                List<Quote> quotes = handler.result();

                if (quotes.size() > 0) {
                    System.out.println(quotes.toString());
                    this.routingContext.response()
                            .setStatusCode(200)
                            .end(Json.encode(quotes));
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
     * POST /api/users/:idUser/quote
     */
    public void createQuote() {
        Integer id = Integer.parseInt(this.routingContext.request().getParam("idUser"));
        Quote quote = Json.decodeValue(this.routingContext.getBodyAsJson().encode(), Quote.class);
        this.quoteService.createQuote(quote, handler -> {
            if (handler.succeeded()) {
                this.routingContext.response()
                        .setStatusCode(201)
                        .end(Json.encode("Quote created"));
            } else {
                System.out.println("Error in ListController : " + handler.cause());
                this.routingContext.response()
                        .setStatusCode(500)
                        .end(Json.encode("It seems we encountered a problem :("));
            }
        });
    }
}
