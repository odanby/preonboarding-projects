package stock.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {

    // these fields represent the data in my database
    @Id
    @GeneratedValue
    private int id;
    private String company_name;
    private String ticker;
    private String description;
    private String image_url;
    private int amount_stocks;
    private int price_per_stock;
    private int market_cap;
    
    // an empty constructor
    public Stock(){};

    // full constructor
    public Stock(int id, 
                String company_name, 
                String ticker, 
                String description, 
                String image_url, 
                int amount_stocks,
                int price_per_stock,
                int market_cap){
                    this.id = id;
                    this.company_name = company_name;
                    this.ticker = ticker;
                    this.description = description;
                    this.image_url = image_url;
                    this.amount_stocks = amount_stocks;
                    this.price_per_stock = price_per_stock;
                    this.market_cap = market_cap;
                }

    // partial constructor without id
    public Stock(String company_name, 
                String ticker, 
                String description, 
                String image_url, 
                int amount_stocks,
                int price_per_stock,
                int market_cap){
                    this.company_name = company_name;
                    this.ticker = ticker;
                    this.description = description;
                    this.image_url = image_url;
                    this.amount_stocks = amount_stocks;
                    this.price_per_stock = price_per_stock;
                    this.market_cap = market_cap;
                }

    // purchasing stocks constructor
    public Stock(String ticker, 
                int amount_stocks,
                int price_per_stock){
                    this.ticker = ticker;
                    this.amount_stocks = amount_stocks;
                    this.price_per_stock = price_per_stock;
                }


    // updating market cap constructor
    public Stock(String ticker, 
                int amount_stocks,
                int price_per_stock,
                int market_cap){
                    this.ticker = ticker;
                    this.amount_stocks = amount_stocks;
                    this.price_per_stock = price_per_stock;
                    this.market_cap = market_cap;
                }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getAmount_stocks() {
        return amount_stocks;
    }

    public void setAmount_stocks(int amount_stocks) {
        this.amount_stocks = amount_stocks;
    }

    public int getPrice_per_stock() {
        return price_per_stock;
    }

    public void setPrice_per_stock(int price_per_stock) {
        this.price_per_stock = price_per_stock;
    }

    public int getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(int market_cap) {
        this.market_cap = market_cap;
    }

    @Override
    public String toString() {
        return "Stock [id=" + id 
                    + ", company_name=" + company_name 
                    + ", ticker =" + ticker 
                    + ", description =" + description 
                    + ", image_url =" + image_url 
                    + ", amount_stocks =" + amount_stocks 
                    + ", price_per_stock =" + price_per_stock 
                    + ", market_cap=" + market_cap + "]";
    }
}
