package com.marketplace.repository;

import com.marketplace.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PaymentRepository extends MongoRepository<Payment,String> {

    public List<Payment> findAllByFrom(String from);
    public List<Payment> findAllByTo(String to);
    public List<Payment> findAllByProduit(String produit);

}















