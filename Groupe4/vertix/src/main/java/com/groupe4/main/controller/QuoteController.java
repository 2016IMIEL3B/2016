package com.groupe4.main.controller;

import com.groupe4.main.QuoteService;
import io.vertx.ext.web.RoutingContext;

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

}
