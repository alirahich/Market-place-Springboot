package com.marketplace.controllers;

import com.marketplace.models.Categories;
import com.marketplace.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategorieService categorieService;
    @PostMapping("/ajtCategorie")
    public Categories addCategory(@RequestBody Categories categories){
        return categorieService.SaveCategories(categories);
    }
    @GetMapping("/Categories")
    public List<Categories> Categories(){
        return categorieService.getAllCategories();
    }
    @DeleteMapping("/suppCat/{id}")
    public void DeleteCategorie(@PathVariable String id){
        categorieService.DeleteCategorie(id);
    }
    @PutMapping("/updateCat/{id}")
    public void UpdateCategories(@RequestBody Categories categories,@PathVariable String id){
        categorieService.UpdateCategories(categories,id);
    }


}
