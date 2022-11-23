package stock.service;

import java.util.List;

import stock.entities.Stock;
import stock.exceptions.InvalidInputException;
import stock.repository.StockDAOInterface;

public class StockService implements StockServiceInterface {

    private StockDAOInterface stockDao;

    public StockService(StockDAOInterface stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    public List<Stock> serviceGetAllTickers() {
        return this.stockDao.getAllTickers();
    }

    @Override
    public List<Stock> serviceTickerMarketCap(int market_cap) {
        if(market_cap <= 0){
            throw new InvalidInputException("Invalid Input: Market Cap cannot be zero or a negative amount.");
        }
        return this.stockDao.tickerMarketCap(market_cap);
    }

    @Override
    public List<Stock> serviceTickerAmountStocks(int amount_stocks) {
        if(amount_stocks <= 0){
            throw new InvalidInputException("Invalid Input: Amount of Stocks cannot be zero or a negative amount.");
        }
        return this.stockDao.tickerAmountStocks(amount_stocks);
    }

    @Override
    public List<Stock> serviceTickerPriceStock(int price_per_stock) {
        if(price_per_stock <= 0){
            throw new InvalidInputException("Invalid Input: Price of Stocks cannot be zero or a negative amount.");
        }
        return this.stockDao.tickerPriceStock(price_per_stock);
    }

    @Override
    public List<Stock> serviceGetSpecificCompany(String ticker) {
        if (ticker.isEmpty()) {
            throw new InvalidInputException("Invalid Input: Empty Ticker");
        } 
        return this.stockDao.getSpecificCompany(ticker);
    }

    @Override
    public Stock serviceUpdateCompany(Stock updatedCompany) {
        if (updatedCompany.getPrice_per_stock() <= 0) {
            throw new InvalidInputException("Invalid Input");
        } else if (updatedCompany.getMarket_cap() <= 0) {
            throw new InvalidInputException("Invalid Input");
        }
        return this.stockDao.updateCompany(updatedCompany);
    }
    
}
