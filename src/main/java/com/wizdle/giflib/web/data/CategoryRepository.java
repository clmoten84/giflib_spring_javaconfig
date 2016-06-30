/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizdle.giflib.web.data;

import com.wizdle.giflib.web.model.Category;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cmoten
 */
@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATS = Arrays.asList(
            new Category(1, "funny"),
            new Category(2, "robots"),
            new Category(3, "treehouseguys")
    );
    
    public Category findByName(String name){
        for(Category category : ALL_CATS){
            if(category.getName().equals(name))
                return category;
        }
        return null;
    }
    
    public Category findById(int id){
        for(Category category : ALL_CATS){
            if(category.getId() == id)
                return category;
        }
        return null;
    }
    
    public List<Category> getAllCategories(){
        return ALL_CATS;
    }
}
