/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Compte;
import models.Depot;

/**
 *
 * @author anne-
 */
public class CompteDao implements IDao<Compte> {
    private List<Compte> tableCompte;
    PartenaireDao daoPart;

    public CompteDao() {
        daoPart = new PartenaireDao();
        Compte cpt = new Compte (1, "Num1", 500000, daoPart.selectAll().get(0));
        cpt.getDepots().add(new Depot(50000));
        cpt.getDepots().add(new Depot(100000));
        tableCompte = new ArrayList<>(
                
        Arrays.asList(
               cpt,
                    new Compte (2, "Num2", 700000, daoPart.selectAll().get(0)),
                      new Compte (3, "Num3", 200000, daoPart.selectAll().get(0)),
                        new Compte (4, "Num3", 500000, daoPart.selectAll().get(1))
        ));
        
    }
     private static int nombreCompte=4;
   
    //ajouter
    @Override
    public Compte add(Compte compte) {
        //Générer ID
        compte.setId(++nombreCompte);
        compte.setNumero("Num"+nombreCompte);
        tableCompte.add(compte);
        return compte;
    }
   
    //show
    @Override
    public List<Compte> selectAll() {
        return tableCompte;
    }
}
