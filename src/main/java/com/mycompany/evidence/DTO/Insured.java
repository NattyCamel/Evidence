/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evidence.DTO;

import java.util.List;
import java.util.ArrayList;

public class Insured {
    final private String firstName;
    final private String lastName;
    final private int age;
    final private String phone;
    private List<CarInsurance> carInsurances;

    public Insured(String firstName, String lastName, int age, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.carInsurances = new ArrayList<>();
    }

    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public int getAge(){
        return age;
    }
    
    public String getPhone(){
        return phone;
    }

    public List<CarInsurance> getCarInsurances() {
        return carInsurances;
    }
    
    public void addCar(CarInsurance carInsurance) {
        carInsurances.add(carInsurance);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Jmeno: ").append(firstName).append(", Prijmeni: ").append(lastName).append(", Vek: ").append(age)
                .append(", Telefon: ").append(phone);
        
        return sb.toString();
    }
}