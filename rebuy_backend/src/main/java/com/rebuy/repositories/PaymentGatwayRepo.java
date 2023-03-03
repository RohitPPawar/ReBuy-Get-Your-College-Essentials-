package com.rebuy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.PaymentGateway;

public interface PaymentGatwayRepo extends JpaRepository<PaymentGateway, Integer> {

}
