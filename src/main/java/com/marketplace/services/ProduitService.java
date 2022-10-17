package com.marketplace.services;

import com.marketplace.models.Produits;

import java.util.List;

public interface ProduitService  {

    public void DeleteProduits(String id);
    public Produits SaveProduits(Produits produits);
    public List<Produits> getAllProduits();
    public Produits UpdateProduits(Produits produits, String id);
}


