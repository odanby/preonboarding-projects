package stock.service;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import stock.entities.Stock;
import stock.exceptions.InvalidInputException;
import stock.repository.StockDAO;
import stock.repository.StockDAOInterface;

public class StockServiceTests {

    public static StockDAOInterface stockDao;
    public static StockServiceInterface stockService;
    public static StockDAOInterface mockDao;
    public static StockServiceInterface mockService;

    @BeforeClass
    public static void setup(){
        stockDao = new StockDAO();
        stockService = new StockService(stockDao);
        mockDao = Mockito.mock(StockDAO.class);
        mockService = new StockService(mockDao);
    }

    @Test
    public void serviceGetAllTickersPositive(){
        List<Stock> result = stockService.serviceGetAllTickers();
        Assert.assertNotNull(result);
    }

    @Test
    public void filterMarketCapPositive(){
        List<Stock> result = stockService.serviceTickerMarketCap(9000);
        Assert.assertNotNull(result);
    }

    // i am struggling to get these negative tests for the following 4 methods done. but also this will be handled with javascript so im gonna move on for now
    
    // @Test
    // public void filterMarketCapNegative(){
    //     int market_cap = -9000;
    //     Mockito.when(stockService.serviceTickerMarketCap(market_cap)).thenThrow(new InvalidInputException("Invalid Input"));
    //     mockService.serviceTickerMarketCap(market_cap);
    // }

    @Test
    public void filterAmountStocksPositive(){
        List<Stock> result = stockService.serviceTickerAmountStocks(50);
        Assert.assertNotNull(result);
    }


    @Test
    public void filterPriceStockPositive(){
        List<Stock> result = stockService.serviceTickerPriceStock(200);
        Assert.assertNotNull(result);
    }

    @Test
    public void getSpecificCompanyPositive(){
        List<Stock> result = stockService.serviceGetSpecificCompany("PLLO");
        Assert.assertNotNull(result);
    }

    @Test
    public void updateMarketCapPositive(){
        Stock updatedMarketCap = new Stock(12, "Umbrella Corporation", "UMBR", "We are definitely NOT evil.", "C:/Users/orian/preonboarding-projects/database-scripts/images/umbr.jpg", 60, 10, 600);
        Stock result = stockService.serviceUpdateCompany(updatedMarketCap);
        Assert.assertEquals("UMBR", result.getTicker());
    }
    
    @Test
    public void updatedMarketCapNegative(){
        try{
            Stock badUpdate = new Stock(12, "Umbrella Corporation", "UMBR", "We are definitely NOT evil.", "C:/Users/orian/preonboarding-projects/database-scripts/images/umbr.jpg", 60, 0, -600); 
            Mockito.when(mockService.serviceUpdateCompany(badUpdate));
            Assert.fail();
        } catch(InvalidInputException e){
            Assert.assertEquals("Invalid Input", e.getMessage());
        }
    }
}
