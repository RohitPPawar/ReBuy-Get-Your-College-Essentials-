package com.rebuy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebuy.model.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Integer> {

}
