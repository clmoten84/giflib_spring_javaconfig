/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizdle.giflib.web.data;

import com.wizdle.giflib.web.model.Gif;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author cmoten
 */
@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "Chris Ramacciotti", LocalDate.of(2015,2,13), false, 2),
            new Gif("ben-and-mike", "Ben Jakuben", LocalDate.of(2015,10,30), true, 3),
            new Gif("book-dominos", "Craig Dennis", LocalDate.of(2015,9,15), false, 1),
            new Gif("compiler-bot", "Ada Lovelace", LocalDate.of(2015,2,13), true, 2),
            new Gif("cowboy-coder", "Grace Hopper", LocalDate.of(2015,2,13), false, 1),
            new Gif("infinite-andrew", "Marissa Mayer", LocalDate.of(2015,8,23), true, 3)
    );
    
    public Gif findByName(String name){
        for(Gif gif : ALL_GIFS){
            if(gif.getName().equals(name))
                return gif;
        }
        return null;
    }
    
    public List<Gif> findByCategoryId(int categoryId){
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS){
            if(gif.getCategoryId() == categoryId)
                gifs.add(gif);
        }
        return gifs;
    }
    
    public List<Gif> findAllFavorites(){
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS){
            if(gif.isFavorite())
                gifs.add(gif);
        }
        return gifs;
    }
    
    public List<Gif> searchByName(String query){
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS){
            if(StringUtils.containsIgnoreCase(gif.getName(), query))
                gifs.add(gif);
        }
        return gifs;
    }
    
    public List<Gif> getAllGifs(){
        return ALL_GIFS;
    }
}
