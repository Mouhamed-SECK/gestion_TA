/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Compte;
import models.Depot;
import models.Partenaire;
import services.Transaction;
import views.utils.Utils;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DepotCompteController implements Initializable {
    
     Partenaire part;
      private Transaction service;

    @FXML
    private TextField txtNci;
    @FXML
    private TextField txtNomPrenom;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextField txtAdress;
    @FXML
    private TableView<Depot> tblvDepot;
    @FXML
    private TableColumn<Depot, Depot> tblcMnt;
    @FXML
    private TableColumn<Depot, String> tblcDate; 
 

    @FXML
    private TableView<Compte> tblvCompte;
    @FXML
    private TableColumn<Compte, String> tblcNumero;
    @FXML
    private TableColumn<Compte, String> tblcSolde;
    @FXML
    private TextField txtMnt;
    
     private ObservableList<Compte> oblComptes;
     
      private ObservableList<Depot> oblDepots;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        service = new Transaction();
    }    

    @FXML
    private void handleSearchPartenaire(ActionEvent event) {
          oblComptes = Utils.searchPartenaire(txtNci, txtNomPrenom, txtTelephone, txtAdress, part, oblComptes, service, tblvCompte, tblcNumero, tblcSolde);
    }

    @FXML
    private void handleCreateCompte(ActionEvent event) {
    }

    @FXML
    private void handleSelectRowTableView(MouseEvent event) {
        Compte cpt =tblvCompte.getSelectionModel().getSelectedItem();
        oblDepots = FXCollections.observableArrayList(cpt.getDepots());
         tblcDate.setCellValueFactory(new PropertyValueFactory<>("creatAt"));
          tblcMnt.setCellValueFactory(new PropertyValueFactory<>("mnt"));
          tblvDepot.setItems(oblDepots);
    }
    
}
