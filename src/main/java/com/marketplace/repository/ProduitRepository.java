package com.marketplace.repository;

import com.marketplace.models.Produits;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProduitRepository extends MongoRepository<Produits,String> {
    public List<Produits> findAll();
    public void deleteById(String id);
    public Produits getProduitsById(String id);
}















