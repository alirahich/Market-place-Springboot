package com.marketplace.services;

import com.marketplace.models.Categories;

import java.util.List;

public interface CategorieService {

    public void DeleteCategorie(String id);
    public List<Categories> getAllCategories();
    public Categories SaveCategories(Categories categories);
    public Categories UpdateCategories(Categories categories, String id);
}

















