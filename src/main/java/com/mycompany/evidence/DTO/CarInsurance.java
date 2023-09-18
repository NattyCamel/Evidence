/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evidence.DTO;

import java.text.DecimalFormat;

/**
 *
 * @author Kamil
 */
public class CarInsurance {
    private static final DecimalFormat currencyFormatter = new DecimalFormat("0.00 CZK");
    
    final private int carManufactureYear;
    final private double maxAmount;

    public CarInsurance(int carManufactureYear, double maxAmount) {
        this.carManufactureYear = carManufactureYear;
        this.maxAmount = maxAmount;
    }

    public int getCarManufactureYear() {
        return carManufactureYear;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Rok vyroby: ")
                .append(carManufactureYear)
                .append(", Maximalni castka: ")
                .append(currencyFormatter.format(maxAmount));
        
        return sb.toString();
    }
}

