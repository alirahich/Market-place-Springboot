package com.marketplace.controllers;

import com.marketplace.services.ProduitService;
import com.marketplace.models.Produits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @PostMapping("ajtProduits")
    public Produits addProduits(@RequestBody Produits produits){
        return produitService.SaveProduits(produits);
    }
    @GetMapping("Produits")
    public List<Produits> produits(){
        return produitService.getAllProduits();
    }
    @DeleteMapping("/suppProd/{id}")
    public void DeleteCategorie(@PathVariable String id){
        produitService.DeleteProduits(id);
    }
    @PutMapping("/updateProd/{id}")
    public void UpdateCategories(@RequestBody Produits produits, @PathVariable String id){
        produitService.UpdateProduits(produits,id);
    }


}






