package com.example.SYLIVESTER.MAGOMA.serviceImpl;

import com.example.SYLIVESTER.MAGOMA.exception.MarketException;
import com.example.SYLIVESTER.MAGOMA.repository.Market;
import com.example.SYLIVESTER.MAGOMA.repository.MarketRepository;
import com.example.SYLIVESTER.MAGOMA.service.MarketService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "marketTable")
@Service
public class MarketServiceImpl implements MarketService {
    public MarketServiceImpl (MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    private MarketRepository marketRepository;


    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "narketID")

    int marketID;
    @Column(name = "firstName")
    string firstNmae;
    @Column(name = "lastName")
    string lastName;
    @Column(name = "location")
    string location;

    @Override
    public Market addMarket (Market market) {
        return marketRepository.save(market);
    }

    @Override
    public List<Market> getAllMarket () {
        return marketRepository.findAll();
    }

    @Override
    public Market getMarketById (Long id) {
        Market market = (Market) marketRepository.findAllById(id)
                .orElseThrow(()->new MarketException("Market not found"));
        return market;

    }

    @Override
    public Market updateMarket (Long id, Market market) {
        Market existingMarket = marketRepository.findById(id)
                .orElseThrow(()-> new MarketException("Market not found"));
                existingMarket.getMarketID(market.getMarketID());
                existingMarket.getFirstName(market.getFirstName());
                existingMarket.getFirstName(market.getLastName());
                existingMarket.setLocation(market.getLocation());

                Market updateMarket = MarketRepository.saveMarket(existingMarket);
        return updateMarket;
    }

    @Override
    public Void deleteMarket (Long id) {
        Market deleteMarket = marketRepository.findById(id)
                .orElseThrow(()-> new MarketException("Not found"));

        marketRepository.delete(deleteMarket);
        return null;
    }
}
