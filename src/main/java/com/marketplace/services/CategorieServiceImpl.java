package com.marketplace.services;

import com.marketplace.models.Categories;
import com.marketplace.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService{
    @Autowired
    private CategorieRepository categorieRepository;
    @Override
    public void DeleteCategorie(String id) {
        categorieRepository.deleteById(id);

    }

    @Override
    public List<Categories> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categories SaveCategories(Categories categories) {
        return categorieRepository.save(categories);
    }

    @Override
    public Categories UpdateCategories(Categories categories, String id) {
        Categories cat= new Categories();
        cat = categorieRepository.findById(id).get();
        if (categories.getNom() != null){
            cat.setNom(categories.getNom());
        }
        if (categories.getDescription() != null){
            cat.setDescription(categories.getDescription());
        }
        System.out.println(cat);
        return categorieRepository.save(cat);
    }
}



