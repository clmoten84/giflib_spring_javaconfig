/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizdle.giflib.web.controller;

import com.wizdle.giflib.web.data.GifRepository;
import com.wizdle.giflib.web.model.Gif;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for handling GIF related requests
 * @author cmoten
 */
@Controller
public class GifController {
    
    @Autowired
    private GifRepository gifRepository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listGifs(ModelMap modelMap){
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home.html";
    }
    
    @RequestMapping(value = "/gif/{name}", method = RequestMethod.GET)
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details.html";
    }
}
