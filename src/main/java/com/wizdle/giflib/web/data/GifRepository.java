/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizdle.giflib.web.data;

import com.wizdle.giflib.web.model.Gif;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author cmoten
 */
@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "Chris Ramacciotti", LocalDate.of(2015,2,13), false),
            new Gif("ben-and-mike", "Ben Jakuben", LocalDate.of(2015,10,30), true),
            new Gif("book-dominos", "Craig Dennis", LocalDate.of(2015,9,15), false),
            new Gif("compiler-bot", "Ada Lovelace", LocalDate.of(2015,2,13), true),
            new Gif("cowboy-coder", "Grace Hopper", LocalDate.of(2015,2,13), false),
            new Gif("infinite-andrew", "Marissa Mayer", LocalDate.of(2015,8,23), true)
    );
    
    public Gif findByName(String name){
        for(Gif gif : ALL_GIFS){
            if(gif.getName().equals(name))
                return gif;
        }
        return null;
    }
    
    public List<Gif> getAllGifs(){
        return ALL_GIFS;
    }
}
