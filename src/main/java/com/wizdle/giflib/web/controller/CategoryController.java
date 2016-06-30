/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizdle.giflib.web.controller;

import com.wizdle.giflib.web.data.CategoryRepository;
import com.wizdle.giflib.web.data.GifRepository;
import com.wizdle.giflib.web.model.Category;
import com.wizdle.giflib.web.model.Gif;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author cmoten
 */
@Controller
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepo;
    
    @Autowired
    private GifRepository gifRepo;
    
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String listCategories(ModelMap modelMap){
        List<Category> allCategories = categoryRepo.getAllCategories();
        modelMap.put("categories", allCategories);
        return "categories.html";
    }
    
    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    public String categoryDetails(@PathVariable int categoryId, ModelMap modelMap){
        Category category = categoryRepo.findById(categoryId);
        List<Gif> gifs = gifRepo.findByCategoryId(categoryId);
        
        modelMap.put("category", category);
        modelMap.put("gifs", gifs);
        return "category.html";
    }
}
