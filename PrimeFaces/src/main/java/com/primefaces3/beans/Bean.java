/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primefaces3.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author olunia
 */
@ManagedBean(name="bean",eager=true)
@SessionScoped
public class Bean{
    
    private Integer number1;
    private Integer number2;
    
    private String name;
    private String surname;
    private double gradesAvg;
    private static final ArrayList<Student> students
            = new ArrayList<Student>(Arrays.asList(
            new Student("Aleksandra","Nowak",4.8),
                    new Student("Mateusz","Kowalski",3.7),
                    new Student("Jan","Lewek",4.2)
            ));
    
    private boolean sortGradesAscending = true;
    private boolean sortSurnameAscending = true;
    
    
    
    public Bean() {
    }

    /**
     * @return the number1
     */
    public Integer getNumber1() {
        return number1;
    }

    /**
     * @param number1 the number1 to set
     */
    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    /**
     * @return the number2
     */
    public Integer getNumber2() {
        return number2;
    }

    /**
     * @param number2 the number2 to set
     */
    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }
    
    public Integer calculate() {
        Integer sum = null;
        
        if (getNumber1() != null && getNumber2() != null) 
            sum = (Integer) getNumber1()+getNumber2();
        else
            sum = 0;
        
        return sum;
    }

    public String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);
    }
    
    public void getGrowlMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(this.getNumber1() + "+" + this.getNumber2() + "=" + this.calculate()));
    }

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }
    
    public String addStudent() {		 
      Student student = new Student(name,surname,gradesAvg);
      students.add(student);
      return null;
   }

   public String deleteStudent(Student student) {
      students.remove(student);		
      return null;
   }
    
   public String sortBySurname() {
       
       if (this.sortSurnameAscending) {
        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                return s2.getSurname().compareTo(s1.getSurname());
            }
        });
        this.sortSurnameAscending = false;
       } else {
            Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                return s1.getSurname().compareTo(s2.getSurname());
            }
        });
        this.sortSurnameAscending = true;
       }
       return null;
   }
   
      public String sortByGradesAvg() {
          
          if (this.sortGradesAscending) {
            Collections.sort(students, new Comparator<Student>() {

                @Override
                public int compare(Student s1, Student s2) {
                    return Double.compare(s1.getGradesAvg(),s2.getGradesAvg());
                }
            });
            this.sortGradesAscending = false;
          } else {
                Collections.sort(students, new Comparator<Student>() {

                @Override
                public int compare(Student s1, Student s2) {
                    return Double.compare(s2.getGradesAvg(),s1.getGradesAvg());
                }
            });
            this.sortGradesAscending = true;
          }
       return null;
       
   }
}
