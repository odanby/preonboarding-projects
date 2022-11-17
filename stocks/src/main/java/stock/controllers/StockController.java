package stock.controllers;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import stock.entities.Stock;
import stock.exceptions.*;

import io.javalin.http.Handler;
import stock.service.StockService;
import stock.service.StockServiceInterface;

public class StockController {
    
    private StockServiceInterface stockService;

    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    public Handler getAllTickers = ctx -> {
        Gson gson = new Gson();
        try {
            List<Stock> tickers = this.stockService.serviceGetAllTickers();
            if(tickers == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
            String tickersJSONs = gson.toJson(tickers);
            ctx.result(tickersJSONs);
            ctx.status(200);
        } catch (InvalidInputException e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };

    // tomorrow, pick up here to make rest of the handlers


}
