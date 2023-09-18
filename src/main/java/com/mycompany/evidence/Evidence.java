/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.evidence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mycompany.evidence.DTO.Insured;
import com.mycompany.evidence.DTO.CarInsurance;

/**
 *
 * @author Kamil
 */
public class Evidence {
    private static final Scanner scanner = new Scanner(System.in);

    private List<Insured> insuredPersons;

    public Evidence() {
        insuredPersons = new ArrayList<>();
    }

    public void addInsured(Insured insuredPerson) {
        insuredPersons.add(insuredPerson);
        System.out.println("Data byla ulozena.");
    }

    public void exportAllToConsole() {
        System.out.println("-----------------------------");
        System.out.println("Evidence vsech");
        System.out.println("-----------------------------");
        for (Insured insuredPerson : insuredPersons) {
            exportPersonToConsole(insuredPerson);
        }
    }
    
    public void exportPersonToConsole(Insured insuredPerson) {
        System.out.println(insuredPerson);
          
        List<CarInsurance> insuredCars = insuredPerson.getCarInsurances();

        for (CarInsurance carInsurance : insuredCars) {
            System.out.println(carInsurance);
        }
        
        System.out.println(System.lineSeparator());
    }
    
    public void searchInsuredPerson(String firstName, String lastName) {
        System.out.println("-----------------------------");
        System.out.println("Evidence pojistenych");
        System.out.println("-----------------------------");
        for (Insured insuredPerson : insuredPersons) {
            if (insuredPerson.getFirstName().equalsIgnoreCase(firstName) && insuredPerson.getLastName().equalsIgnoreCase(lastName)) {
                exportPersonToConsole(insuredPerson);
                return;
            }
        }
        System.out.println("Pojisteny s danym jmenem a prijmenim nebyl nalezen.");
    }
    
    public CarInsurance importCarFromConsole() {
        System.out.println("Zadejte rok vyroby:");
        int carManufactureYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Zadejte maximalni castku:");
        double maxAmount = Double.parseDouble(scanner.nextLine());

        CarInsurance carInsurance = new CarInsurance(carManufactureYear, maxAmount);

        return carInsurance;
    }
            
            

    public static void main(String[] args) {
        Evidence evidence = new Evidence();
        int option;

        do {
            System.out.println("----------------------------");
            System.out.println("Evidence pojistenych");
            System.out.println("----------------------------");
            System.out.println("Vyberte si akci:");
            System.out.println("1 – Pridat noveho pojisteneho");
            System.out.println("2 – Vypsat vshechny pojistene");
            System.out.println("3 – Vyhledat pojisteneho");
            System.out.println("4 – Konec");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Zadejte jmeno pojisteneho:");
                    String firstName = scanner.nextLine();
                    
                    System.out.println("Zadejte prijmeni:");
                    String lastName = scanner.nextLine();
                    
                    System.out.println("Zadejte telefonni cislo:");
                    String phone = scanner.nextLine();
                    
                    System.out.println("Zadejte vek:");
                    int age = Integer.parseInt(scanner.nextLine());
                    
                    Insured newInsuredPerson = new Insured(firstName, lastName, age, phone);
                    
                    int carOption;
                    
                    do {
                        System.out.println("Chcete pojistit vuz?:");
                        System.out.println("1 – Ano");
                        System.out.println("2 – Ne");
                        carOption = Integer.parseInt(scanner.nextLine());

                        if (carOption == 1) {
                            CarInsurance carInsurance = evidence.importCarFromConsole();
                            newInsuredPerson.addCar(carInsurance);
                        }
                    } while (carOption != 2);
                    

                    evidence.addInsured(newInsuredPerson);
                    break;

                case 2:
                    evidence.exportAllToConsole();
                    break;

                case 3:
                    System.out.println("Zadejte jmeno:");
                    firstName = scanner.nextLine();
                    System.out.println("Zadejte prijmeni:");
                    lastName = scanner.nextLine();
                    evidence.searchInsuredPerson(firstName, lastName);
                    break;

                case 4:
                    System.out.println("Konec programu.");
                    break;

                default:
                    System.out.println("Neplatna volba.");
            }
        } while (option != 4);
    }
}
