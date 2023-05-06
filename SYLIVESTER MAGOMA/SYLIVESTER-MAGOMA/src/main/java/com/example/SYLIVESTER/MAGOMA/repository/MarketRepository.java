package com.example.SYLIVESTER.MAGOMA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market,Long> {
    static Market saveMarket (Market existingMarket) {
        return existingMarket;
    }

    Optional<Object> findAllById (Long id);
}
