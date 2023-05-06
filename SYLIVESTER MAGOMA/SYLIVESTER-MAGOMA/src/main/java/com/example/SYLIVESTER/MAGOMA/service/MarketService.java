package com.example.SYLIVESTER.MAGOMA.service;

import com.example.SYLIVESTER.MAGOMA.repository.Market;
import com.example.SYLIVESTER.MAGOMA.repository.MarketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface MarketService {
    Market addMarket(Market market);
    List<Market> getAllMarket();
    Market getMarketById(Long id);
    Market updateMarket(Long id, Market market);

    Void deleteMarket(Long id);
}
