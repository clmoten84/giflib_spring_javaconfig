package com.wizdle.giflib.web.model;

import java.time.LocalDate;

/**
 * Gif object model
 * @author cmoten
 */
public class Gif {
    private String name;
    private String uploadedBy;
    private LocalDate uploadedDate;
    private boolean favorite;
    private int categoryId;
    
    public Gif(){}
    
    public Gif(String name, String uploadedBy, LocalDate uploadedDate, boolean favorite, int categoryId){
        this.name = name;
        this.uploadedBy = uploadedBy;
        this.uploadedDate = uploadedDate;
        this.favorite = favorite;
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public LocalDate getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(LocalDate uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
    
    @Override
    public String toString(){
        return "Gif object\nName: " + this.getName()
                + "\nUploaded By: " + this.getUploadedBy()
                + "\nUploaded Date: " + this.getUploadedDate().toString()
                + "\nFavorited: " + this.isFavorite();
    }
}
