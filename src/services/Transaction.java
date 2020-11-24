/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CompteDao;
import models.Compte;
import models.Partenaire;
import models.User;
import dao.PartenaireDao;
import java.util.List;
import java.util.stream.Collectors;
import models.Depot;
/**
 *
 * @author ASUS
 */
public class Transaction {
    
    PartenaireDao daoPartenaire; 
    CompteDao daoCompte;

    public Transaction() {
        this.daoPartenaire = new PartenaireDao();
        this.daoCompte = new CompteDao();
    }
    
    public Compte addCompteTransaction (Compte compte) {
        if (compte.getPartenaire().getId() == 0) {
            this.addComptePartenaire(compte.getPartenaire());
        }
        compte = daoCompte.add(compte);
        this.setDepot(compte, compte.getSolde());
        return compte;
    }
     
    public Partenaire addComptePartenaire (Partenaire part) {
        return daoPartenaire.add(part);
    }
    
     public User addCompteConnexion (User user ) {
        return null;
    }
     
     public Compte setDepot (Compte compte, double mnt) {
        Depot depot = new Depot(mnt);
        compte.getDepots().add(depot);
        return compte;
    }
     
     public Partenaire getPartenaireByCni (String nci) {
       List<Partenaire> partenaires = daoPartenaire.selectAll();
       for (Partenaire part: partenaires) {
           if (part.getNci().compareTo(nci) == 0) {
               return part;
           }
       }
       return null;
    }
     
     public List<Compte> getCompteByPartenaire(Partenaire part) {
        List<Compte> comptes = daoCompte.selectAll();
        return comptes.stream().filter((cpt) -> cpt.getPartenaire().getId() == part.getId()).collect(Collectors.toList()) ; 
     }
}
