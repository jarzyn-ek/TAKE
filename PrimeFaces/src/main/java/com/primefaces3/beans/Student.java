/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primefaces3.beans;

/**
 *
 * @author olunia
 */
public class Student {
    
    private String name;
    private String surname;
    private double gradesAvg;
    
    public Student(String name, String surname, double gradesAvg) {
        this.name = name;
        this.surname = surname;
        this.gradesAvg = gradesAvg;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the gradesAvg
     */
    public double getGradesAvg() {
        return gradesAvg;
    }

    /**
     * @param gradesAvg the gradesAvg to set
     */
    public void setGradesAvg(double gradesAvg) {
        this.gradesAvg = gradesAvg;
    }
    
    
    
}
