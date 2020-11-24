/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Depot {
    private int id;
    private double montant;
    private LocalDate createAt;

    public Depot() {
    }

    public Depot(double montant) {
        this.montant = montant;
        this.createAt = LocalDate.now();
    }

    public Depot(int id, double montant, LocalDate createAt) {
        this.id = id;
        this.montant = montant;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }  
    
}
