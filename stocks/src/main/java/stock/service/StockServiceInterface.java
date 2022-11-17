package stock.service;

import java.util.List;

import stock.entities.Stock;

public interface StockServiceInterface {
    
    // retrieve all tickers
    List<Stock> serviceGetAllTickers();

    // filter tickers by market cap
    List<Stock> serviceTickerMarketCap(int market_cap);

    // filter tickers by amount of stocks
    List<Stock> serviceTickerAmountStocks(int amount_stocks);

    // filter tickers by price of stocks
    List<Stock> serviceTickerPriceStock(int price_per_stock);

    // retrieve company by ticker
    List<Stock> serviceGetSpecificCompany(String ticker);

    // update company's market cap and price per stock
    Stock serviceUpdateCompany(Stock updatedCompany);
}
