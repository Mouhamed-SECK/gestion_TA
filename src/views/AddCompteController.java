/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Compte;
import models.Partenaire;
import services.Transaction;
import views.utils.Utils;

/**
 *
 * @author ASUS
 */
public class AddCompteController implements Initializable {
    
    Partenaire part;
    
    private Label label;
    
    @FXML
    private TextField txtNci;
    
    private Transaction service;
    @FXML
    private TextField txtNomPrenom;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextField txtAdress;
    @FXML
    private TextField txtLogin;                   
   
    @FXML
    private TextField txtSolde;
    @FXML
    private TableView<Compte> tblvCompte;
    @FXML
    private TableColumn<Compte, String> tblcNumero;
    @FXML
    private TableColumn<Compte, String> tblcSolde;
    
    private ObservableList<Compte> oblComptes;
    @FXML
    private PasswordField txtMdp;
                         
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          service = new Transaction();
    }    

    @FXML
    private void handleSearchPartenaire() {
        oblComptes = Utils.searchPartenaire(txtNci, txtNomPrenom, txtTelephone, txtAdress, txtLogin, txtMdp, part, oblComptes, service, tblvCompte, tblcNumero, tblcSolde);
    }
    
    

    @FXML
    private void handleCreateCompte() {
        double solde = Double.parseDouble(txtSolde.getText()); 
        if (part == null) {
            String nomComplet = txtNomPrenom.getText();
            String adresse =  txtAdress.getText();
            String nci = txtNci.getText();
            String tel = txtTelephone.getText();
            String login = txtLogin.getText();
            String pwd = txtMdp.getText();
            part = new Partenaire(nci, nomComplet, adresse, tel, login, pwd);
        }       
        Compte compte = new Compte("XXX2", solde, part);
        service.addCompteTransaction(compte);
        oblComptes.add(compte);
    }
    
   
}
