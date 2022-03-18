package com.tqs_lab2;

import java.util.List;

public class StocksPortfolio{
   private StockmarketService stockService;
   private List<Stock> stocks;


   public StocksPortfolio(StockmarketService stockService) {
      this.stockService = stockService;
   }

   public void addStock(Stock stock){
      this.stocks.add(stock);
   }

   public double getTotalValue(){
      double marketValue = 0.0;
      
      for(Stock stock : this.stocks){
         marketValue += this.stockService.lookUpPrice(stock.getLabel()) * stock.getQuantity();
      }
      return marketValue;
   }
}