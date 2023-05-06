package com.example.SYLIVESTER.MAGOMA.controller;

import com.example.SYLIVESTER.MAGOMA.entity.market;
import com.example.SYLIVESTER.MAGOMA.repository.Market;
import com.example.SYLIVESTER.MAGOMA.service.MarketService;
import com.example.SYLIVESTER.MAGOMA.serviceImpl.MarketServiceImpl;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import java.util.List;

@RestController
@RestMapping("/g/marketTable")
public class MarketController {

    private MarketService marketService;
    private Object HttpStatus;

    public MarketController (MarketService marketService) {
        this.marketService = marketService;
    }
    @PostMapping
    public ResponseEntity<Market> addMarket(@RequestBody Market market){
       Market add = marketService.addMarket(market);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }
    GetMapping()
    public List<Market> getAllMarket(){
        return marketService.getAllMarket();
    }
    @GetMapping("{id}")
    public ResponseEntity<Market> getMarketById(Long id){
        return new ResponseEntity<>(MarketService.getMarket(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<market> update(@PathVariable Long id,@RequestBody Market market){
        return new ResponseEntity<>(marketService.updateMarket(id, market), HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Market> deleteMarket(@PathVariable Long id){
        return new ResponseEntity<>(marketService.deleteMarket(id), HttpStatus.OK);
    }
    end:1:39:32
}
