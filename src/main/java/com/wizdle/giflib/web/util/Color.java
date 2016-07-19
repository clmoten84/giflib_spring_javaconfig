/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wizdle.giflib.web.util;

/**
 *
 * @author cmoten
 */
public enum Color {
    AQUA("Aqua", "#59b3b3"),
    BLUE("Blue", "#5976b3"),
    PURPLE("Purple", "#7e59b3"),
    FUCHSIA("Fuchsia", "#b35986"),
    ORANGE("Orange", "#b36859"),
    GOLD("Gold", "#b38f59");
    
    private final String name;
    private final String hexCode;
    
    Color(String name, String hexCode){
        this.name = name;
        this.hexCode = hexCode;
    }
    
    public String getName() { return name; }
    public String getHexCode() { return hexCode; }
}
