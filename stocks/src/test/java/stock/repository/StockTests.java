package stock.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import stock.entities.Stock;

public class StockTests {

    public static StockDAOInterface stockDao = new StockDAO();

    // TEST to retrieve all tickers
        // List<Stock> getAllTickers();
    @Test
    public void getAllTickers(){
        List<Stock> result = stockDao.getAllTickers();
        Assert.assertNotNull(result);
    }

    // TEST to filter tickers by market cap
        // List<Stock> tickerMarketCap(Stock market_cap);
    @Test
    public void filterMarketCap(){
        List<Stock> result = stockDao.tickerMarketCap(9000);
        Assert.assertNotNull(result);
    }

    // TEST to filter tickers by amount of stocks
        // List<Stock> tickerAmountStocks(Stock amount_stocks);
    @Test
    public void filterAmountStocks(){
        List<Stock> result = stockDao.tickerAmountStocks(50);
        Assert.assertNotNull(result);
    }

    // TEST to filter tickers by price of stocks
        // List<Stock> tickerPriceStock(Stock price_per_stock);
    @Test
    public void filterPriceStock(){
        List<Stock> result = stockDao.tickerPriceStock(200);
        Assert.assertNotNull(result);
    }

    // TEST to retrieve company by ticker
        // List<Stock> getSpecificCompany(Stock ticker);
    @Test
    public void getSpecificCompany(){
        List<Stock> result = stockDao.getSpecificCompany("PLLO");
        Assert.assertNotNull(result);
    }

    // TEST to update company's market cap and price per stock
        // Stock updateCompany(Stock updatedCompany);
    @Test
    public void updateMarketCap(){
        Stock updatedMarketCap = new Stock(12, "Umbrella Corporation", "UMBR", "We are definitely NOT evil.", "C:/Users/orian/preonboarding-projects/database-scripts/images/umbr.jpg", 60, 10, 600);
        Stock result = stockDao.updateCompany(updatedMarketCap);
        Assert.assertEquals("UMBR", result.getTicker());
    }
    
}
