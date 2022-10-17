package com.marketplace.repository;

import com.marketplace.models.Categories;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategorieRepository extends MongoRepository<Categories,String> {

    public List<Categories> findAll();
    public void deleteById(String id);
    public Categories getCategoriesById(String id);
    public Categories findAllById(String id);
}

















