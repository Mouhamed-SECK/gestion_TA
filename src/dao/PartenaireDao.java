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
import models.Partenaire;

/**
 *
 * @author ASUS
 */
public class PartenaireDao implements IDao<Partenaire>{
    
    
    private List<Partenaire> tablePartenaire;

    public PartenaireDao() {
        this.tablePartenaire =  new ArrayList<>(
                Arrays.asList(
                        new Partenaire("xxx", "admin", "admin", "0", "admin", "admin "),
                         new Partenaire("xxx1", "admin2", "admin2", "1", "admin2", "admin2 ")
        ));
    }
    private static int nbrePartenaire;
    
    //ajouter
   
    @Override
    public Partenaire add(Partenaire partenaire){
        //Générer ID
        partenaire.setId(++nbrePartenaire);
        tablePartenaire.add(partenaire);
       
        return partenaire;
    }
   
    //show
    @Override
    public List<Partenaire> selectAll(){
        return this.tablePartenaire;
    }
    
    
    
}
