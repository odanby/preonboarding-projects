package stock.controllers;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import stock.entities.Stock;
import stock.exceptions.*;
import io.javalin.http.Handler;
import stock.service.StockServiceInterface;

public class StockController {
    
    private StockServiceInterface stockService;

    public StockController(StockServiceInterface stockService2){
        this.stockService = stockService2;
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

    public Handler filterTickerMarketCap = ctx -> {
        int market_cap = Integer.parseInt(ctx.pathParam("market_cap"));
        Gson gson = new Gson();
        try {
            List<Stock> stock = this.stockService.serviceTickerMarketCap(market_cap);
            if(stock == null){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", "Error processing request");
                ctx.result(gson.toJson(message));
                ctx.status(400);
            } else {
                String stockJSON = gson.toJson(stock);
                ctx.result(stockJSON);
                ctx.status(200);
            }
        } catch (InvalidInputException e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
    
        public Handler filterTickerAmountStocks = ctx -> {
            int amount_stocks = Integer.parseInt(ctx.pathParam("amount_stocks"));
            Gson gson = new Gson();
            try {
                List<Stock> stock = this.stockService.serviceTickerAmountStocks(amount_stocks);
                if(stock == null){
                    HashMap<String, String> message = new HashMap<>();
                    message.put("errorMessage", "Error processing request");
                    ctx.result(gson.toJson(message));
                    ctx.status(400);
                } else {
                    String stockJSON = gson.toJson(stock);
                    ctx.result(stockJSON);
                    ctx.status(200);
                }
            } catch (InvalidInputException e){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", e.getMessage());
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
        };

        public Handler filterTickerPriceStock = ctx -> {
            int price_per_stock = Integer.parseInt(ctx.pathParam("price_per_stock"));
            Gson gson = new Gson();
            try {
                List<Stock> stock = this.stockService.serviceTickerPriceStock(price_per_stock);
                if(stock == null){
                    HashMap<String, String> message = new HashMap<>();
                    message.put("errorMessage", "Error processing request");
                    ctx.result(gson.toJson(message));
                    ctx.status(400);
                } else {
                    String stockJSON = gson.toJson(stock);
                    ctx.result(stockJSON);
                    ctx.status(200);
                }
            } catch (InvalidInputException e){
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", e.getMessage());
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
        };

        public Handler getSpecificCompany = ctx -> {
            String ticker = ctx.pathParam("ticker");
            Gson gson = new Gson();
            try {
                List<Stock> stock = this.stockService.serviceGetSpecificCompany(ticker);
                if (stock == null) {
                    HashMap<String, String> message = new HashMap<>();
                    message.put("errorMessage", "Error processing request");
                    ctx.result(gson.toJson(message));
                    ctx.status(400);
                }
                HashMap<String, List<Stock>> map = new HashMap<>();
                map.put("searchResult", stock);
                String stockJSON = gson.toJson(map);
                ctx.result(stockJSON);
                ctx.status(200);
            } catch (InvalidInputException e) {
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", e.getMessage());
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
        };
    
        // // update company's market cap and price per stock
        // Stock serviceUpdateCompany(Stock updatedCompany);

        public Handler updateCompany = ctx -> {
            Gson gson = new Gson();
            try {
               // get json from request body
               String json = ctx.body();
               // convert json to our java object
               Stock updatedCompany = gson.fromJson(json, Stock.class);
               // make it pull with id
               updatedCompany.setId(Integer.parseInt(ctx.pathParam("id")));
               // pass the data into the service layer and get method result back
               Stock result = this.stockService.serviceUpdateCompany(updatedCompany);
               // convert the result into a json
               String resultJson = gson.toJson(result);
               // Set the response body and status code
               ctx.result(resultJson);
               ctx.status(200);
            } catch(InvalidInputException e) {
                HashMap<String, String> message = new HashMap<>();
                message.put("errorMessage", e.getMessage());
                ctx.result(gson.toJson(message));
                ctx.status(400);
            }
           };

}
