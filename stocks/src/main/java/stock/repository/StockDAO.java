package stock.repository;

import java.util.List;

import stock.entities.Stock;
import stock.utils.HibernateUtil;

public class StockDAO implements StockDAOInterface {

    @Override
    public List<Stock> getAllTickers() {
        HibernateUtil.beginTransaction();
        List<Stock> requestList = HibernateUtil.getSession().createQuery("from Stock", Stock.class).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public List<Stock> tickerMarketCap(int market_cap) {
        HibernateUtil.beginTransaction();
        List<Stock> filterMarketCap = HibernateUtil.getSession().createQuery("from Stock where market_cap = :MarketCap", Stock.class).setParameter("MarketCap", market_cap).getResultList();
        HibernateUtil.endTransaction();
        return filterMarketCap;
    }

    @Override
    public List<Stock> tickerAmountStocks(int amount_stocks) {
        HibernateUtil.beginTransaction();
        List<Stock> filterAmountStocks = HibernateUtil.getSession().createQuery("from Stock where amount_stocks = :AmountStocks", Stock.class).setParameter("AmountStocks", amount_stocks).getResultList();
        HibernateUtil.endTransaction();
        return filterAmountStocks;
    }

    @Override
    public List<Stock> tickerPriceStock(int price_per_stock) {
        HibernateUtil.beginTransaction();
        List<Stock> filterPriceStock = HibernateUtil.getSession().createQuery("from Stock where price_per_stock = :PriceStock", Stock.class).setParameter("PriceStock", price_per_stock).getResultList();
        HibernateUtil.endTransaction();
        return filterPriceStock;
    }

    @Override
    public List<Stock> getSpecificCompany(String ticker) {
        HibernateUtil.beginTransaction();
        List<Stock> getSpecificCompany = HibernateUtil.getSession().createQuery("from Stock where ticker = :Ticker", Stock.class).setParameter("Ticker", ticker).getResultList();
        HibernateUtil.endTransaction();
        return getSpecificCompany;
    }

    @Override
    public Stock updateCompany(Stock updatedCompany) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(updatedCompany);
        HibernateUtil.endTransaction();
        return updatedCompany;
    }
    
}
