package com.babilonia.Babilonia.model;

public class Person {
    private Integer birth_year;
    private Integer death_year;
    private String name;

    //Getters

    public Integer getBirth_year() {
        return birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public String getName() {
        return name;
    }

    //Setters

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }

    public void setName(String name) {
        this.name = name;
    }
}
