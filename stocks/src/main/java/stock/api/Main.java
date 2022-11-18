package stock.api;

import io.javalin.Javalin;
import stock.controllers.StockController;
import stock.repository.StockDAO;
import stock.repository.StockDAOInterface;
import stock.service.StockService;
import stock.service.StockServiceInterface;
import stock.utils.HibernateUtil;

public class Main {
    // reminder: the main method is the entry point for your application
    public static void main(String[] args){

        HibernateUtil.getSessionFactory();

        // inside of the create method we call a lambda that Javalin can use to configure our web server
        // referencing a lambda (a method defined in an interface that you can redefine and implement on the fly)
        Javalin app = Javalin.create(config ->{
            config.enableCorsForAllOrigins();  
            config.enableDevLogging();
        });  

        /* 
         * For our controller class to be able to send info to the service layer for validation it must be given a service object. However, that service object requires
         * its own dependencies to work correctly, so this is where we create our official objects for our repo and service layers so that our API can correctly
         * send information where it needs to go
         */
        StockDAOInterface stockDao = new StockDAO();
        StockServiceInterface stockService = new StockService(stockDao);
        StockController stockController = new StockController(stockService);
        
        app.get("/tickers", stockController.getAllTickers);
        app.get("/marketcap/{market_cap}", stockController.filterTickerMarketCap);
        app.get("/amountstocks/{amount_stocks}", stockController.filterTickerAmountStocks);
        app.get("/priceperstock/{price_per_stock}", stockController.filterTickerPriceStock);
        app.get("/company/{ticker}", stockController.getSpecificCompany);
        app.patch("/company/{id}", stockController.updateCompany);

        app.start();
    }
}
