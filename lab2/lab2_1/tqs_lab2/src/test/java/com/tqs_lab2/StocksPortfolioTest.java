package com.tqs_lab2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    @Mock
    StockmarketService stockService;

    @InjectMocks
    StocksPortfolio portfolio;

    @Test
    void testGetTotalValue(){
        Stock stock1 = new Stock("STOCK1", 1);
        Stock stock2 = new Stock("STOCK2", 2);

        portfolio.addStock(stock1);
        portfolio.addStock(stock2);
        
        when(stockService.lookUpPrice("STOCK1")).thenReturn(1.0);
        when(stockService.lookUpPrice("STOCK2")).thenReturn(2.0);

        double result = portfolio.getTotalValue();

        assertEquals(5, result);
        verify(stockService, times(2)).lookUpPrice(anyString());
    }

}
