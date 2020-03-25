package com.example.lab3_a.entity;

import java.io.Serializable;
//Класс животных
public class Animal implements Serializable {
    //картинка животного
    private int image;
    //имя
    private String name;
    //класс
    private String species;
    //описание
    private int description;

    public Animal(int image, String name, String species, int description) {
        this.image = image;
        this.name = name;
        this.species = species;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}
