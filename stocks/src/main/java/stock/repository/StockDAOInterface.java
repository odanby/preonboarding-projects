package stock.repository;

import java.util.List;

import stock.entities.Stock;

public interface StockDAOInterface {

    // retrieve all tickers
    List<Stock> getAllTickers();

    // filter tickers by market cap
    List<Stock> tickerMarketCap(int market_cap);

    // filter tickers by amount of stocks
    List<Stock> tickerAmountStocks(int amount_stocks);

    // filter tickers by price of stocks
    List<Stock> tickerPriceStock(int price_per_stock);

    // retrieve company by ticker
    List<Stock> getSpecificCompany(String ticker);

    // update company's market cap and price per stock
    Stock updateCompany(Stock updatedCompany);

}
