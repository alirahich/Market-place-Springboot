package com.marketplace.services;

import com.Auth.Entities.AppUser;
import com.Auth.Repository.AppUserRepository;
import com.marketplace.models.Produits;
import com.marketplace.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    public void DeleteProduits(String id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produits SaveProduits(Produits produits) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser appUser = appUserRepository.findByUsername((String) auth.getPrincipal());
        System.out.println(appUser);
        produits.setUser(appUser.getId());
        return produitRepository.save(produits);
    }

    @Override
    public List<Produits> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produits UpdateProduits(Produits produits, String id) {
        Produits prod= new Produits();
        prod = produitRepository.findById(id).get();
        if (produits.getLabel() != null){
            prod.setLabel(produits.getLabel());
        }
        if (produits.getDescription() != null){
            prod.setDescription(produits.getDescription());
        }
        if (produits.getPrice() != prod.getPrice() ){
            prod.setPrice(produits.getPrice());
        }
        System.out.println(prod);
        return produitRepository.save(prod);
    }


}


